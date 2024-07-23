package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.Model.SpeciesProduct;
import com.lqt.duynguyenhairsalon.R;

import java.util.List;

public class SpeciesProductAdapter extends RecyclerView.Adapter<SpeciesProductAdapter.SpeciesProductHolder> {

    private List<SpeciesProduct> speciesProductList;
    private Context context;
    private View view;
    private IClickSpeciesProductListener iClickSpeciesProductListener;

    public interface IClickSpeciesProductListener {
        String KEY_SPECIES = "SPECEIS";

        void onClickSpeciesProduct(String keyWord, SpeciesProduct speciesProduct);
    }

    public SpeciesProductAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<SpeciesProduct> speciesProductList, IClickSpeciesProductListener iClickSpeciesProductListener) {
        this.speciesProductList = speciesProductList;
        this.iClickSpeciesProductListener = iClickSpeciesProductListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SpeciesProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_species_product, parent, false);
        return new SpeciesProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpeciesProductHolder holder, int position) {
        if (speciesProductList.get(position) == null) {
            return;
        }
        holder.textViewSpeciesProduct.setText(speciesProductList.get(position).getName_SpeciesProduct());
        Glide.with(context).load(Config.LOCALHOST_IMG + speciesProductList.get(position).getImage_SpeciesProduct()).into(holder.imageViewSpeciesProduct);
        holder.linearLayout_SpeciesProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickSpeciesProductListener.onClickSpeciesProduct(IClickSpeciesProductListener.KEY_SPECIES
                        , speciesProductList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (speciesProductList != null) {
            return speciesProductList.size();
        }
        return 0;
    }

    public class SpeciesProductHolder extends RecyclerView.ViewHolder {

        ImageView imageViewSpeciesProduct;
        TextView textViewSpeciesProduct;
        LinearLayout linearLayout_SpeciesProduct;

        public SpeciesProductHolder(@NonNull View itemView) {
            super(itemView);
            imageViewSpeciesProduct = itemView.findViewById(R.id.imageView_Species);
            textViewSpeciesProduct = itemView.findViewById(R.id.textView_NameSpecies);
            linearLayout_SpeciesProduct = itemView.findViewById(R.id.linearLayout_Species);
        }
    }
}
