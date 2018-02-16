package com.sagar.retb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;

import java.util.List;
import java.util.UUID;

public class WelcomeToShop extends AppCompatActivity {

    public static  boolean flag = false;
    private BeaconManager beaconManager;
    private Beacon beacon;
    String TAG = "LoveHate ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_to_shop);
        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.setBackgroundScanPeriod(10,20);
        beaconManager.setForegroundScanPeriod(500,2);

        //beaconManager.
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {


            @Override
            public void onEnteredRegion(Region region, List<Beacon> list) {
                Log.d(TAG, "Entered Called!!! " + region.getProximityUUID() + " Minor : " + list.get(0).getMinor());


            if(region.getMinor()==9332) {

                Toast.makeText(getApplicationContext(), "Welcome TO Laptop Section ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), DisplayLaptops.class);

                startActivity(intent);
            }


                else if(region.getMinor()==16915){

                    Toast.makeText(getApplicationContext(), "Welcome TO Mobile Section ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), DisplayMobiles.class);

                startActivity(intent);

            }
            }


            @Override
            public void onExitedRegion(Region region) {
                Intent intent = new Intent(getApplicationContext(), WelcomeToShop.class);
                //beaconManager.disconnect();
                startActivity(intent);

                Log.d(TAG,"Exited Called!!! "+ region.getProximityUUID() + " Minor : "+ region.getMinor());
                //  showNotification("SmartCall","You exited!");
            }
        });
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                try {

                    Log.d(TAG,"onServiceReady Connected!");
                    beaconManager.startMonitoring(new Region("region1", UUID.fromString("F94DBB23-2266-7822-3782-57BEAC0952AC"), 24000, 9332));
                    beaconManager.startMonitoring(new Region("region3", UUID.fromString("F94DBB23-2266-7822-3782-57BEAC0952AC"), 19650, 35820));
                    Log.d(TAG,"startMonitoring Connected!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void showLaptops(View view)
    {
        Intent intent = new Intent(this, DisplayLaptops.class);

        startActivity(intent);
    }
    public void showLaptopsDetails(View view)
    {
        Intent intent = new Intent(this, DisplayLaptops.class);

        startActivity(intent);
    }
}
