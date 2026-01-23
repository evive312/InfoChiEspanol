package edu.uic.cs478.sp2025.informationapp;

public class Restaurant {
    private final String name;
    private final String url;

    public Restaurant(String name, String url){this.name = name;this.url = url;}

    public String getName(){return name;}
    public String getUrl(){return url;}
}
