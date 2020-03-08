package com.example.barberbooker.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.barberbooker.R;
import com.example.barberbooker.SalonActivity;
import com.example.barberbooker.domain.Salon;

import java.util.ArrayList;

public class SalonAdapter  extends RecyclerView.Adapter<SalonHolder>{
    Context context;
    ArrayList<Salon> model;

    public SalonAdapter(Context context, ArrayList<Salon> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public SalonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.salon_row,null);
        return new SalonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SalonHolder holder, int position) {
        Salon salon = model.get(position);
        //Log.d("onBindViewHolder:",salon.getSalon_loc());
        System.out.println(salon.getSalon_loc());
        final String sname=String.valueOf(salon.getSalon_name());
        holder.sName.setText(sname);
        String sloc=String.valueOf(salon.getSalon_loc());
        holder.sLoc.setText(sloc);
        String sstat=String.valueOf(salon.getSalon_status());
        holder.sStatus.setText(sstat);

        holder.setItemClickListener(new ItemClick() {
            @Override
            public void onClickListener(View v, int layoutPosition) {
                Intent intent=new Intent(context, SalonActivity.class);
                intent.putExtra("salon name",sname);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}
