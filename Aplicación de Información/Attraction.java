package edu.uic.cs478.sp2025.informationapp;

//Attractions Activity and Fragment Classes

public class Attraction {
    private final String name;
    private final String url;

    public Attraction(String name, String url){this.name = name;this.url = url;}

    public String getName(){return name;}
    public String getUrl(){return url;}
}
