package edu.uic.cs478.sp2025.informationapp;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
public class AttractionsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context,"Broadcast: Showing Attractions",Toast.LENGTH_SHORT).show();

        Intent launch = new Intent(context, AttractionsActivity.class);
        launch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(launch);

    }
}
