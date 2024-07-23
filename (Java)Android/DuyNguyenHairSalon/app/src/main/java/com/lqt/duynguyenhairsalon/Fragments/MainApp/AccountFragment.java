package com.lqt.duynguyenhairsalon.Fragments.MainApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.lqt.duynguyenhairsalon.Activities.HistoryCutActivity;
import com.lqt.duynguyenhairsalon.Activities.Login.CustomerDetailActivity;
import com.lqt.duynguyenhairsalon.Activities.MemberActivity;
import com.lqt.duynguyenhairsalon.Activities.Other.IntroActivity;
import com.lqt.duynguyenhairsalon.Activities.Other.LocationActivity;
import com.lqt.duynguyenhairsalon.Activities.RewardsActivity;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;


public class AccountFragment extends Fragment {

    private View view;
    private ConstraintLayout constraintLayoutEditAccount;
    private CardView cardViewMember, cardViewRewards, cardViewHistory, cardViewLocation, cardViewLogin_Logout;
    private TextView textViewLogin_Logout;
    private ImageView imageViewLogin_Logout;
    private LinearLayout linearLayoutLogin_Logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_account, container, false);

        initView();

        listFragment();
        return view;
    }

    private void listFragment() {
        constraintLayoutEditAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CustomerDetailActivity.class));
            }
        });

        cardViewMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MemberActivity.class));
            }
        });
        cardViewRewards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RewardsActivity.class));
            }
        });
        cardViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HistoryCutActivity.class));
            }
        });
        cardViewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LocationActivity.class));
            }
        });
        cardViewLogin_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Đăng xuất", Toast.LENGTH_SHORT).show();

                //Reset Shared Preferences
                DataLocalManager.resetSharaPreferences();

                getActivity().finish();
                getActivity().startActivity(new Intent(getContext(), IntroActivity.class));
                getActivity().finishAffinity();
            }
        });
    }

    private void initView() {
        constraintLayoutEditAccount = view.findViewById(R.id.constraintLayout_EditAccount);
        cardViewMember = view.findViewById(R.id.cardView_Member);
        cardViewRewards = view.findViewById(R.id.cardView_Rewards);
        cardViewHistory = view.findViewById(R.id.cardView_History);
        cardViewLocation = view.findViewById(R.id.cardView_Location);

        cardViewLogin_Logout = view.findViewById(R.id.cardView_Login_Logout);
        linearLayoutLogin_Logout = view.findViewById(R.id.linearLayout_Login_Logout);
        textViewLogin_Logout = view.findViewById(R.id.textView_Login_Logout);
        imageViewLogin_Logout = view.findViewById(R.id.imageView_Login_Logout);
    }
}