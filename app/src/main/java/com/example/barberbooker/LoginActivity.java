package com.example.barberbooker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.barberbooker.api.ApiClient;
import com.example.barberbooker.domain.Owner;
import com.example.barberbooker.domain.Salon;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    List<Salon> owners=new ArrayList<>();
    EditText edtPhone;
    EditText edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtPhone=(EditText) findViewById(R.id.editTPhone);
        edtPassword=(EditText) findViewById(R.id.editTPassword);
        btnLogin=(Button) findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtPhone.getText().toString().length()!=0 && edtPassword.getText().toString().length()!=0){
                    String phoneNo=edtPhone.getText().toString();
                    String password=edtPassword.getText().toString();
                    checkCridentials(phoneNo,password);
                }else {
                    Toast.makeText(LoginActivity.this,"Fill above fields!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void checkCridentials(final String ph, final String ps){
            Call<ArrayList<Salon>> call= ApiClient.getInstance().getApi().getSalons();
            call.enqueue(new Callback<ArrayList<Salon>>() {
                @Override
                public void onResponse(Call<ArrayList<Salon>> call, Response<ArrayList<Salon>> response) {
                    owners=response.body();
                    for (Salon o:owners){
                        if(o.getSalon_id().equals(Integer.parseInt(ps))){
                               startActivity(new Intent(getApplicationContext(),MainActivity.class).putExtra("salon_nu",ps));
                            break;
                        }
                    }
                    //Toast.makeText(LoginActivity.this,"Salon Not Found!",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<ArrayList<Salon>> call, Throwable t) {
                    Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
}

