package com.example.barberbooker.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barberbooker.R;

public class BarberHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView tName;
    TextView tPhone;
    TextView tStatus;
    ItemClick itemClickListener;
    BarberHolder(@NonNull View itemView) {
        super(itemView);
        this.tName=itemView.findViewById(R.id.txtName);
        this.tPhone=itemView.findViewById(R.id.txtPhone);
        this.tStatus=itemView.findViewById(R.id.txtStatus);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
          this.itemClickListener.onClickListener(v,getLayoutPosition());
}

    public void setItemClickListener(ItemClick itc){
        this.itemClickListener=itc;
    }
}
