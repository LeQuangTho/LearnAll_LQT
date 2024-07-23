package com.lqt.duynguyenhairsalon.Activities.Booking.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lqt.duynguyenhairsalon.Model.Adapters.DayCutCustomerAdapter;
import com.lqt.duynguyenhairsalon.Model.Adapters.SelectTimeAdapter;
import com.lqt.duynguyenhairsalon.Model.BookingTime;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.Model.DayCut;
import com.lqt.duynguyenhairsalon.Model.ServicesDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;
import com.wefika.flowlayout.FlowLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingActivity extends AppCompatActivity {

    //Params
    private static final String TAG = BookingActivity.class.getName();
    private final int REQUEST_CODE = 123;
    private boolean isEmptyService = false;
    private Calendar calendar;
    private String ID_Task;
    private int isSuccess = 0;
    private String urlTask = Config.LOCALHOST + "InsertTask.php";
    private String urlDescription = Config.LOCALHOST + "InsertDescriptionTask.php";
    private String urlDay = Config.LOCALHOST + "GetTimeForDay.php?Day=";

    //Views
    private Spinner spinnerDay;
    private List<DayCut> dayCutList;
    private DayCutCustomerAdapter dayCutCustomerAdapter;
    private ImageView imageViewHome;
    private Button button_SelectService, button_Success;
    private FlowLayout flowLayoutServices;
    private RecyclerView recyclerViewSelectTime;
    private Switch switchChupAnhSauKhiCat;
    private Switch switchYeuCauTuVan;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;

    //Lists
    private List<ServicesDuyNguyenHairSalon> servicesList = new ArrayList<>();
    private List<BookingTime> bookingTimeList = new ArrayList<>();
    private List<String> serviceFree = new ArrayList<>();

    //Adapter
    private SelectTimeAdapter timeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_booking);

        CreateIDTask();

        initView();

        ListDay();

        ListTime();

        BookingListen();
    }

    private void CreateIDTask() {
        //Tạo ID trong mỗi lần chuẩn bị đặt lịch
        calendar = Calendar.getInstance();
        ID_Task = "T" + calendar.get(Calendar.YEAR) % 2000
                + (calendar.get(Calendar.MONTH) + 1)
                + calendar.get(Calendar.DATE)
                + calendar.get(Calendar.HOUR_OF_DAY)
                + calendar.get(Calendar.MINUTE)
                + calendar.get(Calendar.SECOND)
                + calendar.get(Calendar.MILLISECOND);
    }

    public void ListTime() {
        bookingTimeList.clear();

        for (int i = 8; i < 18; i++) {
            for (int j = 0; j < 2; j++) {
                String mTime = "" + i + "h" + (j == 0 ? "00" : "30");
                String TimeCut = "" + i + ":" + (j == 0 ? "00" : "30");
                ;
                bookingTimeList.add(new BookingTime(mTime, false, TimeCut));
            }
        }

        timeAdapter = new SelectTimeAdapter(this);
        timeAdapter.setData(bookingTimeList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 7);
        recyclerViewSelectTime.setLayoutManager(gridLayoutManager);
        recyclerViewSelectTime.setAdapter(timeAdapter);

        switch (dayCutCustomerAdapter.getmPosition()) {
            case 0:
                GetTime(urlDay, dayCutCustomerAdapter.getmPosition());
                SetDay0();
                break;
            case 1:
                GetTime(urlDay, dayCutCustomerAdapter.getmPosition());
                break;
            case 2:
                GetTime(urlDay, dayCutCustomerAdapter.getmPosition());
                break;
            default:
                GetTime(urlDay, dayCutCustomerAdapter.getmPosition());
                break;
        }

    }

    private void SetDay0() {
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        int am_pm = calendar.get(Calendar.AM_PM);

        int mPosition;

        if (am_pm == 0) {
            if (minute == 0) {
                mPosition = (hour - 8) * 2;
            } else {
                mPosition = (hour - 8) * 2 + 1;
            }
        } else {
            if (minute == 0) {
                mPosition = (hour + 4) * 2;
            } else {
                mPosition = (hour + 4) * 2 + 1;
            }
        }

        if (mPosition + 2 > bookingTimeList.size()) {
            for (int i = 0; i < bookingTimeList.size(); i++) {
                bookingTimeList.get(i).setSelected(true);
                timeAdapter.notifyDataSetChanged();
            }
        } else {
            for (int i = 0; i < mPosition + 2; i++) {
                bookingTimeList.get(i).setSelected(true);
                timeAdapter.notifyDataSetChanged();
            }
        }
    }

    private void GetTime(String url, int pos) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url + pos, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        int hour = jsonObject.getInt("HOUR");
                        int minute = jsonObject.getInt("MINUTE");

                        int mPosition;

                        if (minute == 0) {
                            mPosition = (hour - 8) * 2;
                        } else {
                            mPosition = (hour - 8) * 2 + 1;
                        }

                        bookingTimeList.get(mPosition).setSelected(true);

                        timeAdapter.notifyDataSetChanged();
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


    /*
     * Do nếu chuyển sang SelectServiceActivity mà người dùng ko
     * chọn bất cứ một dịch vụ nào thì phải kiểm tra lại. (Ẩn list time đi)
     * Đây là kiến thức thuộc Life Activity
     *
     * */
    @Override
    protected void onResume() {
        super.onResume();
        if (servicesList.size() == 0 || servicesList == null) {
            recyclerViewSelectTime.setVisibility(View.GONE);
        } else {
            recyclerViewSelectTime.setVisibility(View.VISIBLE);
        }
    }

    /*
     * Hàm BookingListen sẽ cử lí các sự kiện chính trong BookinkActivity
     * */
    private void BookingListen() {
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button_SelectService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingActivity.this, SelectServiceActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        button_Success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (servicesList.size() > 0 && timeAdapter.getPositionSelceted() >= 0) {
                    InsertTask(urlTask);
                } else {
                    Toast.makeText(BookingActivity.this, "Bạn phải chọn dịch vụ và thời gian chứ!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //check box
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    serviceFree.add("" + buttonView.getText());
                } else {
                    serviceFree.remove(buttonView.getText());
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    serviceFree.add("" + buttonView.getText());
                } else {
                    serviceFree.remove(buttonView.getText());
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    serviceFree.add("" + buttonView.getText());
                } else {
                    serviceFree.remove(buttonView.getText());
                }
            }
        });

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    serviceFree.add("" + buttonView.getText());
                } else {
                    serviceFree.remove(buttonView.toString());
                }
            }
        });

        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    serviceFree.add("" + buttonView.getText());
                } else {
                    serviceFree.remove(buttonView.getText());
                }
            }
        });

        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    serviceFree.add("" + buttonView.getText());
                } else {
                    serviceFree.remove(buttonView.getText());
                }
            }
        });
    }

    private StringRequest InsertDescription(String url, String id_service) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("successful")) {
                    isSuccess++;
                    if (isSuccess == servicesList.size() + 1) {
                        Toast.makeText(BookingActivity.this, "Thành công!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Log.e(TAG, "Lỗi! Vui lòng thử lại sau1");
                    finish();
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

                param.put("ID_Task", ID_Task);

                param.put("ID_Service", id_service);

                return param;
            }
        };

        return stringRequest;
    }

    private void InsertTask(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("successful")) {
                    isSuccess++;
                } else {
                    Log.e(TAG, "Lỗi! Vui lòng thử lại sau2");
                    finish();
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

                param.put("ID_Task", ID_Task);

                param.put("Date_Task", dayCutCustomerAdapter.getDateSelected() + " " + timeAdapter.getmTime());

                int sum = 0;
                for (int i = 0; i < servicesList.size(); i++) {
                    sum += servicesList.get(i).getPriceService();
                }
                param.put("Sum_Money_Task", "" + sum);


                param.put("Is_Save_Photo", "" + (switchChupAnhSauKhiCat.isChecked() ? 1 : 0));

                Gson gson = new Gson();
                String iServiceFree = gson.toJson(serviceFree);
                param.put("Service_Free", iServiceFree);

                param.put("Is_Consulting", "" + (switchYeuCauTuVan.isChecked() ? 1 : 0));

                param.put("ID_User", DataLocalManager.getPrefIdUser());

                return param;
            }

            @Override
            public Priority getPriority() {
                return Priority.HIGH;
            }
        };

        requestQueue.add(stringRequest);
        for (int i = 0; i < servicesList.size(); i++) {
            requestQueue.add(InsertDescription(urlDescription, "" + servicesList.get(i).getIdService()));
        }
    }

    /*
     * Xử lí spinner Day
     * */
    private void ListDay() {
        calendar = Calendar.getInstance();

        dayCutList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            upToDate(i);
            String dayOfWeek = "";
            if (i == 0) dayOfWeek += "Hôm nay, ";
            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                dayOfWeek += "Chủ Nhật";
            } else {
                dayOfWeek += "Thứ " + calendar.get(Calendar.DAY_OF_WEEK);
            }
            dayCutList.add(new DayCut(dayOfWeek + " ("
                    + calendar.get(Calendar.DATE)
                    + "/" + (calendar.get(Calendar.MONTH) + 1) + ")"
                    , "" + calendar.get(Calendar.YEAR)
                    + "-" + (calendar.get(Calendar.MONTH) + 1)
                    + "-" + calendar.get(Calendar.DATE)));
        }

        dayCutCustomerAdapter = new DayCutCustomerAdapter(this, R.layout.item_day_cut, dayCutList);

        dayCutCustomerAdapter.setActivity(BookingActivity.this);

        spinnerDay.setAdapter(dayCutCustomerAdapter);
    }

    private void upToDate(int numDay) {
        if (numDay == 0) {
            return;
        }
        calendar.add(Calendar.DAY_OF_WEEK, 1);
    }

    private void setFlowLayoutService() {
        if (flowLayoutServices == null) {
            return;
        }

        flowLayoutServices.removeAllViews();

        if (servicesList != null || servicesList.size() > 0) {
            for (ServicesDuyNguyenHairSalon service : servicesList) {
                TextView textViewService = new TextView(this);
                FlowLayout.LayoutParams param = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT
                        , ViewGroup.LayoutParams.WRAP_CONTENT);
                param.setMargins(0, 20, 20, 0);
                textViewService.setLayoutParams(param);
                textViewService.setText("" + service.getNameService());
                textViewService.setPadding(30, 10, 30, 10);
                textViewService.setBackgroundResource(R.drawable.background_border_black);
                textViewService.setTextColor(getResources().getColor(R.color.black));

                flowLayoutServices.addView(textViewService);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String dataStringExtra = data.getStringExtra("data");
            Gson gson = new Gson();
            /*
             * phải tạo mộ kiểu danh sách như thế này để truyền vào
             * thì Gson mới đọc được list
             *
             *https://www.youtube.com/watch?v=xbo1G02c2VM&list=RDCMUC_Fh8kvtkVPkeihBs42jGcA&start_radio=1&t=443
             *
             * */
            Type type = new TypeToken<List<ServicesDuyNguyenHairSalon>>() {
            }.getType();
            servicesList = gson.fromJson(dataStringExtra, type);
            setFlowLayoutService();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /*
     * ánh xạ các view
     * */
    private void initView() {
        spinnerDay = findViewById(R.id.spinner_SelectDay);
        imageViewHome = findViewById(R.id.imageView_Home);
        button_SelectService = findViewById(R.id.button_SelectService);
        button_Success = findViewById(R.id.button_SuccessBook);
        flowLayoutServices = findViewById(R.id.flowLayout_SelectedService);
        recyclerViewSelectTime = findViewById(R.id.recyclerView_SelectTime);
        switchChupAnhSauKhiCat = findViewById(R.id.swich_ChupAnhSauKhiCat);
        switchYeuCauTuVan = findViewById(R.id.swich_YeuCauTuVan);

        checkBox1 = findViewById(R.id.checkBox_1);
        checkBox2 = findViewById(R.id.checkBox_2);
        checkBox3 = findViewById(R.id.checkBox_3);
        checkBox4 = findViewById(R.id.checkBox_4);
        checkBox5 = findViewById(R.id.checkBox_5);
        checkBox6 = findViewById(R.id.checkBox_6);
    }
}