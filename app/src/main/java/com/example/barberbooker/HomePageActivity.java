package com.example.barberbooker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.barberbooker.adapter.BarberAdapter;
import com.example.barberbooker.adapter.SalonAdapter;
import com.example.barberbooker.api.ApiClient;
import com.example.barberbooker.domain.Barber;
import com.example.barberbooker.domain.Salon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePageActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SalonAdapter adapter;
    ArrayList<Salon> salons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        loadData();
    }
    private void loadData(){
        Call<ArrayList<Salon>> call= ApiClient.getInstance().getApi().getSalons();
        call.enqueue(new Callback<ArrayList<Salon>>() {
            @Override
            public void onResponse(Call<ArrayList<Salon>> call, Response<ArrayList<Salon>> response) {
                salons=response.body();
                setContentView(R.layout.activity_home_page);
                recyclerView= findViewById(R.id.recyclerVSalons);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter=new SalonAdapter(HomePageActivity.this,salons);
                recyclerView.setAdapter(adapter);
                //Toast.makeText(HomePageActivity.this,salons.get(0).getSalon_loc(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayList<Salon>> call, Throwable t) {
                Toast.makeText(HomePageActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
