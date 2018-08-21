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
    //@GET("api/v1.0/{model}/json")
    //Call<Model> getAllPersons(@Path("model") String model);

    //get passando parametro
    @GET("api/v1.0/{model}/json")
    Call<Model> getAllPersons(@Path("model") String model);

    @POST("api/v1.0/{model}/json")
    Call<Model> createPerson(@Path("model") Model model);

    @PUT("api/v1.0/{model}/json")
    Call<Model> updatePerson(@Path("model") Model model);

    @DELETE("api/v1.0/{model}/json")
    Call<Model> deletePerson(@Path("model") Model model);


}
