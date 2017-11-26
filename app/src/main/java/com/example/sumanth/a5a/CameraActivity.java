package com.example.sumanth.a5a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        broadcastReceiver = new Camerareceiver();
    }
    @Override
    public void onStart(){
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_CAMERA_BUTTON));
        super.onStart();
    }
    @Override
    public void onStop()
    {
        unregisterReceiver(broadcastReceiver);
        super.onStop();
    }
    public class Camerareceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent)
        {
            if(intent.getAction().equals(Intent.ACTION_CAMERA_BUTTON))
            Toast.makeText(CameraActivity.this,"New picture clicked",Toast.LENGTH_LONG).show();
        }
    }
}
