package com.example.notificationapp;

import android.content.Intent;
import android.service.quicksettings.TileService;

public class NewTileService extends TileService {


    @Override
    public void onTileAdded() {
        super.onTileAdded();
    }

    // Called when your app can update your tile.
    @Override
    public void onStartListening() {
        super.onStartListening();
    }


    @Override
    public  void  onClick(){

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Start the activity
        startActivityAndCollapse(intent);

    }


}
