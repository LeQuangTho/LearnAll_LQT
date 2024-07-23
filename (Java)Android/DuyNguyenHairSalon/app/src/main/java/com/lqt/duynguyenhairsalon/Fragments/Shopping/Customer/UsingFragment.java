package com.lqt.duynguyenhairsalon.Fragments.Shopping.Customer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.lqt.duynguyenhairsalon.Activities.Shopping.Customer.DetailProductActivity;
import com.lqt.duynguyenhairsalon.R;

public class UsingFragment extends Fragment {
    //View
    private View view;
    private TextView textViewUsing;
    private DetailProductActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_using, container, false);

        initView();

        SetData();

        return view;
    }

    private void SetData() {
        textViewUsing.setText("" + activity.getUsing_Product());
    }

    private void initView() {
        textViewUsing = view.findViewById(R.id.textView_Using);
        activity = (DetailProductActivity) getActivity();
    }
}