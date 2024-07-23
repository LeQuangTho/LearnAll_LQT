package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqt.duynguyenhairsalon.Model.ServicesDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.R;

import java.util.List;

public class AdminServiceAdapter extends RecyclerView.Adapter<AdminServiceAdapter.AdminServiceHolder> {

    private View view;
    private Context context;
    private List<ServicesDuyNguyenHairSalon> serviceList;

    public AdminServiceAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ServicesDuyNguyenHairSalon> serviceList) {
        this.serviceList = serviceList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdminServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_service_duynguyen_hair_salon, parent, false);

        return new AdminServiceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminServiceHolder holder, int position) {
        ServicesDuyNguyenHairSalon service = serviceList.get(position);

        if (service == null) {
            return;
        }

        holder.textViewNameService.setText("" + service.getNameService());
        holder.textViewPriceService.setText("" + service.getPriceService() / 1000 + "K");
        holder.checkBoxService.setVisibility(View.GONE);
        holder.textViewDescriptionService.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        if (serviceList != null) {
            return serviceList.size();
        }
        return 0;
    }

    public class AdminServiceHolder extends RecyclerView.ViewHolder {

        TextView textViewNameService, textViewPriceService, textViewDescriptionService;
        CheckBox checkBoxService;

        public AdminServiceHolder(@NonNull View itemView) {
            super(itemView);
            textViewNameService = itemView.findViewById(R.id.textView_NameService);
            textViewPriceService = itemView.findViewById(R.id.textView_PriceService);
            textViewDescriptionService = itemView.findViewById(R.id.textView_DescriptionService);
            checkBoxService = itemView.findViewById(R.id.checkBox_Service);
        }
    }
}
