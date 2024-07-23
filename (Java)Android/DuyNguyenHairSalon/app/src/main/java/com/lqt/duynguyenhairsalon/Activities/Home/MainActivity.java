package com.lqt.duynguyenhairsalon.Activities.Home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lqt.duynguyenhairsalon.Activities.Shopping.Customer.CartActivity;
import com.lqt.duynguyenhairsalon.Model.Adapters.ViewPagerAdapter;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //View
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    //Param
    private static final String TAG = MainActivity.class.getName();
    private String UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        SetViewPage();

        CheckIdUser();

        /*
         * Nếu đi từ CartActivity về thì sẽ setCurrentItem của viewPager về page Store
         * */
        try {
            if (getIntent().getCharSequenceExtra(CartActivity.REQUEST_CODE_CART).toString().equals(CartActivity.REQUEST_CODE_CART)) {
                viewPager.setCurrentItem(2);
            }
        } catch (Exception e) {

        }
    }

    private void CheckIdUser() {
        if (!DataLocalManager.getPrefIdUser().isEmpty()) {
            return;
        }

        String urlSetIdUser = Config.LOCALHOST + "GetIDUser.php?UserName=" + UserName;

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, urlSetIdUser, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        DataLocalManager.setPrefIdUser(jsonObject.getString("ID_User"));
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

    private void SetViewPage() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    //check xem đang ở fragment nào thì bottom sáng
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_tab_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_tab_favorites).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_tab_store).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.menu_tab_account).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //bắt sự kiện Click vào bottomnav để chuyển fragment
                switch (item.getItemId()) {
                    case R.id.menu_tab_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_tab_favorites:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_tab_store:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.menu_tab_account:
                        viewPager.setCurrentItem(3);
                        break;
                }

                return true;
            }
        });
    }

    private void initView() {
        bottomNavigationView = findViewById(R.id.bottomNavView);
        viewPager = findViewById(R.id.ViewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        //Số fragment load trước
        viewPager.setOffscreenPageLimit(3);

        char[] chars = new char[15];
        DataLocalManager.getPrefUserName().getChars(1, 12, chars, 0);
        UserName = String.valueOf(chars);
    }
}