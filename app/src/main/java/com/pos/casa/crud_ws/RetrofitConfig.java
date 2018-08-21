package com.pos.casa.crud_ws;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()

                //Trocar pela url local
                .baseUrl("http://localhost:8080/")

                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ModelService getModelService() {
        return this.retrofit.create(ModelService.class);
    }

}
