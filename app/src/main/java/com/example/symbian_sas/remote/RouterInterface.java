package com.example.symbian_sas.remote;

import com.example.symbian_sas.model.Cliente;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RouterInterface {

    @POST("/cliente")
    Call<Cliente> addCliente(@Body Cliente cliente);
}
