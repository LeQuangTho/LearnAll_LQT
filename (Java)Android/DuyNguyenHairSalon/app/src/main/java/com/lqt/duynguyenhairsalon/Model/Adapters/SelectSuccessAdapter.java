package com.lqt.duynguyenhairsalon.Model.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lqt.duynguyenhairsalon.Fragments.Booking.Admin.SuccessfulFragment;
import com.lqt.duynguyenhairsalon.Fragments.Booking.Admin.UnsuccessfulFragment;

public class SelectSuccessAdapter extends FragmentStateAdapter {
    public SelectSuccessAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new UnsuccessfulFragment();
            case 1:
                return new SuccessfulFragment();
            default:
                return new SuccessfulFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
