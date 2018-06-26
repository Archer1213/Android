package com.nus.integration.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by XRVision Acer on 25/6/2018.
 */

public class ServiceDemo extends Service{

    public ServiceDemo(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    private void methodInMyservice(){
        Toast.makeText(getApplicationContext(),"This is my service",Toast.LENGTH_SHORT).show();
    }

    private class MyBinder extends Binder implements IMyBinder{

        @Override
        public void invokeMethodInMyservice() {
            methodInMyservice();
        }
    }
}
