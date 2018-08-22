package com.pos.casa.crud_ws;

import android.app.Person;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ModelService {

    //get all
    @GET("persons")
    Call<Persons> getAllPersons();

    //get passando parametro
    @GET("persons/{id}")
    Call<Persons> getPersons(@Path("id") String id);

    @POST("persons")
    Call<Persons> createPerson(@Path("id") Persons persons);

    @PUT("persons/{id}")
    Call<Persons> updatePerson(@Path("id") String id, Persons persons);

    @DELETE("persons/{id}")
    Call<Persons> deletePerson(@Path("id") String id);


}
