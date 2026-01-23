package edu.uic.cs478.sp2025.informationapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class RestaurantsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Broadcast: Showing Restaurants", Toast.LENGTH_SHORT).show();
        Log.d("RestaurantsReceiver", "Got broadcast to show restaurants!");

        Intent launch = new Intent(context, RestaurantsActivity.class);
        launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(launch);
    }
}
