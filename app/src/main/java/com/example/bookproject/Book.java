package com.example.bookproject;

import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("tytul")
    private String tytul;

    @SerializedName("autor")
    private String autor;

    @SerializedName("gatunek")
    private String gatunek;
    @SerializedName("kategoriaWiekowa")
    private String kategoriaWiekowa;
    @SerializedName("rokWydania")
    private String rokWydania;


    //constructor
    public Book(String tytul, String autor, String gatunek, String kategoriaWiekowa, String rokWydania) {
        this.tytul = tytul;
        this.autor = autor;
        this.gatunek = gatunek;
        this.kategoriaWiekowa = kategoriaWiekowa;
        this.rokWydania = rokWydania;
    }

    //getter
    public String getTytul() {
        return tytul;
    }

    public String getAutor() {
        return autor;
    }

    public String getGatunek() {
        return gatunek;
    }

    public String getKategoriaWiekowa() {
        return kategoriaWiekowa;
    }

    public String getRokWydania() {
        return rokWydania;
    }

    //setter

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public void setKategoriaWiekowa(String kategoriaWiekowa) {
        this.kategoriaWiekowa = kategoriaWiekowa;
    }

    public void setRokWydania(String rokWydania) {
        this.rokWydania = rokWydania;
    }
}
