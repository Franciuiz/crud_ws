package com.pos.casa.crud_ws;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()

                //Nao estabelece conexão com localhost (127.0.0.1), trocar "192.168.1.7" pelo ip local da maquina
                .baseUrl("http://192.168.1.5:8080/api/v1.0/")

                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public ModelService getModelService() {
        return this.retrofit.create(ModelService.class);
    }

}
