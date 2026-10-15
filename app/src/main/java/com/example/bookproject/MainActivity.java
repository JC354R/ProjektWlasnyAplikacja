package com.example.bookproject;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final List<Book>[] bookList = new List[1];
        ImageView BookCoverView;
        TextView BookTitleTxt, genreTxt, ageCategoryTxt, yearOfProductionTxt;
        Button buttonBack, buttonNext;

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
                bookList[0] = response.body();
                //showBook(o);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

    private void showBook(int bookNumber){
        //wypisyanie wszyteki w liscie ig?
        //"tytul": "tian guan shi fu",
        //      "autor": "mo xiang tong xiu",
        //      "gatunek": "romans",
        //      "kategoriaWiekowa": "16",
        //      "rokWydania" : "1897"

    }
}