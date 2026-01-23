package edu.uic.cs478.sp2025.chooserapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAttractions;
    private Button btnRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAttractions = findViewById(R.id.btnAttractions);
        btnRestaurants = findViewById(R.id.btnRestaurants);

        // button
        btnAttractions.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Showing Attractions...", Toast.LENGTH_SHORT).show();
            // Broadcast
            Intent intent = new Intent("edu.uic.cs478.sp2025.informationapp.ACTION_SHOW_ATTRACTIONS");
            intent.setPackage("edu.uic.cs478.sp2025.informationapp");
            sendBroadcast(intent);
        });

        // button
        btnRestaurants.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Showing Restaurants...", Toast.LENGTH_SHORT).show();
            // Broadcast
            Intent intent = new Intent("edu.uic.cs478.sp2025.informationapp.ACTION_SHOW_RESTAURANTS");
            intent.setPackage("edu.uic.cs478.sp2025.informationapp");
            sendBroadcast(intent);

        });
    }
}
