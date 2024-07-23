package com.lqt.duynguyenhairsalon.Activities.Shopping.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;
import com.lqt.duynguyenhairsalon.Model.Adapters.PhotoAdapter;
import com.lqt.duynguyenhairsalon.Model.Adapters.ProductTabAdapter;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.Model.Photo;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class DetailProductActivity extends AppCompatActivity {

    //View
    private TextView textViewNameProduct;
    private TextView textViewPriceProduct;
    private TextView textViewAmountInCart;
    private TabLayout tabLayoutDetailProduct;
    private ViewPager2 viewPagerDetailProduct;
    private Button buttonAddCart;
    private Button buttonBuyNow;
    private FrameLayout frameLayoutCart;
    private ViewPager viewPagerSlider;
    private CircleIndicator circleIndicator;
    private ImageView imageView_RowBack;

    //Param
    private int ID_Product;
    private String ID_Producer;
    private int Amount_Product;
    private String Info_Product;
    private String Description_Product;
    private String Using_Product;
    private String Image_Product;
    private String urlProduct = Config.LOCALHOST + "GetProductWithID.php?ID_Product=";
    private String urlAmountCart = Config.LOCALHOST + "GetCart.php?ID_User=" + DataLocalManager.getPrefIdUser();
    private static final String TAG = DetailProductActivity.class.getName();
    private String urlAddProductToCart = Config.LOCALHOST + "InsertDesCart.php";
    private Timer timer;

    private int AmountInCart = 0;

    //List
    private List<Photo> photoList;

    //Adapter
    private ProductTabAdapter productTabAdapter;
    private PhotoAdapter photoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        initView();

        SetSlider();
        autoSlideImage();

        SetData();

        ListenActivity();
    }

    private void SetAmountInCart() {
        AmountInCart = 0;
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, urlAmountCart
                , null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response.length() == 0) {
                    textViewAmountInCart.setText("" + AmountInCart);
                } else {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject product = response.getJSONObject(i);
                            AmountInCart += product.getInt("Amount_Product");
                            textViewAmountInCart.setText("" + AmountInCart);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        });
        requestQueue.add(arrayRequest);
    }

    private void ListenActivity() {
        frameLayoutCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailProductActivity.this, CartActivity.class));
            }
        });

        imageView_RowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertProductToCart();
            }
        });

        buttonBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertProductToCart();

                // trì hoãn một hành động nào đó trong khoảng thời gian cố định
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(DetailProductActivity.this, CartActivity.class));
                    }
                }, 1000);
            }
        });
    }

    private void autoSlideImage() {
        if (photoList == null || photoList.isEmpty() || viewPagerSlider == null) {
            return;
        }

        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPagerSlider.getCurrentItem();
                        int totalItem = photoList.size() - 1;
                        if (currentItem < totalItem) {
                            currentItem++;
                            viewPagerSlider.setCurrentItem(currentItem);
                        } else {
                            viewPagerSlider.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 500, 3000);
    }

    private void SetSlider() {
        photoList = getListPhoto();

        photoAdapter = new PhotoAdapter(this, photoList);

        viewPagerSlider.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPagerSlider);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
    }

    private List<Photo> getListPhoto() {
        List<Photo> photos = new ArrayList<>();

        photos.add(new Photo(R.drawable.sp_demo));

        return photos;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        SetAmountInCart();
    }

    private void SetTabs() {
        tabLayoutDetailProduct.removeAllTabs();
        tabLayoutDetailProduct.addTab(tabLayoutDetailProduct.newTab().setText("Thông tin"));
        tabLayoutDetailProduct.addTab(tabLayoutDetailProduct.newTab().setText("Mô tả"));
        tabLayoutDetailProduct.addTab(tabLayoutDetailProduct.newTab().setText("Cách sử dụng"));

        productTabAdapter = new ProductTabAdapter(getSupportFragmentManager(), getLifecycle());

        viewPagerDetailProduct.setAdapter(productTabAdapter);

        //bấm vào tab
        tabLayoutDetailProduct.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerDetailProduct.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void SetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET
                , urlProduct + ID_Product
                , null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject product = response.getJSONObject(0);
                    textViewNameProduct.setText("" + product.getString("Name_Product"));
                    textViewPriceProduct.setText("đ" + product.getInt("Price_Product") / 1000 + ".000");
                    ID_Producer = product.getString("ID_Producer");
                    Amount_Product = product.getInt("Amount_Product");
                    Info_Product = product.getString("Info_Product");
                    Description_Product = product.getString("Description_Product");
                    Using_Product = product.getString("Using_Product");
                    Image_Product = product.getString("Image_Product");
                    SetTabs();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        });

        requestQueue.add(arrayRequest);
    }

    private void InsertProductToCart() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlAddProductToCart
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("successful")) {
                    Toast.makeText(DetailProductActivity.this, "Đã thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
                    SetAmountInCart();
                } else {
                    Toast.makeText(DetailProductActivity.this, "Lỗi! Vui lòng thử lại sau", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                param.put("ID_User", DataLocalManager.getPrefIdUser());

                param.put("ID_Product", "" + ID_Product);
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }


    public String getID_Producer() {
        return ID_Producer;
    }

    public String getInfo_Product() {
        return Info_Product;
    }

    public String getDescription_Product() {
        return Description_Product;
    }

    public String getUsing_Product() {
        return Using_Product;
    }

    private void initView() {
        textViewNameProduct = findViewById(R.id.textView_NameProduct);
        textViewPriceProduct = findViewById(R.id.textView_PriceProduct);
        textViewAmountInCart = findViewById(R.id.textView_AmountInCart);
        tabLayoutDetailProduct = findViewById(R.id.tabLayout_DetailProduct);
        viewPagerDetailProduct = findViewById(R.id.viewPager_DetailProduct);
        buttonAddCart = findViewById(R.id.button_AddCart);
        buttonBuyNow = findViewById(R.id.button_BuyNow);
        viewPagerSlider = findViewById(R.id.viewPager_ImageDetailProduct);
        circleIndicator = findViewById(R.id.circleIndicator);
        frameLayoutCart = findViewById(R.id.frameLayout_Cart);
        imageView_RowBack = findViewById(R.id.imageView_RowBack);

        ID_Product = getIntent().getIntExtra("ID_Product", 1);
    }
}