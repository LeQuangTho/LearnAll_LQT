package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqt.duynguyenhairsalon.Model.DeliveryAddress.District;
import com.lqt.duynguyenhairsalon.Model.DeliveryAddress.Province;
import com.lqt.duynguyenhairsalon.Model.DeliveryAddress.Ward;
import com.lqt.duynguyenhairsalon.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListADWAdapter extends RecyclerView.Adapter<ListADWAdapter.ADWHolder> {
    private Context context;
    private View view;
    private List listADW;
    private String leverAddress;
    private IDeliveryAddress iDeliveryAddress;

    public interface IDeliveryAddress {
        String PROVINCE = "province";
        String DISTRICT = "district?province_id=";
        String WARD = "ward?district_id=";

        void onItemClickListener(Object o);
    }

    public ListADWAdapter(Context context, String leverAddress, IDeliveryAddress iDeliveryAddress) {
        this.context = context;
        this.leverAddress = leverAddress;
        this.iDeliveryAddress = iDeliveryAddress;
    }

    public void setData(List listADW) {
        this.listADW = listADW;

        if (leverAddress.equals(IDeliveryAddress.PROVINCE)) {
            Collections.sort(listADW, new Comparator<Province>() {
                @Override
                public int compare(Province o1, Province o2) {
                    return o1.getNameProvince().compareTo(o2.getNameProvince());
                }
            });
        } else if (leverAddress.equals(IDeliveryAddress.DISTRICT)) {
            Collections.sort(listADW, new Comparator<District>() {
                @Override
                public int compare(District o1, District o2) {
                    return o1.getNameDistrict().compareTo(o2.getNameDistrict());
                }
            });
        } else {
            Collections.sort(listADW, new Comparator<Ward>() {
                @Override
                public int compare(Ward o1, Ward o2) {
                    return o1.getNameWard().compareTo(o2.getNameWard());
                }
            });
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ADWHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.item_adw, parent, false);
        return new ADWHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ADWHolder holder, int position) {
        if (listADW == null) {
            return;
        }

        if (leverAddress.equals(IDeliveryAddress.PROVINCE)) {
            Province province = (Province) listADW.get(position);
            holder.textView.setText("" + province.getNameProvince());
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iDeliveryAddress.onItemClickListener(province);
                }
            });
        } else if (leverAddress.equals(IDeliveryAddress.DISTRICT)) {
            District district = (District) listADW.get(position);
            holder.textView.setText("" + district.getNameDistrict());
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iDeliveryAddress.onItemClickListener(district);
                }
            });
        } else {
            Ward ward = (Ward) listADW.get(position);
            holder.textView.setText("" + ward.getNameWard());
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iDeliveryAddress.onItemClickListener(ward);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (listADW != null) {
            return listADW.size();
        }
        return 0;
    }

    public class ADWHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ADWHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_ADW);
        }
    }
}

