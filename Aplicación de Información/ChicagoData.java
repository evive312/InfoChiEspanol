package edu.uic.cs478.sp2025.informationapp;

import java.util.Arrays;
import java.util.List;
public class ChicagoData {
    public static final List<Attraction> attractions = Arrays.asList(
            new Attraction("Lincoln Park Zoo", "https://www.lpzoo.org/"),
            new Attraction("Navy Pier", "https://navypier.org/"),
            new Attraction("Museum of Science and Industry", "https://www.msichicago.org/"),
            new Attraction("Art Institute of Chicago", "https://www.artic.edu/"),
            new Attraction("TILT! at 360 Chicago", "https://360chicago.com/tilt")
    );
    public static final List<Restaurant> restaurants = Arrays.asList(
            new Restaurant("Alinea", "https://www.alinearestaurant.com/"),
            new Restaurant("Girl & the Goat", "https://girlandthegoat.com/"),
            new Restaurant("Monteverde", "https://www.monteverdechicago.com/"),
            new Restaurant("Oriole", "https://www.oriolechicago.com/"),
            new Restaurant("Portillo's Hot Dogs", "https://www.portillos.com/")
    );
}
