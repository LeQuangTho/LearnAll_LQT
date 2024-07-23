package com.lqt.duynguyenhairsalon.Model.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.lqt.duynguyenhairsalon.Activities.Booking.Admin.DescriptionTaskActivity;
import com.lqt.duynguyenhairsalon.Model.mTask;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.R.color;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {


    private static final int REQUEST_CODE = 123;
    /*
     * @param KEY_FRAGEMENT
     * nếu true là Successful
     * nếu false là Unsuccessful
     * */
    private Activity activity;
    private List<mTask> mTaskList;
    private boolean isSuccessful;

    public void setData(List<mTask> data) {
        this.mTaskList = data;
        notifyDataSetChanged();
    }

    public TaskAdapter(Activity activity, boolean isSuccessful) {
        this.activity = activity;
        this.isSuccessful = isSuccessful;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        mTask task = mTaskList.get(position);
        if (task == null) {
            return;
        }

        if (isSuccessful == true) {
            holder.constraintLayout.setBackgroundResource(color.hoan_thanh);
        } else {
            holder.constraintLayout.setBackgroundResource(color.chua_hoan_thanh);
        }
        holder.textViewName.setText("" + task.getUser().getName_User());
        holder.textViewPhone.setText("" + task.getUser().getPhone_Number_User());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DescriptionTaskActivity.class);

                intent.putExtra("isSuccsessful", isSuccessful);

                Gson gson = new Gson();
                String data = gson.toJson(task);
                intent.putExtra("data", data);
                activity.startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mTaskList != null) {
            return mTaskList.size();
        }
        return 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName, textViewPhone;
        private ConstraintLayout constraintLayout;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_Name);
            textViewPhone = itemView.findViewById(R.id.textView_Phone);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
