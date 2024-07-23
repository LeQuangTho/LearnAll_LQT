package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqt.duynguyenhairsalon.Activities.Booking.Customer.SelectServiceActivity;
import com.lqt.duynguyenhairsalon.Model.ServicesDuyNguyenHairSalon;
import com.lqt.duynguyenhairsalon.R;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceHolder> {
    private List<ServicesDuyNguyenHairSalon> listService;
    private SelectServiceActivity activity;
    private int mPosition = -1;
    private int idSpecies;

    public ServiceAdapter(SelectServiceActivity activity, int ID_Species) {
        this.activity = activity;
        this.idSpecies = ID_Species;
    }

    public void setData(List<ServicesDuyNguyenHairSalon> list) {
        this.listService = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServiceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_service_duynguyen_hair_salon, parent, false);
        return new ServiceHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceHolder holder, int position) {
        ServicesDuyNguyenHairSalon service = listService.get(position);
        if (service != null) {
            if (service.isSelected()) {
                holder.checkBoxService.setChecked(service.isSelected());
            } else {
                holder.checkBoxService.setChecked(service.isSelected());
            }
            holder.textViewNameService.setText("" + service.getNameService());
            holder.textViewDescriptionService.setText("" + service.getDescriptionService());
            holder.textViewPriceService.setText("" + service.getPriceService() / 1000 + "K");
        }

        /*

         * Nếu đang ở chọn dịch vụ khác thì nó sẽ cho chọn nhiều dịch vụ cùng loại
         * còn ở các tab khác chỉ được chọn 1 dịch vụ trong loại đó
         *
         * */
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idSpecies != 4) {
                    if (service.isSelected()) {
                        service.setSelected(!service.isSelected());
                        activity.removeServicesList(listService.get(position));
                        mPosition = -1;
                    } else {
                        if (mPosition == -1) {
                            service.setSelected(!service.isSelected());
                            activity.addServicesList(listService.get(position));
                            mPosition = position;
                        } else {
                            listService.get(mPosition).setSelected(false);
                            activity.removeServicesList(listService.get(mPosition));
                            service.setSelected(!service.isSelected());
                            activity.addServicesList(listService.get(position));
                            mPosition = position;
                        }
                    }
                } else {
                    if (service.isSelected()) {
                        service.setSelected(!service.isSelected());
                        activity.removeServicesList(listService.get(position));

                    } else {
                        service.setSelected(!service.isSelected());
                        activity.addServicesList(listService.get(position));
                    }
                }
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listService != null) {
            return listService.size();
        }
        return 0;
    }

    public class ServiceHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBoxService;
        private TextView textViewNameService;
        private TextView textViewDescriptionService;
        private TextView textViewPriceService;
        private LinearLayout linearLayout;

        public ServiceHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxService = itemView.findViewById(R.id.checkBox_Service);
            textViewNameService = itemView.findViewById(R.id.textView_NameService);
            textViewDescriptionService = itemView.findViewById(R.id.textView_DescriptionService);
            textViewPriceService = itemView.findViewById(R.id.textView_PriceService);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
