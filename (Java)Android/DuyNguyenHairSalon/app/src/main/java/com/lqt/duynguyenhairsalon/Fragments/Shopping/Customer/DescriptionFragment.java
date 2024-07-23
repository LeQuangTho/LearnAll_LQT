package com.lqt.duynguyenhairsalon.Fragments.Shopping.Customer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.lqt.duynguyenhairsalon.Activities.Shopping.Customer.DetailProductActivity;
import com.lqt.duynguyenhairsalon.R;

public class DescriptionFragment extends Fragment {
    //View
    private View view;
    private TextView textViewDescription;
    private DetailProductActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_description, container, false);

        initView();

        SetData();
        return view;
    }

    private void SetData() {
        textViewDescription.setText("" + activity.getDescription_Product());
    }

    private void initView() {
        textViewDescription = view.findViewById(R.id.textView_Description);
        activity = (DetailProductActivity) getActivity();
    }
}