package com.example.get_permissions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//==========================================================================================
        if (Build.VERSION.SDK_INT >= 25) {  //check for Android OS version

            // array of all permissions with protection level "dangerous"
            //
            String [] neededPermissions = {Manifest.permission.READ_CONTACTS, Manifest.permission.READ_CALENDAR,Manifest.permission.WRITE_CALENDAR,
                    Manifest.permission.RECORD_AUDIO};

            for (int i=0; i < neededPermissions.length;i++) {
                
                int permissionStatus = ContextCompat.checkSelfPermission(this, neededPermissions[i]); // foreach permission in array

                if (permissionStatus != PackageManager.PERMISSION_GRANTED) { //if permission isn't granted =>
                    String [] permission_str = {neededPermissions[i]}; // creating the array bc the format below requires an array
                    //=> ask for permission
                    ActivityCompat.requestPermissions(this, permission_str, 1);
                    continue;
                } else //if not granted
                {
                    continue;
                    //do nothing, already have the permission!
                }
            }
        }


    }
}
