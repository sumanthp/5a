package com.example.sumanth.a5a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {

    TextView battery_text;
    ProgressBar battery_level;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        battery_text = (TextView)findViewById(R.id.battery_text);
        battery_level = (ProgressBar)findViewById(R.id.battery_level);
        broadcastReceiver = new BatteryBroadcastReceiver();
    }

    @Override
    public void onStart(){
        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }

    @Override
    public void onStop(){
        unregisterReceiver(broadcastReceiver);
        super.onStop();
    }

    public class BatteryBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context,Intent intent)
        {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            battery_text.setText("Battery Level: "+level);
            battery_level.setProgress(level);
        }
    }
}
