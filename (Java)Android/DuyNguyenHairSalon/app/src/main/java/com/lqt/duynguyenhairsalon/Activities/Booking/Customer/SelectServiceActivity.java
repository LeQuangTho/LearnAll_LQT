package com.lqt.duynguyenhairsalon.Activities.Booking.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.lqt.duynguyenhairsalon.Activities.Home.MainActivity;
import com.lqt.duynguyenhairsalon.Model.Adapters.SelectServiceFragmentAdapter;
import com.lqt.duynguyenhairsalon.Model.ServicesDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.R;

import java.util.ArrayList;
import java.util.List;

public class SelectServiceActivity extends AppCompatActivity {

    //Layout
    private TabLayout tabLayoutSelectSevice;
    private ViewPager2 viewPager2SelectService;
    private ImageView imageViewHome;
    private Button buttonSuccess;

    //Adapter
    private SelectServiceFragmentAdapter fragmentAdapter;

    //List
    private List<ServicesDuyNguyenHairSalon> servicesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service);

        initView();

        SelectServiceListen();

        fragmentAdapter = new SelectServiceFragmentAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2SelectService.setAdapter(fragmentAdapter);
        tabLayoutSelectSevice.addTab(tabLayoutSelectSevice.newTab().setText(R.string.tab_layout_cat_goi_massage));
        tabLayoutSelectSevice.addTab(tabLayoutSelectSevice.newTab().setText(R.string.tab_layout_uon));
        tabLayoutSelectSevice.addTab(tabLayoutSelectSevice.newTab().setText(R.string.tab_layout_nhuom));
        tabLayoutSelectSevice.addTab(tabLayoutSelectSevice.newTab().setText(R.string.tab_layout_dich_vu_khac));

        /*
         * click TabLayout
         * */
        tabLayoutSelectSevice.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2SelectService.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        /*
         * Vuốt
         * */
        viewPager2SelectService.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayoutSelectSevice.selectTab(tabLayoutSelectSevice.getTabAt(position));
            }
        });


    }

    private void SelectServiceListen() {
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectServiceActivity.this, MainActivity.class));
            }
        });

        buttonSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                String data = gson.toJson(servicesList);
                Intent intent = new Intent();
                intent.putExtra("data", data);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void initView() {
        tabLayoutSelectSevice = (TabLayout) findViewById(R.id.tabLayout_SelectService);
        viewPager2SelectService = (ViewPager2) findViewById(R.id.viewPager2_SelectService);
        imageViewHome = (ImageView) findViewById(R.id.imageView_Home);
        buttonSuccess = (Button) findViewById(R.id.button_SuccessSelect);
    }

    public void addServicesList(ServicesDuyNguyenHairSalon service) {
        if (servicesList.size() != 0) {
            this.servicesList.add(service);
            buttonSuccess.setText("Chọn " + servicesList.size() + " dịch vụ");
        } else {
            this.servicesList.add(service);
            buttonSuccess.setText("Chọn " + servicesList.size() + " dịch vụ");
            buttonSuccess.setBackgroundResource(R.drawable.background_topup);
        }

    }

    public void removeServicesList(ServicesDuyNguyenHairSalon service) {
        this.servicesList.remove(service);
        if (servicesList.size() == 0) {
            buttonSuccess.setText("Chọn dịch vụ");
            buttonSuccess.setBackgroundResource(R.color.common_google_signin_btn_text_dark_disabled);
        } else {
            buttonSuccess.setText("Chọn " + servicesList.size() + " dịch vụ");
        }
    }
}