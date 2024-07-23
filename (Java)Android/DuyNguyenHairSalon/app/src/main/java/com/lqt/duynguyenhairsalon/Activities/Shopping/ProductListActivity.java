package com.lqt.duynguyenhairsalon.Activities.Shopping;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.lqt.duynguyenhairsalon.Model.Adapters.ProductAdapter;
import com.lqt.duynguyenhairsalon.Model.Adapters.SpeciesProductAdapter;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.Model.ProductDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.Model.SpeciesProduct;
import com.lqt.duynguyenhairsalon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    //Param
    private static final String TAG = ProductListActivity.class.getName();
    private String KEY_WORD = "";
    private String urlSpecies = Config.LOCALHOST + "GetProductForSpecies.php?ID_SpeciesProduct=";

    //View
    private RecyclerView recyclerViewProduct;
    private ImageView imageViewRowView;
    private TextView textViewTitle;

    //List
    private List<ProductDuyNguyenHairSalon> listProduct;

    //Adapter
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        initView();

        SetRecyclerViewProd();

        eventProductList();
    }

    private void SetRecyclerViewProd() {
        listProduct = new ArrayList<>();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        productAdapter = new ProductAdapter(this);
        productAdapter.setData(listProduct);

        recyclerViewProduct.setLayoutManager(layoutManager);
        recyclerViewProduct.setAdapter(productAdapter);
        if (KEY_WORD.equals(SpeciesProductAdapter.IClickSpeciesProductListener.KEY_SPECIES)) {
            SpeciesProduct speciesProduct = (SpeciesProduct) getIntent().getSerializableExtra("SPECIESPRODUCT");

            SetDataSpeciesProduct("" + speciesProduct.getID_SpeciesProduct());
            textViewTitle.setText("" + speciesProduct.getName_SpeciesProduct());
        }
    }

    private void SetDataSpeciesProduct(String id) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, urlSpecies + id, null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject product = response.getJSONObject(i);
                        listProduct.add(new ProductDuyNguyenHairSalon(product.getInt("ID_Product")
                                , product.getString("Name_Product")
                                , product.getInt("Price_Product")
                                , product.getInt("Amount_Product")
                                , product.getString("Info_Product")
                                , product.getString("Description_Product")
                                , product.getString("Using_Product")
                                , product.getString("Image_Product")
                                , product.getInt("ID_SpeciesProduct")
                                , product.getString("ID_Producer")));
                        productAdapter.notifyDataSetChanged();
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

    private void eventProductList() {
        imageViewRowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        imageViewRowView = findViewById(R.id.imageView_RowBack);
        textViewTitle = findViewById(R.id.textView_Title);
        recyclerViewProduct = findViewById(R.id.recyclerView_Product);

        KEY_WORD = getIntent().getStringExtra("KEYWORD");
    }
}