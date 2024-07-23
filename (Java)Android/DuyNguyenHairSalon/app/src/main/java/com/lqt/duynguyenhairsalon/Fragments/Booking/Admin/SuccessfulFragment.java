package com.lqt.duynguyenhairsalon.Fragments.Booking.Admin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.lqt.duynguyenhairsalon.Activities.Booking.Admin.BookingActivity;
import com.lqt.duynguyenhairsalon.Model.Adapters.TaskAdapter;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.Model.ServicesDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.Model.User;
import com.lqt.duynguyenhairsalon.Model.mTask;
import com.lqt.duynguyenhairsalon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SuccessfulFragment extends Fragment {

    //View
    private RecyclerView recyclerViewSuccessful;
    private View view;

    //Adapter
    private TaskAdapter taskAdapter;

    //List
    private List<mTask> mTaskList;

    //Param
    private BookingActivity activity;
    private String day = "0";

    private static final String TAG = SuccessfulFragment.class.getName();
    private String Url = Config.LOCALHOST + "GetTaskAdmin.php?DayTask=";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_successful, container, false);

        initView();

        LoadListTask();

        SetRecyclerView();

        return view;
    }

    private void LoadListTask() {
        mTaskList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET
                , Url + day
                , null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject task = response.getJSONObject(i);
                        if (task.getInt("Is_Successful_Task") == 1) {
                            JSONArray service = task.getJSONArray("Array_Service");

                            List<ServicesDuyNguyenHairSalon> listService = new ArrayList<>();
                            for (int j = 0; j < service.length(); j++) {
                                listService.add(new ServicesDuyNguyenHairSalon(service.getJSONObject(j).getInt("ID_Service")
                                        , service.getJSONObject(j).getString("Name_Service")
                                        , null
                                        , false
                                        , service.getJSONObject(j).getInt("Price_Service")));
                            }

                            mTaskList.add(new mTask(task.getString("ID_Task")
                                    , task.getString("Date_Task")
                                    , task.getInt("Sum_Money_Task")
                                    , task.getInt("Is_Save_Photo")
                                    , task.getInt("Is_Consulting")
                                    , task.getInt("Is_Successful_Task")
                                    , task.getString("Service_Free")
                                    , new User(task.getInt("ID_User")
                                    , task.getString("Name_User")
                                    , task.getString("Phone_Number_User"))
                                    , listService));
                            taskAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    private void SetRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                , LinearLayoutManager.VERTICAL
                , false);
        recyclerViewSuccessful.setLayoutManager(linearLayoutManager);
        taskAdapter = new TaskAdapter(getActivity(), true);
        taskAdapter.setData(mTaskList);
        recyclerViewSuccessful.setAdapter(taskAdapter);
    }

    private void initView() {
        recyclerViewSuccessful = view.findViewById(R.id.recycleView_TaskSuccessful);

        activity = (BookingActivity) getActivity();

        day = "" + activity.getDayCut();
    }
}