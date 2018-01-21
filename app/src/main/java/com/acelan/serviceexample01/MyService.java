package com.acelan.serviceexample01;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ace_lan on 2018/1/14.
 */

public class MyService extends Service {
    public static final String TAG = "MyService Class Log";

    public MyBinder myBinder = new MyBinder();

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG,"onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Log.d(TAG,"onStartCommand executed");
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind executed");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind executed");
        return super.onUnbind(intent);
    }

}
