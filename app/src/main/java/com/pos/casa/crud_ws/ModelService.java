package com.pos.casa.crud_ws;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ModelService {

    //get all
    @GET("api/v1.0/persons")
    Call<Model> getAllPersons();

    //get passando parametro
    //@GET("api/v1.0/persons/{id}")
    //Call<Model> getAllPersons(@Path("id") String p1, String p2);

    /*
    @POST("api/v1.0/{id}/json")
    Call<Model> createPerson(@Path("id") Model model);

    @PUT("api/v1.0/{id}/json")
    Call<Model> updatePerson(@Path("id") Model model);

    @DELETE("api/v1.0/{id}/json")
    Call<Model> deletePerson(@Path("id") Model model);
    */

}
