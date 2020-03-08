package com.example.barberbooker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.barberbooker.adapter.Barber1Adapter;
import com.example.barberbooker.adapter.BarberAdapter;
import com.example.barberbooker.api.ApiClient;
import com.example.barberbooker.domain.Barber;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalonActivity extends AppCompatActivity {
    TextView textView;
    RecyclerView recyclerView;
    ArrayList<Barber> barbers;
    Barber1Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);
        textView=(TextView) findViewById(R.id.salonTitle);
        String title=getIntent().getStringExtra("salon name");
        textView.setText(title);
        String salon="3";
        loadData(salon);
    }
    private void loadData(String salon){
        Call<ArrayList<Barber>> call= ApiClient.getInstance().getApi().getBarbersBySalon(salon);
        call.enqueue(new Callback<ArrayList<Barber>>() {
            @Override
            public void onResponse(Call<ArrayList<Barber>> call, Response<ArrayList<Barber>> response) {
                barbers=response.body();
                setContentView(R.layout.activity_salon);
                recyclerView= findViewById(R.id.recyclerBarbers);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter=new Barber1Adapter(SalonActivity.this,barbers);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Barber>> call, Throwable t) {
                Toast.makeText(SalonActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
