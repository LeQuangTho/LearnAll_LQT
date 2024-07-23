package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lqt.duynguyenhairsalon.Model.BookingTime;
import com.lqt.duynguyenhairsalon.R;

import java.util.List;

public class SelectTimeAdapter extends RecyclerView.Adapter<SelectTimeAdapter.SelectTimeViewHolde> {
    private List<BookingTime> bookingTimes;
    private Context context;
    private int mPosition = -1;
    private String mTime = "";

    public void setData(List<BookingTime> bookingTimes) {
        this.bookingTimes = bookingTimes;
        notifyDataSetChanged();
    }

    public SelectTimeAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public SelectTimeViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_button_select_time, parent, false);
        return new SelectTimeViewHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectTimeViewHolde holder, int position) {
        BookingTime bookingTime = bookingTimes.get(position);
        if (bookingTime == null) {
            return;
        }

        holder.buttonTime.setText(bookingTime.getmTime());

        if (!bookingTime.isSelected()) {
            holder.buttonTime.setEnabled(true);
            holder.buttonTime.setBackgroundResource(R.drawable.background_border_black);
        } else {
            holder.buttonTime.setBackgroundResource(R.drawable.background_view_disible);
            holder.buttonTime.setEnabled(false);
        }

        if (!bookingTime.isSelecting() && !bookingTime.isSelected()) {
            holder.buttonTime.setBackgroundResource(R.drawable.background_border_black);
        } else if (bookingTime.isSelecting() && !bookingTime.isSelected()) {
            holder.buttonTime.setBackgroundResource(R.drawable.background_topup);
        }

        holder.buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookingTime.isSelected()) {
                    return;
                } else {
                    if (mPosition != -1) {
                        bookingTimes.get(mPosition).setSelecting(false);
                    }
                    mPosition = position;
                    mTime = bookingTime.getTimeCut();
                    bookingTimes.get(position).setSelecting(true);
                }
                notifyDataSetChanged();
            }
        });
    }

    /*
     * Đây là hàm sẽ trả về vị trí khách hàng hiện tại đang đăt
     *
     * */
    public int getPositionSelceted() {
        return mPosition;
    }

    public String getmTime() {
        return mTime;
    }

    @Override
    public int getItemCount() {
        if (bookingTimes != null) return bookingTimes.size();
        return 0;
    }

    public class SelectTimeViewHolde extends RecyclerView.ViewHolder {
        private Button buttonTime;

        public SelectTimeViewHolde(@NonNull View itemView) {
            super(itemView);
            buttonTime = itemView.findViewById(R.id.button_Time);
        }
    }
}
