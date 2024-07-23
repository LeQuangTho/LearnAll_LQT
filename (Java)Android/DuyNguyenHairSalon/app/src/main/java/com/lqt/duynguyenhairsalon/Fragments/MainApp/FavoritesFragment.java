package com.lqt.duynguyenhairsalon.Fragments.MainApp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.lqt.duynguyenhairsalon.Model.Adapters.FavoritesAdapter;
import com.lqt.duynguyenhairsalon.Model.ItemFavorites;
import com.lqt.duynguyenhairsalon.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FavoritesFragment extends Fragment {

    private Context context;
    private View view;

    private RecyclerView recyclerView;
    private FavoritesAdapter adapter;
    private List<ItemFavorites> itemFavoritesList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorites, container, false);

        initView();

        getDataFavorite();

        loadList();

        return view;
    }

    private void getDataFavorite() {
        itemFavoritesList = new ArrayList<>();
        int resource[] = {R.drawable.demotoc1, R.drawable.demotoc2
                , R.drawable.demotoc3, R.drawable.demotoc4
                , R.drawable.demotoc5, R.drawable.demotoc6
                , R.drawable.demotoc7};
        String name[] = {"Kiểu đẹp rai", "Kiểu íu đúi"
                , "Tóc đẹp không \n giữ nhé?", "Ai là nàng thơ dơ tay!"
                , "Em không là nàng thơ..ơ..ơ", "Mèo méo meo mèo meo"
                , "gái nhắt đó"};
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int r = random.nextInt(7);
            itemFavoritesList.add(new ItemFavorites(resource[i], name[i]));
        }
    }

    private void loadList() {
        adapter = new FavoritesAdapter(view.getContext());

        /*
         * do đây là bố cục so le nên ta phải xét layoutmanager cho nó là Stagger
         * thêm nữa để có thể xử lí được vấn đề ảnh quá to so với
         * khung thì ta xét thuộc tính android:adjustViewBounds="true" cho ImageView
         *
         * */

        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(gridLayoutManager);

        adapter.setData(itemFavoritesList);

        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.recyclerView_Favorites);
    }
}