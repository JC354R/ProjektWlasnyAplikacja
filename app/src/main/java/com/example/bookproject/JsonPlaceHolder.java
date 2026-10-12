package com.example.bookproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public class JsonPlaceHolder {
    @GET("db.json")
    public Call<List<Book>>
    getBook(); //metoda abstrakcyjna
}
