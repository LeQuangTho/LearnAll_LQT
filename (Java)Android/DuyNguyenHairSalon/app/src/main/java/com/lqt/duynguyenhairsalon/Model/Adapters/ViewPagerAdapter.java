package com.lqt.duynguyenhairsalon.Model.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.lqt.duynguyenhairsalon.Fragments.MainApp.AccountFragment;
import com.lqt.duynguyenhairsalon.Fragments.MainApp.FavoritesFragment;
import com.lqt.duynguyenhairsalon.Fragments.MainApp.HomeFragment;
import com.lqt.duynguyenhairsalon.Fragments.MainApp.StoreFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new FavoritesFragment();
            case 2:
                return new StoreFragment();
            case 3:
                return new AccountFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
