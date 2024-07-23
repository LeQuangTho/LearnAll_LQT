package com.lqt.duynguyenhairsalon.Activities.Shopping.Customer;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lqt.duynguyenhairsalon.Activities.Home.MainActivity;
import com.lqt.duynguyenhairsalon.Activities.Other.IntroActivity;
import com.lqt.duynguyenhairsalon.Model.Adapters.ListADWAdapter;
import com.lqt.duynguyenhairsalon.Model.Adapters.ProductInCartAdapter;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.Model.DeliveryAddress.District;
import com.lqt.duynguyenhairsalon.Model.DeliveryAddress.Province;
import com.lqt.duynguyenhairsalon.Model.DeliveryAddress.Ward;
import com.lqt.duynguyenhairsalon.Model.ProductDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lqt.duynguyenhairsalon.Model.Adapters.ListADWAdapter.IDeliveryAddress.DISTRICT;
import static com.lqt.duynguyenhairsalon.Model.Adapters.ListADWAdapter.IDeliveryAddress.PROVINCE;
import static com.lqt.duynguyenhairsalon.Model.Adapters.ListADWAdapter.IDeliveryAddress.WARD;
import static com.lqt.duynguyenhairsalon.Model.Adapters.ProductInCartAdapter.IClickChangeProductListener.OPTION_CHANGE;

public class CartActivity extends AppCompatActivity {

    //View
    private RecyclerView recyclerViewProduct;
    private TextView textViewPriceDelivery;
    private TextView textViewSum;
    private TextView textViewSumProduct;
    private CheckBox checkBoxFastShip;
    private Button buttonOrder;
    private ImageView imageViewRowBack;
    private TextView textViewName;
    private TextView textViewPhoneNumber;
    private TextView textViewProvince;
    private TextView textViewDistrict;
    private TextView textViewWard;
    private Button buttonConfirm;
    private ImageView imageViewClose;
    private Dialog dialogRequest;
    private Dialog dialogAddress;
    private Dialog dialogChooseADW;
    private TextView textViewDeliveryAddress;
    private EditText editTextSpecificDeliveryAddress;

    //List
    private List<ProductDuyNguyenHairSalon> productList;

    //Adapter
    private ProductInCartAdapter productInCartAdapter;
    private ListADWAdapter adwAdapter;

    //Param
    public static String REQUEST_CODE_CART = "REQUEST_CODE_CART";
    private static final String TAG = CartActivity.class.getName();
    private String url = Config.LOCALHOST + "GetCart.php?ID_User=" + DataLocalManager.getPrefIdUser();
    private String idDistrict = "";
    private String idProvince = "";
    private List listADW;
    private Calendar calendar;
    private String specificDeliveryAddress;
    private int sumPrice;
    private String UrlBill = Config.LOCALHOST + "CreateBill.php";
    private String urlMove = Config.LOCALHOST + "InsertDescriptionBill.php";
    private String urlChangeProductToCart = Config.LOCALHOST + "ChangeAmountInCart.php";
    private String urlADW = "https://online-gateway.ghn.vn/shiip/public-api/master-data/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initView();

        SetProductList();

        SetListenActivity();

