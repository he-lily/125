package com.example.timetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FragmentPlanAdapter extends RecyclerView.Adapter<FragmentPlanAdapter.fpViewHolder>{
    List<String> mCatNames;
    List<Double> mCatTimes;
    Context mContext;

    public FragmentPlanAdapter(Context context, List<String> catNames, List<Double> catTimes){
        mContext = context;
        mCatNames = catNames;
        mCatTimes = catTimes;
    }

    @NonNull
    @Override
    public fpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_fragment_plan, parent, false);
        fpViewHolder holder = new fpViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull fpViewHolder holder, int position) {
        holder.catName.setText(mCatNames.get(position).replace("\"", ""));
        holder.catTime.setText(mCatTimes.get(position).toString() + " \n/ 30 mins");
    }

    @Override
    public int getItemCount() {
        return mCatNames.size();
    }

    private void updateProgress(@NonNull fpViewHolder holder, int position){
        double dt = mCatTimes.get(position) / 60; // Divide by 60 (mins) as arbitrary value for now
        int it = (int)dt * 100; // Multiply by 100 to get whole number value (int)
        holder.catBar.setProgress(it);
    }

    public class fpViewHolder extends RecyclerView.ViewHolder {
        public TextView catName;
        public TextView catTime;
        public ProgressBar catBar;

        public fpViewHolder(@NonNull View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.catName);
            catTime = itemView.findViewById(R.id.catTime);
            catBar = itemView.findViewById(R.id.catBar);
        }
    }
}
