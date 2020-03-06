package com.example.barberbooker.api;
import com.example.barberbooker.domain.Barber;
import com.example.barberbooker.domain.Owner;
import com.example.barberbooker.domain.Salon;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    @FormUrlEncoded
    @POST ("saveBarber")
    Call<ResponseBody> saveBarberData(
           @Field("fName") String firstName,
           @Field("lName") String lastName,
           @Field("phoneNo") String phoneNo
    );

    @GET("listBarbers")
    Call<ArrayList<Barber>> getBarbaers();

    @GET("listOwners")
    Call<ArrayList<Owner>> getOwners();

    @GET("listSalons")
    Call<ArrayList<Salon>> getSalons();

    @GET("listBarbers/{salon_no}")
    Call<ArrayList<Barber>> getBarbersBySalon(@Path("salon_no") String salon_no);
}
