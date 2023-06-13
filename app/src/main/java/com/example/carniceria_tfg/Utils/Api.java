package com.example.carniceria_tfg.Utils;

public class Api {
    public static final String URL_Base = "http://192.168.1.21:8080/";

    public static ApiService getApiService() {
        return Cliente.getClient(URL_Base).create(ApiService.class);
    }
}