        CheckButtonOrder();
    }

    /*
     * Hàm này kiểm tra xem button order có được phép nhấn hay không
     * */
    private void CheckButtonOrder() {
        if (productList.isEmpty() || textViewDeliveryAddress.getText().toString().isEmpty()) {
            buttonOrder.setEnabled(false);
            buttonOrder.setBackgroundResource(R.drawable.background_view_disible);
        } else {
            buttonOrder.setBackgroundResource(R.color.orange);
            buttonOrder.setEnabled(true);
        }
    }

    private void SetListenActivity() {
        imageViewRowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewDeliveryAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogChooseAddress();
            }
        });

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idBill = CreateIDBill();

                InsertBill(idBill);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MoveProduct(idBill);
                        getDataProduct();
                        productInCartAdapter.notifyDataSetChanged();
                        Toast.makeText(CartActivity.this, "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CartActivity.this, MainActivity.class);
                        intent.putExtra(REQUEST_CODE_CART, REQUEST_CODE_CART);
                        startActivity(intent);
                        finishAffinity();
                    }
                }, 1000);
            }
        });
    }

    private void MoveProduct(String idBill) {
        for (int i = 0; i < productList.size(); i++) {
            Move(productList.get(i), idBill);
        }
    }

    private void Move(ProductDuyNguyenHairSalon product, String idBill) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlMove, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("successful")) {
                    Log.e(TAG, "Done");
                } else {
                    //Todo
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
                Map<String, String> params = new HashMap<>();

                params.put("Amount", "" + product.getAmount_Product());
                params.put("ID_Bill", idBill);
                params.put("ID_Product", "" + product.getID_Product());
                params.put("ID_User", DataLocalManager.getPrefIdUser());

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    /*
     * Đây là hàm insert bill
     * */
    private void InsertBill(String idBill) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String address = DataLocalManager.getPrefWardName() +
                ", " + DataLocalManager.getPrefDistrictName() +
                ", " + DataLocalManager.getPrefProvinceName();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UrlBill, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("successful")) {
                    Log.e(TAG, "Insert Bill Successful");
                } else {
                    Toast.makeText(CartActivity.this, "Vui lòng thử lại sau!😢", Toast.LENGTH_SHORT).show();
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
                Map<String, String> params = new HashMap<>();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String address = DataLocalManager.getPrefWardName() +
                        ", " + DataLocalManager.getPrefDistrictName() +
                        ", " + DataLocalManager.getPrefProvinceName();

                params.put("ID_Bill", idBill);
                params.put("Date_Bill", dateFormat.format(Calendar.getInstance().getTime()));
                params.put("Sum_Money_Bill", "" + (sumPrice < 500000 ? (sumPrice + 30000) : sumPrice));
                params.put("Shipping_Fee", sumPrice < 500000 ? "30000" : "0");
                params.put("Delivery_Address", address);
                params.put("Specific_Delivery_Address", "" + specificDeliveryAddress);
                params.put("Fast_Delivery", checkBoxFastShip.isChecked() ? "1" : "0");
                params.put("Is_Successful", "0");
                params.put("ID_User", DataLocalManager.getPrefIdUser());
                return params;
            }
        };
        //Log.e("ID_Bill", dateFormat.format(Calendar.getInstance().getTime()));
        requestQueue.add(stringRequest);
    }

    /*
     * Đây là hàm tạo Id Bill
     * */
    private String CreateIDBill() {
        calendar = Calendar.getInstance();
        return "B" + calendar.get(Calendar.YEAR) % 2000 +
                (calendar.get(Calendar.MONTH) + 1) +
                calendar.get(Calendar.DATE) +
                calendar.get(Calendar.HOUR_OF_DAY) +
                calendar.get(Calendar.MINUTE) +
                calendar.get(Calendar.SECOND) +
                calendar.get(Calendar.MILLISECOND);
    }

    /*
     * Dialog chọn Province/District/Ward
     * */
    private void ShowDialogChooseAddress() {
        dialogAddress = new Dialog(this);

        //no titel
        dialogAddress.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set layout
        dialogAddress.setContentView(R.layout.dialog_select_delivery_address);

        //get window
        Window window = dialogAddress.getWindow();

        if (window == null) {
            return;
        }

        //set layout manager
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //set vị trí xuất hiện
        window.setGravity(Gravity.CENTER);

        //chạm ra ngoài không bị close
        dialogAddress.setCanceledOnTouchOutside(false);

        textViewName = (TextView) dialogAddress.findViewById(R.id.textView_Name);
        textViewPhoneNumber = (TextView) dialogAddress.findViewById(R.id.textView_PhoneNumber);
        textViewProvince = (TextView) dialogAddress.findViewById(R.id.textView_Province);
        textViewDistrict = (TextView) dialogAddress.findViewById(R.id.textView_District);
        textViewWard = (TextView) dialogAddress.findViewById(R.id.textView_Ward);
        editTextSpecificDeliveryAddress = (EditText) dialogAddress.findViewById(R.id.editText_SpecificDeliveryAddress);
        buttonConfirm = (Button) dialogAddress.findViewById(R.id.button_Confirm);
        imageViewClose = (ImageView) dialogAddress.findViewById(R.id.imageView_Close);

        if (DataLocalManager.getPrefProvinceId().isEmpty()) {
            idProvince = "";
        } else {
            textViewProvince.setText(DataLocalManager.getPrefProvinceName());
            idProvince = DataLocalManager.getPrefProvinceId();
        }

        if (DataLocalManager.getPrefDistrictId().isEmpty()) {
            idDistrict = "";
        } else {
            textViewDistrict.setText(DataLocalManager.getPrefDistrictName());
            idDistrict = DataLocalManager.getPrefDistrictId();
        }

        if (!DataLocalManager.getPrefWardId().isEmpty()) {
            textViewWard.setText(DataLocalManager.getPrefWardName());
        }

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogAddress.dismiss();
                CheckButtonOrder();
            }
        });

        textViewProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogChooseADW(PROVINCE);
            }
        });

        textViewDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idProvince.isEmpty()) {
                    Toast.makeText(CartActivity.this, "Vui lòng chọn Tỉnh/Thành trước!", Toast.LENGTH_SHORT).show();
                } else {
                    ShowDialogChooseADW(DISTRICT);
                }
            }
        });

        textViewWard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idDistrict.isEmpty()) {
                    Toast.makeText(CartActivity.this, "Vui lòng chọn Quận/Huyện trước!", Toast.LENGTH_SHORT).show();
                } else {
                    ShowDialogChooseADW(WARD);
                }
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewDeliveryAddress.setText(DataLocalManager.getPrefWardName() +
                        ", " + DataLocalManager.getPrefDistrictName() +
                        ", " + DataLocalManager.getPrefProvinceName());
                specificDeliveryAddress = editTextSpecificDeliveryAddress.getText().toString();
                CheckButtonOrder();
                dialogAddress.dismiss();
            }
        });

        dialogAddress.show();
    }

    /*
     * Đây là dialog chung hiện thị list các Province/District/Ward
     */
    private void ShowDialogChooseADW(String leverAddress) {
        dialogChooseADW = new Dialog(this);

        //set no title
        dialogChooseADW.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //set layout
        dialogChooseADW.setContentView(R.layout.dialog_choose_adw);

        //get window
        Window window = dialogChooseADW.getWindow();
        if (window == null) {
            return;
        }

        //set layout manager
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //set Vị trí hiển thị
        window.setGravity(Gravity.CENTER);

        //Chạm ra ngoài
        dialogChooseADW.setCanceledOnTouchOutside(false);

        RecyclerView recyclerViewADW = (RecyclerView) dialogChooseADW.findViewById(R.id.recyclerView_ADW);
        recyclerViewADW.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        ProgressDialog progressDialog = new ProgressDialog(CartActivity.this);

        progressDialog.setMessage("Đang xử lý...");
        progressDialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progressDialog.show();


        if (leverAddress.equals(PROVINCE)) {
            listADW = new ArrayList<Province>();
            SetListADW(listADW, leverAddress);
            adwAdapter = new ListADWAdapter(this, PROVINCE, new ListADWAdapter.IDeliveryAddress() {
                @Override
                public void onItemClickListener(Object o) {
                    if (!idProvince.isEmpty()) {
                        textViewWard.setText("Xã/Phường");
                        textViewDistrict.setText("Quận/Huyện");
                        DataLocalManager.setPrefDistrictName("");
                        DataLocalManager.setPrefWardName("");

                        idDistrict = "";
                        DataLocalManager.setPrefDistrictId("");
                        DataLocalManager.setPrefWardId("");
                    }

                    Province province = (Province) o;
                    idProvince = String.valueOf(province.getIdProvince());
                    DataLocalManager.setPrefProvinceName(province.getNameProvince());
                    DataLocalManager.setPrefProvinceId("" + province.getIdProvince());
                    textViewProvince.setText(province.getNameProvince());
                    textViewProvince.setTextColor(getResources().getColor(R.color.black));
                    dialogChooseADW.dismiss();
                }
            });
        } else if (leverAddress.equals(DISTRICT)) {
            listADW = new ArrayList<District>();
            SetListADW(listADW, leverAddress);
            adwAdapter = new ListADWAdapter(this, DISTRICT, new ListADWAdapter.IDeliveryAddress() {
                @Override
                public void onItemClickListener(Object o) {
                    if (!idProvince.isEmpty()) {
                        textViewWard.setText("Xã/Phường");
                        DataLocalManager.setPrefWardName("");
                        DataLocalManager.setPrefWardId("");
                    }

                    District district = (District) o;
                    idDistrict = "" + district.getIdDistrict();
                    textViewDistrict.setText(district.getNameDistrict());
                    DataLocalManager.setPrefDistrictName(district.getNameDistrict());
                    DataLocalManager.setPrefDistrictId("" + district.getIdDistrict());
                    textViewDistrict.setTextColor(getResources().getColor(R.color.black));
                    dialogChooseADW.dismiss();
                }
            });
        } else {
            listADW = new ArrayList<Ward>();
            SetListADW(listADW, leverAddress);
            adwAdapter = new ListADWAdapter(this, WARD, new ListADWAdapter.IDeliveryAddress() {
                @Override
                public void onItemClickListener(Object o) {
                    Ward ward = (Ward) o;
                    textViewWard.setText(ward.getNameWard());
                    DataLocalManager.setPrefWardName(ward.getNameWard());
                    DataLocalManager.setPrefWardId("" + ward.getIdWard());
                    textViewWard.setTextColor(getResources().getColor(R.color.black));
                    dialogChooseADW.dismiss();
                }
            });
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (listADW.size() != 0) {
                    adwAdapter.setData(listADW);
                    recyclerViewADW.setAdapter(adwAdapter);
                    progressDialog.dismiss();
                    dialogChooseADW.show();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(CartActivity.this, "Vui lòng thử lại sau!", Toast.LENGTH_SHORT).show();
                }
            }
        }, 500);

    }

    /*
     * Set dữ liệu cho list Province/District/Ward
     * */
    private void SetListADW(List listADW, String leverAddress) {
        String url;

        if (listADW == null) {
            return;
        }

        if (leverAddress.equals(PROVINCE)) {
            url = urlADW + PROVINCE;
        } else if (leverAddress.equals(DISTRICT)) {
            url = urlADW + DISTRICT + idProvince;
        } else {
            url = urlADW + WARD + idDistrict;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(CartActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("data");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject data = array.getJSONObject(i);
                        if (leverAddress.equals(PROVINCE)) {
                            listADW.add(new Province(data.getInt("ProvinceID"), data.getString("ProvinceName")));
                        } else if (leverAddress.equals(DISTRICT)) {
                            listADW.add(new District(data.getInt("DistrictID"), data.getString("DistrictName")));
                        } else {
                            listADW.add(new Ward(data.getInt("WardCode"), data.getString("WardName")));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("token", getString(R.string.token_ghn));
                return param;
            }
        };

        requestQueue.add(jsonObjectRequest);
    }

    /*
     * Đây là dialog confirm người dùng xóa Product
     */
    private void RequestDelete(ProductDuyNguyenHairSalon product) {
        dialogRequest = new Dialog(this);

        //không có title
        dialogRequest.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //SetLayout
        dialogRequest.setContentView(R.layout.diaglog_request_successful);

        Window window = dialogRequest.getWindow();
        if (window == null) {
            return;
        }

        //Xét LayoutParams
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //Vị trí hiển thị
        window.setGravity(Gravity.CENTER);

        //Bắt sự kiện nhấn ra ngoài vùng
        dialogRequest.setCanceledOnTouchOutside(false);

        //Ánh xạ các thứ ở dưới này
        Button buttonCancel = (Button) dialogRequest.findViewById(R.id.buttonCancel);
        Button buttonConfirm = (Button) dialogRequest.findViewById(R.id.button_Confirm);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogRequest.dismiss();
                CheckButtonOrder();
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductChange(product, ProductInCartAdapter.IClickChangeProductListener.DELETE, OPTION_CHANGE);
                dialogRequest.dismiss();
                CheckButtonOrder();
            }
        });

        //show
        dialogRequest.show();
    }

    /*
     * Hiển thị list Product
     * */
    private void SetProductList() {
        getDataProduct();

        productInCartAdapter = new ProductInCartAdapter(this);

        productInCartAdapter.setData(productList, new ProductInCartAdapter.IClickChangeProductListener() {
            @Override
            public void onClickUpProduct(ProductDuyNguyenHairSalon product) {
                ProductChange(product, UP, OPTION_CHANGE);
            }

            @Override
            public void onClickDownProduct(ProductDuyNguyenHairSalon product) {
                if (product.getAmount_Product() == 1) {
                    RequestDelete(product);
                } else {
                    ProductChange(product, DOWN, OPTION_CHANGE);
                }
            }

            @Override
            public void onClickDeleteProduct(ProductDuyNguyenHairSalon product) {
                RequestDelete(product);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewProduct.setLayoutManager(layoutManager);

        recyclerViewProduct.setAdapter(productInCartAdapter);
    }

    /*
     * Set sự thay đổi của list
     * */
    private void ProductChange(ProductDuyNguyenHairSalon product, String change, String option) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlChangeProductToCart
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("successful")) {
                    if (change.equals(ProductInCartAdapter.IClickChangeProductListener.UP)) {
                        product.setAmount_Product(product.getAmount_Product() + 1);
                        productInCartAdapter.notifyDataSetChanged();
                    } else if (change.equals(ProductInCartAdapter.IClickChangeProductListener.DOWN)) {
                        product.setAmount_Product(product.getAmount_Product() - 1);
                        productInCartAdapter.notifyDataSetChanged();
                    } else {
                        productList.remove(product);
                        productInCartAdapter.notifyDataSetChanged();
                        if (option.equals(OPTION_CHANGE)) {
                            Toast.makeText(CartActivity.this, "Đã xóa!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    CheckButtonOrder();
                    LoadAllPrice();
                } else {
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

                param.put("Change", change);
                param.put("ID_User", DataLocalManager.getPrefIdUser());
                param.put("ID_Product", "" + product.getID_Product());

                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    /*
     * set dữ liệu list product
     * */
    private void getDataProduct() {
        if (productList == null) {
            productList = new ArrayList<>();
        } else {
            productList.clear();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url
                , null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject product = response.getJSONObject(i);
                        productList.add(new ProductDuyNguyenHairSalon(product.getInt("ID_Product")
                                , product.getString("Name_Product")
                                , product.getInt("Price_Product")
                                , product.getInt("Amount_Product")
                                , ""
                                , ""
                                , ""
                                , product.getString("Image_Product")
                                , 1
                                , ""));
                        productInCartAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                LoadAllPrice();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        });
        requestQueue.add(arrayRequest);
        CheckButtonOrder();
    }

    /*
     * Load giá
     * */
    private void LoadAllPrice() {
        sumPrice = 0;
        for (int i = 0; i < productList.size(); i++) {
            sumPrice += (productList.get(i).getAmount_Product() * productList.get(i).getPrice_Product());
        }

        if (sumPrice >= 500000) {
            textViewPriceDelivery.setText(R.string.free_ship);
            textViewSum.setText(sumPrice / 1000 + ".000đ");
        } else {
            if (sumPrice > 0) {
                textViewPriceDelivery.setText(R.string.charge_ship);
                textViewSum.setText((sumPrice + 30000) / 1000 + ".000đ");
            } else {
                textViewSum.setText((sumPrice) / 1000 + ".000đ");
            }
        }

        textViewSumProduct.setText(sumPrice / 1000 + ".000đ");

    }

    private void initView() {
        recyclerViewProduct = findViewById(R.id.recyclerView_ProductInCart);
        textViewPriceDelivery = findViewById(R.id.textView_PriceDelivery);
        textViewSumProduct = findViewById(R.id.textView_SumProduct);
        textViewSum = findViewById(R.id.textView_Sum);
        checkBoxFastShip = findViewById(R.id.checkBox_FastShip);
        buttonOrder = findViewById(R.id.button_Order);
        imageViewRowBack = findViewById(R.id.imageView_RowBack);
        textViewDeliveryAddress = findViewById(R.id.textView_DeliveryAddress);
    }
}