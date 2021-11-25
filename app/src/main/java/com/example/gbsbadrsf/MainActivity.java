package com.example.gbsbadrsf;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.gbsbadrsf.databinding.ActivityMainBinding;
import com.honeywell.aidc.AidcManager;
import com.honeywell.aidc.BarcodeReader;
import com.honeywell.aidc.ScannerUnavailableException;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    private static BarcodeReader barcodeReader;
    private AidcManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        AidcManager.create(this, aidcManager -> {
            manager = aidcManager;
            barcodeReader = manager.createBarcodeReader();
            try {
                Log.d(TAG, "=====deviceID "+barcodeReader.getInfo().getScannerId());
            } catch (ScannerUnavailableException e) {
                e.printStackTrace();
            }
        });

    }
    static BarcodeReader getBarcodeObject() {
        return barcodeReader;
    }
}