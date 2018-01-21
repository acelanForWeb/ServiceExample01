package com.acelan.serviceexample01;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity Class log";
    private Button start_service,stop_service,bind_service,unbind_service;
    public MyService myService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 取得介面元件
        start_service = (Button) findViewById(R.id.start_service);
        stop_service = (Button) findViewById(R.id.stop_service);
        bind_service = (Button) findViewById(R.id.bind_service);
        unbind_service = (Button) findViewById(R.id.unbind_service);

        //設定監聽器
        start_service.setOnClickListener(this);
        stop_service.setOnClickListener(this);
        bind_service.setOnClickListener(this);
        unbind_service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.start_service:{
                Log.d(TAG, "start_service Button is click ");
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            }
            case R.id.stop_service:{
                Log.d(TAG, "stop_service Button is click ");
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
                break;
            }
            case R.id.bind_service:{
                Log.d(TAG, "bind_service Button is click ");
                Intent intent = new Intent(this, MyService.class);
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                break;
            }
            case R.id.unbind_service:{
                Log.d(TAG, "unbind_service Button is click ");
                unbindService(connection);
                break;
            }
        }
    }

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService = ((MyService.MyBinder) service).getService();
            Log.d(TAG, "MainActivity onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService = null;
            Log.d(TAG, "MainActivity onServiceFailed");
        }
    };
}
