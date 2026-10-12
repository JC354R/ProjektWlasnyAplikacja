package com.example.bookproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        List<Book> bookList;

        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/JC354R/ProjektWlasnyAPI/main/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
}