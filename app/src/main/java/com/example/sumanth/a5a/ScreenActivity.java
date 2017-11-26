package com.example.sumanth.a5a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ScreenActivity extends AppCompatActivity {
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        broadcastReceiver = new ScreenBroadcastReceiver();
        this.registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_SCREEN_ON));
        this.registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }

    @Override
    public void onStart()
    {

        super.onStart();
    }

    @Override
    public  void onStop()
    {
        //unregisterReceiver(broadcastReceiver);
        super.onStop();
    }
    public class ScreenBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void  onReceive(Context context, Intent intent)
        {
            String action = intent.getAction();
            if(action.equals(Intent.ACTION_SCREEN_ON))
            {
                Log.i("Screen status: ","ON");
                Toast.makeText(ScreenActivity.this,"Screen is On",Toast.LENGTH_SHORT).show();
            }
            if(action.equals(Intent.ACTION_SCREEN_OFF))
            {
                Log.i("Screen status: ","OFF");
                Toast.makeText(ScreenActivity.this,"Screen is Off",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
