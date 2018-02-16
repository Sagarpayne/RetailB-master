package com.sagar.retb;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;
import com.estimote.sdk.connection.settings.Eddystone;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    public static  boolean flag = false;
    private BeaconManager beaconManager;
    private Beacon beacon;
    String TAG = "Debug ";
    TextView tc ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // beacon = new Beacon;

        TextView tc = (TextView) findViewById(R.id.list);

        tc.setText("Welcome to My Store\n" +"Use this app to TOUR around the store !!\nAlso Find hidden Reward points");
        Log.d(TAG, "Discovered main: ");

        beaconManager = new BeaconManager(getApplicationContext());

beaconManager.setBackgroundScanPeriod(500,2);
        beaconManager.setForegroundScanPeriod(500,2);
        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List<Beacon> list) {
                Log.d(TAG, "Entered Called!!! " + region.getProximityUUID() + " Minor : " + list.get(0).getMinor());

                if (region.getMinor() == 29185) {
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("RetB", Context.MODE_PRIVATE);
                    Log.d(TAG, "sharedPreferences mainAcrkckk: ");
                    String user = "";
                    try { Log.d(TAG, "try mainAcrkckk: ");
                        user = sharedPreferences.getString("userforRetB", "Guest");
                    } catch (Exception e) {
                        Log.d(TAG, "Catch mainAcrkckk: ");
                    }

                    if (user.equals("Guest")) {


                        Log.d(TAG, "user.length mainAcrkckk: ");
                        Intent intent = new Intent(getApplicationContext(), RegisterOrLogin.class);
                        Log.d(TAG, "intent mainAcrkckk: ");
                        startActivity(intent);
                    } else {
                        flag =true;

                        Toast.makeText(getApplicationContext(), "Welcome " + user, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), WelcomeToShop.class);
                        //beaconManager.disconnect();
                        startActivity(intent);

                    }
                }

            }
            @Override
            public void onExitedRegion(Region region) {
                // could add an "exit" notification too if you want (-:
                Log.d(TAG,"Exited Called!!! "+ region.getProximityUUID() + " Minor : "+ region.getMinor());
              //  showNotification("SmartCall","You exited!");
            }
        });
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                try {
                    //beaconManager.startMonitoring(new Region("region1", UUID.fromString("F94DBB23-2266-7822-3782-57BEAC0952AC"), 8998, 16915));
                    beaconManager.startMonitoring(new Region("region2", UUID.fromString("B9407F30-F5F8-466E-AFF9-25556B57FE6D"), 31994, 29185));
                    Log.d(TAG,"BeaconManger Connected!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);
    }



}
