package com.example.barberbooker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.example.barberbooker.adapter.BarberAdapter;
import com.example.barberbooker.api.ApiClient;
import com.example.barberbooker.domain.Barber;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BarberAdapter adapter;
    ArrayList<Barber> barbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       Intent intent=getIntent();
//        String salon=intent.getStringExtra("salon_nu");
        String salon="1";
        loadData(salon);
    }
    private void loadData(String salon){
        Call<ArrayList<Barber>> call=ApiClient.getInstance().getApi().getBarbersBySalon(salon);
        call.enqueue(new Callback<ArrayList<Barber>>() {
            @Override
            public void onResponse(Call<ArrayList<Barber>> call, Response<ArrayList<Barber>> response) {
                barbers.clear();
                barbers=response.body();
                setContentView(R.layout.activity_main);
                recyclerView= findViewById(R.id.recyclerV);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter=new BarberAdapter(MainActivity.this,barbers);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Barber>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
