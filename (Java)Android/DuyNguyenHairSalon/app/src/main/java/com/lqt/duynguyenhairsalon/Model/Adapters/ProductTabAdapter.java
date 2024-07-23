package com.lqt.duynguyenhairsalon.Model.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lqt.duynguyenhairsalon.Fragments.Shopping.Customer.DescriptionFragment;
import com.lqt.duynguyenhairsalon.Fragments.Shopping.Customer.InfomationFragment;
import com.lqt.duynguyenhairsalon.Fragments.Shopping.Customer.UsingFragment;

public class ProductTabAdapter extends FragmentStateAdapter {
    public ProductTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new InfomationFragment();
            case 1:
                return new DescriptionFragment();
            case 2:
                return new UsingFragment();
            default:
                return new InfomationFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
