package com.lqt.duynguyenhairsalon.Activities.Booking.Admin;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lqt.duynguyenhairsalon.Model.Adapters.AdminServiceAdapter;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.Model.mTask;
import com.lqt.duynguyenhairsalon.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DescriptionTaskActivity extends AppCompatActivity {

    //View
    private ImageView imageViewBack;
    private Button buttonSuccess, buttonCancel, buttonConfirm;
    private TextView textViewName;
    private TextView textViewPhone;
    private TextView textViewDate;
    private CheckBox checkBoxChupAnhSauKhiCat;
    private CheckBox checkBoxYeuCauTuVan;
    private RecyclerView recyclerViewService;
    private TextView textViewSum;
    private LinearLayout linearLayoutUtilities;

    //Adapter
    private AdminServiceAdapter adminServiceAdapter;

    //Param
    private boolean isSuccessful;
    private String data;
    private static final String TAG = DescriptionTaskActivity.class.getName();
    private String Url = Config.LOCALHOST + "UpdateConfirmTask.php?ID_Task=";
    private String idTask;
    private Dialog dialog;
    private static final int RESULT_CODE = 1412;

    //List

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_task);

        Intent intent = getIntent();

        isSuccessful = intent.getBooleanExtra("isSuccsessful", true);

        data = intent.getStringExtra("data");


        initView();

        SetData();

        DescriptionTaskListen();
    }

    private void SetData() {
        Gson gson = new Gson();
        mTask task = gson.fromJson(data, mTask.class);

        //Các thông tin khác
        textViewName.setText(task.getUser().getName_User());
        textViewPhone.setText(task.getUser().getPhone_Number_User());
        textViewDate.setText("Đặt lịch: " + task.getDate_Task());
        if (task.getIs_Consulting() == 1) {
            checkBoxYeuCauTuVan.setChecked(true);
        } else {
            checkBoxYeuCauTuVan.setChecked(false);
        }

        if (task.getIs_Save_Photo() == 1) {
            checkBoxChupAnhSauKhiCat.setChecked(true);
        } else {
            checkBoxChupAnhSauKhiCat.setChecked(false);
        }
        idTask = task.getID_Task();

        textViewSum.setText("" + task.getSum_Money_Task() / 1000 + "K");

        //List Service
        adminServiceAdapter = new AdminServiceAdapter(this);
        adminServiceAdapter.setData(task.getList_Service());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recyclerViewService.setLayoutManager(layoutManager);
        //tắt sự kiện cuộn
        recyclerViewService.setNestedScrollingEnabled(false);
        recyclerViewService.setAdapter(adminServiceAdapter);

        //List service free
        List<String> listServiceFree = new ArrayList<>();
        Type type = new TypeToken<List<String>>() {
        }.getType();
        listServiceFree = gson.fromJson(task.getService_Free(), type);

        if (listServiceFree.isEmpty()) {
            TextView textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setText("Không có thêm dịch vụ miễn phí nào!");
            textView.setGravity(Gravity.CENTER);
            linearLayoutUtilities.addView(textView);
        } else {
            for (int i = 0; i < listServiceFree.size(); i++) {
                TextView textView = new TextView(this);
                textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                textView.setText("" + listServiceFree.get(i));
                linearLayoutUtilities.addView(textView);
            }
        }
    }

    private void DescriptionTaskListen() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (buttonSuccess.isEnabled()) {
            buttonSuccess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowDialog();
                }
            });
        }
    }

    private void ShowDialog() {
        dialog = new Dialog(this);

        //không có title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.diaglog_request_successful);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        //Xét LayoutParams
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //Vị trí hiển thị
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        window.setGravity(Gravity.CENTER);

        //Bắt sự kiện nhấn ra ngoài vùng
        dialog.setCancelable(false);

        //Ánh xạ các thứ ở dưới này
        buttonCancel = (Button) dialog.findViewById(R.id.buttonCancel);
        buttonConfirm = (Button) dialog.findViewById(R.id.button_Confirm);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotoSuccessful();
                dialog.dismiss();
                setResult(RESULT_CODE);
            }
        });

        //show
        dialog.show();
    }

    private void GotoSuccessful() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url + idTask, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                    Toast.makeText(DescriptionTaskActivity.this, "Hoàn thành!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(DescriptionTaskActivity.this, "Lỗi hệ thống!", Toast.LENGTH_SHORT).show();
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
                param.put("ID_Task", "" + idTask);
                return param;
            }
        };

        requestQueue.add(stringRequest);
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageView_Back);
        buttonSuccess = findViewById(R.id.button_Success);
        textViewName = findViewById(R.id.textView_Name);
        textViewPhone = findViewById(R.id.textView_Phone);
        textViewDate = findViewById(R.id.textView_Date);
        checkBoxYeuCauTuVan = findViewById(R.id.checkbox_YeuCauTuVan);
        checkBoxChupAnhSauKhiCat = findViewById(R.id.checkbox_ChupAnhSauKhiCat);
        recyclerViewService = findViewById(R.id.recyclerView_Service);
        textViewSum = findViewById(R.id.textView_Sum);
        linearLayoutUtilities = findViewById(R.id.LinearLayout_Utilities);

        if (isSuccessful) {
            buttonSuccess.setVisibility(View.GONE);
        }
    }
}