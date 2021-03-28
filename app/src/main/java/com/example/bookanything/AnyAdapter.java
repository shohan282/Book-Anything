package com.example.bookanything;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnyAdapter  extends RecyclerView.Adapter<AnyAdapter.MyViewHolder> {

    ArrayList<model> dataList;

    public AnyAdapter(ArrayList<model> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(dataList.get(position).getName());
        holder.date.setText("Date: "+dataList.get(position).getDate());
        holder.time.setText(dataList.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,date,time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.list_name);
            date=itemView.findViewById(R.id.list_date);
            time=itemView.findViewById(R.id.list_time);

        }
    }

}
