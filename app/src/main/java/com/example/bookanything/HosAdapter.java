package com.example.bookanything;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HosAdapter extends RecyclerView.Adapter<HosAdapter.MyViewHolder> {

    ArrayList<HosModel> hosDataList;
    Context context;

    public HosAdapter(ArrayList<HosModel> hosDataList, Context mContext) {

        this.hosDataList = hosDataList;
        context = mContext;

    }

    @NonNull
    @Override
    public HosAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hos_list,parent,false);
        return new HosAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HosAdapter.MyViewHolder holder, int position) {

        holder.name.setText(hosDataList.get(position).getName());
        holder.time.setText(hosDataList.get(position).getTime());

        holder.cardView.setOnClickListener(v -> {

            Intent intent = new Intent(context,HosConfirm.class);
            intent.putExtra("hos_name", hosDataList.get(position).getName());
            intent.putExtra("time", hosDataList.get(position).getTime());
            intent.putExtra("location",hosDataList.get(position).getLocation());
            intent.putExtra("special",hosDataList.get(position).getSpecial());
            intent.putExtra("date",hosDataList.get(position).getDate());
            intent.putExtra("type",hosDataList.get(position).getType());
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return hosDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,time;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.hos_name);
            time=itemView.findViewById(R.id.hos_time);
            cardView=itemView.findViewById(R.id.hos_list_card);

        }
    }

}
