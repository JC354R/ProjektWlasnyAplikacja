package com.example.bookproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ImageView bookCoverView;
    TextView bookTitleTxt, genreTxt, ageCategoryTxt, yearOfProductionTxt;
    Button buttonBack, buttonNext;
    int bookNumber;
    List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bookCoverView = findViewById(R.id.bookCoverView);
        bookTitleTxt = findViewById(R.id.bookTitleTxt);
        genreTxt = findViewById(R.id.genreTxt);
        ageCategoryTxt = findViewById(R.id.ageCategoryTxt);
        yearOfProductionTxt = findViewById(R.id.yearOfProductionTxt);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNext = findViewById(R.id.buttonNext);

        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/JC354R/ProjektWlasnyAPI/main/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<List<Book>> call = jsonPlaceHolder.getBook();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                bookList= response.body();
                //showBook(o);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });

        //Obsluga rpzyciskow nastepny / poprzedni
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookNumber++;
                if (bookNumber <= bookList.size()) {
                    showBook(bookNumber);
                } else {
                    Toast.makeText(MainActivity.this, "We dont have more books to show you :)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookNumber--;
                if (bookNumber >= 0) {
                    showBook(bookNumber);
                } else {
                    Toast.makeText(MainActivity.this, "We dont have less books to show you :)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showBook(int bookNumber){
        //"tytul": "tian guan shi fu",
        //      "autor": "mo xiang tong xiu",
        //      "gatunek": "romans",
        //      "kategoriaWiekowa": "16",
        //      "rokWydania" : "1897"

        //bookCoverView.setImageResource(...);
        bookTitleTxt.setText(bookList.get(bookNumber).getTytul());
        genreTxt.setText(bookList.get(bookNumber).getGatunek());
        ageCategoryTxt.setText(bookList.get(bookNumber).getKategoriaWiekowa());
        yearOfProductionTxt.setText(bookList.get(bookNumber).getRokWydania());
    }



}