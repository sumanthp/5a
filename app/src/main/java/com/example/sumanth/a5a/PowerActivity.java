package com.example.sumanth.a5a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PowerActivity extends AppCompatActivity {

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        broadcastReceiver = new PowerReceiver();
    }
    @Override
    public void onStart(){
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
        super.onStart();
    }
    @Override
    public void onStop()
    {
        unregisterReceiver(broadcastReceiver);
        super.onStop();
    }
    public class PowerReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
                Toast.makeText(PowerActivity.this,"Power connected",Toast.LENGTH_SHORT).show();
            }
            if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
                Toast.makeText(PowerActivity.this,"Power Disconnected",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
