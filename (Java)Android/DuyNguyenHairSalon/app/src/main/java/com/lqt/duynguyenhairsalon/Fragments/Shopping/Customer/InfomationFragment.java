package com.lqt.duynguyenhairsalon.Fragments.Shopping.Customer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.lqt.duynguyenhairsalon.Activities.Shopping.Customer.DetailProductActivity;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InfomationFragment extends Fragment {

    //View
    private View view;
    private TextView textViewProducer;
    private TextView textViewBrand;
    private TextView textViewInfomation;

    //Param
    private DetailProductActivity activity;
    private String url = Config.LOCALHOST + "GetProducer.php?ID_Producer=";
    private static final String TAG = InfomationFragment.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_infomation, container, false);

        initView();

        SetData();
        return view;
    }

    private void SetData() {
        textViewInfomation.setText("" + activity.getInfo_Product());

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET
                , url + activity.getID_Producer()
                , null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject producer = response.getJSONObject(0);
                    textViewProducer.setText("Thương hiệu: " + producer.getString("Name_Brand"));
                    textViewBrand.setText("Xuất xứ: " + producer.getString("Origin"));
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

    private void initView() {
        textViewProducer = view.findViewById(R.id.textView_Producer);
        textViewBrand = view.findViewById(R.id.textView_Brand);
        textViewInfomation = view.findViewById(R.id.textView_Infomation);

        activity = (DetailProductActivity) getActivity();
    }
}