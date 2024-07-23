package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqt.duynguyenhairsalon.Model.ProductDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.R;

import java.util.List;

public class ProductInCartAdapter extends RecyclerView.Adapter<ProductInCartAdapter.ProductInCartHolder> {

    private List<ProductDuyNguyenHairSalon> productList;
    private Context context;
    private View view;
    private IClickChangeProductListener iClickChangeProductListener;

    public interface IClickChangeProductListener {
        String UP = "up";
        String DOWN = "down";
        String DELETE = "delete";
        String OPTION_CHANGE = "change";

        void onClickUpProduct(ProductDuyNguyenHairSalon product);

        void onClickDownProduct(ProductDuyNguyenHairSalon product);

        void onClickDeleteProduct(ProductDuyNguyenHairSalon product);
    }

    public ProductInCartAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ProductDuyNguyenHairSalon> productList, IClickChangeProductListener listener) {
        this.productList = productList;
        this.iClickChangeProductListener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductInCartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_product_in_cart, parent, false);
        return new ProductInCartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductInCartHolder holder, int position) {
        ProductDuyNguyenHairSalon product = productList.get(position);
        if (product == null) {
            return;
        }

        holder.textViewNameProduct.setText("" + product.getName_Product());
        holder.textViewPriceProduct.setText("đ" + product.getPrice_Product() * product.getAmount_Product());
        holder.textViewAmountProduct.setText("" + product.getAmount_Product());
        holder.imageButtonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickChangeProductListener.onClickUpProduct(product);
            }
        });

        holder.imageButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickChangeProductListener.onClickDownProduct(product);
            }
        });

        holder.imageViewRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickChangeProductListener.onClickDeleteProduct(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (productList != null) {
            return productList.size();
        }
        return 0;
    }

    public class ProductInCartHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewDemoProduct;
        private TextView textViewNameProduct;
        private TextView textViewPriceProduct;
        private ImageButton imageButtonDown;
        private ImageButton imageButtonUp;
        private TextView textViewAmountProduct;
        private ImageView imageViewRemove;

        public ProductInCartHolder(@NonNull View itemView) {
            super(itemView);
            imageViewDemoProduct = itemView.findViewById(R.id.imageView_DemoProduct);
            textViewNameProduct = itemView.findViewById(R.id.textView_NameProduct);
            textViewPriceProduct = itemView.findViewById(R.id.textView_PriceProduct);
            imageButtonDown = itemView.findViewById(R.id.imageButton_Down);
            imageButtonUp = itemView.findViewById(R.id.imageButton_Up);
            textViewAmountProduct = itemView.findViewById(R.id.textView_AmountProduct);
            imageViewRemove = itemView.findViewById(R.id.imageView_RemoveProduct);
        }
    }
}
