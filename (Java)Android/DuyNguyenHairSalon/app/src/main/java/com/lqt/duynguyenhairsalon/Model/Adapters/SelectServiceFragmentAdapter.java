package com.lqt.duynguyenhairsalon.Model.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lqt.duynguyenhairsalon.Fragments.SelecctServices.OtherServicesFragment;
import com.lqt.duynguyenhairsalon.Fragments.SelecctServices.ServiceCurlingFragment;
import com.lqt.duynguyenhairsalon.Fragments.SelecctServices.ServiceCutMassageFragment;
import com.lqt.duynguyenhairsalon.Fragments.SelecctServices.ServiceDyeingFragment;

public class SelectServiceFragmentAdapter extends FragmentStateAdapter {

    public SelectServiceFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ServiceCutMassageFragment();
            case 1:
                return new ServiceCurlingFragment();
            case 2:
                return new ServiceDyeingFragment();
            case 3:
                return new OtherServicesFragment();
            default:
                return new ServiceCutMassageFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
