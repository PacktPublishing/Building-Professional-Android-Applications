package com.packt.madev.tiles;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.TileService;

import com.packt.madev.portfolio.addnew.AddNewStockActivity;

@SuppressLint("Override")
@TargetApi(Build.VERSION_CODES.N)
public class StartStockAddTileService extends TileService {
    @Override
    public void onClick() {
        boolean isCurrentlyLocked = this.isLocked();

        if (!isCurrentlyLocked) {
            Intent intent = new Intent(getApplicationContext(), AddNewStockActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivityAndCollapse(intent);
        }
    }


}