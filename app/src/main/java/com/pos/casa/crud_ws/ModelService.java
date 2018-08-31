package com.pos.casa.crud_ws;

import android.app.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ModelService {

    //get all
    @GET("persons")
    Call<List<Persons>> getAllPersons();

    //get passando parametro
    @GET("persons/{id}")
    Call<Persons> getPersons(@Path("id") Long id);

    @POST("persons")
    @Headers("Content-Type: application/json")
    Call<Persons> createPerson(@Body Persons persons);

    @PUT("persons/{id}")
    @Headers("Content-Type: application/json")
    Call<Persons> updatePerson(@Path("id") Long id, @Body Persons persons);

    @DELETE("persons/{id}")
    Call<Persons> deletePerson(@Path("id") Long id);


}
