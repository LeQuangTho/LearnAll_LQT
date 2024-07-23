package com.lqt.duynguyenhairsalon.Fragments.MainApp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.lqt.duynguyenhairsalon.Activities.Shopping.Customer.CartActivity;
import com.lqt.duynguyenhairsalon.Activities.Shopping.ProductListActivity;
import com.lqt.duynguyenhairsalon.Model.Adapters.PhotoAdapter;
import com.lqt.duynguyenhairsalon.Model.Adapters.ProductAdapter;
import com.lqt.duynguyenhairsalon.Model.Adapters.SpeciesProductAdapter;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.Model.Photo;
import com.lqt.duynguyenhairsalon.Model.ProductDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.Model.SpeciesProduct;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class StoreFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    //View
    private View view;
    private RecyclerView recyclerViewHotProduct;
    private RecyclerView recyclerViewNewProduct;
    private RecyclerView recyclerViewTopProduct;
    private RecyclerView recyclerViewSpeciesProduct;
    private TextView textViewOtherHotProduct;
    private TextView textViewOtherNewProduct;
    private TextView textViewOtherTopProduct;
    private TextView textViewAmountInCart;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ViewPager viewPagerSlider;
    private FrameLayout frameLayoutCart;
    private CircleIndicator circleIndicator;


    //List
    private List<ProductDuyNguyenHairSalon> hotProductList;
    private List<ProductDuyNguyenHairSalon> newProductList;
    private List<ProductDuyNguyenHairSalon> topProductList;
    private List<SpeciesProduct> speciesProductList;
    private List<Photo> photoList;

    //Adapter
    private ProductAdapter hotProductAdapter;
    private ProductAdapter newProductAdapter;
    private ProductAdapter topProductAdapter;
    private SpeciesProductAdapter speciesProductAdapter;
    private PhotoAdapter photoAdapter;

    //Param
    private String urlSpeciesProduct = Config.LOCALHOST + "GetSpeciesProduct.php";
    private static final String TAG = StoreFragment.class.getName();
    private Timer timer;
    private String urlAmountCart = Config.LOCALHOST + "GetCart.php?ID_User=" + DataLocalManager.getPrefIdUser();
    private int AmountInCart = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_store, container, false);

        initView();

        SetSlider();

        autoSlideImage();

        SetSpeciesProduct();

        HotProduct();

        NewProduct();

        TopProduct();

        ListenFragment();

        SetSwipeFragment();

        return view;
    }

    private void SetSwipeFragment() {
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.orange));
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    private void ListenFragment() {
        frameLayoutCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CartActivity.class));
            }
        });
    }

    private void SetSpeciesProduct() {
        speciesProductList = new ArrayList<>();
        speciesProductAdapter = new SpeciesProductAdapter(getContext());
        speciesProductAdapter.setData(speciesProductList, new SpeciesProductAdapter.IClickSpeciesProductListener() {
            @Override
            public void onClickSpeciesProduct(String keyWord, SpeciesProduct speciesProduct) {
                Intent intent = new Intent(getContext(), ProductListActivity.class);

                intent.putExtra("KEYWORD", keyWord);
                intent.putExtra("SPECIESPRODUCT", speciesProduct);

                startActivity(intent);
            }
        });
        GetDataSP();

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);

        recyclerViewSpeciesProduct.setLayoutManager(layoutManager);

        recyclerViewSpeciesProduct.setAdapter(speciesProductAdapter);
    }

    private void GetDataSP() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, urlSpeciesProduct, null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject species = response.getJSONObject(i);
                        speciesProductList.add(new SpeciesProduct(species.getInt("ID_SpeciesProduct")
                                , species.getString("Name_SpeciesProduct")
                                , species.getString("Image_SpeciesProduct")));
                        speciesProductAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
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

    private void TopProduct() {
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewTopProduct.setLayoutManager(layoutManager);

        topProductList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            topProductList.add(new ProductDuyNguyenHairSalon(1
                    , "Sản phẩm này tên rất dài nhé tất cả mọi người"
                    , 199000
                    , 1000
                    , ""
                    , ""
                    , ""
                    , ""
                    , 1
                    , "Etiaxil"));
        }

        topProductAdapter = new ProductAdapter(getContext());
        topProductAdapter.setData(topProductList);
        recyclerViewTopProduct.setAdapter(topProductAdapter);
    }

    private void HotProduct() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerViewHotProduct.setLayoutManager(layoutManager);

        hotProductList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            hotProductList.add(new ProductDuyNguyenHairSalon(1
                    , "Sản phẩm này tên rất dài nhé tất cả mọi người"
                    , 199000
                    , 1000
                    , ""
                    , ""
                    , ""
                    , ""
                    , 1
                    , "Etiaxil"));

        }

        hotProductAdapter = new ProductAdapter(getContext());
        hotProductAdapter.setData(hotProductList);

        recyclerViewHotProduct.setAdapter(hotProductAdapter);
    }

    private void SetAmountInCart() {
        AmountInCart = 0;
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

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

    private void NewProduct() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recyclerViewNewProduct.setLayoutManager(layoutManager);

        newProductList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            newProductList.add(new ProductDuyNguyenHairSalon(1
                    , "Sản phẩm này tên rất dài nhé tất cả mọi người"
                    , 199000
                    , 1000
                    , ""
                    , ""
                    , ""
                    , ""
                    , 1
                    , "Etiaxil"));
        }

        newProductAdapter = new ProductAdapter(getContext());
        newProductAdapter.setData(newProductList);

        recyclerViewNewProduct.setAdapter(newProductAdapter);
    }

    private void SetSlider() {
        photoList = getListPhoto();

        photoAdapter = new PhotoAdapter(getContext(), photoList);

        viewPagerSlider.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPagerSlider);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
    }

    private List<Photo> getListPhoto() {
        List<Photo> photos = new ArrayList<>();

        photos.add(new Photo(R.drawable.banner_shop_1));
        photos.add(new Photo(R.drawable.banner_shop_2));

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

    private void initView() {
        recyclerViewHotProduct = view.findViewById(R.id.recyclerView_HotProduct);
        recyclerViewNewProduct = view.findViewById(R.id.recyclerView_NewProduct);
        recyclerViewTopProduct = view.findViewById(R.id.recyclerView_TopProduct);
        recyclerViewSpeciesProduct = view.findViewById(R.id.recyclerView_SpeciesProduct);
        textViewOtherHotProduct = view.findViewById(R.id.textView_OtherHotProduct);
        textViewOtherNewProduct = view.findViewById(R.id.textView_OtherNewProduct);
        textViewOtherTopProduct = view.findViewById(R.id.textView_OtherTopProduct);
        textViewAmountInCart = view.findViewById(R.id.textView_AmountInCart);
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        viewPagerSlider = view.findViewById(R.id.viewPager_Store);
        circleIndicator = view.findViewById(R.id.circleIndicator);
        frameLayoutCart = view.findViewById(R.id.frameLayout);
    }

    @Override
    public void onStart() {
        SetAmountInCart();
        super.onStart();
    }

    @Override
    public void onRefresh() {
        //Nếu muốn load lại thì làm việc ở đây
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}