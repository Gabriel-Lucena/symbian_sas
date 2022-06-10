package com.example.symbian_sas.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cliente {


    @SerializedName("idCliente")
    @Expose
    private int idCliente;


    @SerializedName("nome")
    @Expose
    private String nome;


    @SerializedName("sobrenome")
    @Expose
    private String sobrenome;


    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("celular")
    @Expose
    private String celular;

    public Cliente() {

    }

    public Cliente(
            int idCliente,
            String nome,
            String sobrenome,
            String email,
            String celular
    ) {

        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.celular = celular;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
