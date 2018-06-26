package com.nus.integration.Activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.nus.integration.R;
import com.nus.integration.Service.IMyBinder;
import com.nus.integration.Service.ServiceDemo;

/**
 * Created by XRVision Acer on 25/6/2018.
 */

public class MyServiceActivity extends AppCompatActivity{

    private MyConnection myConnection;
    private Intent intent;
    private IMyBinder myBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(myConnection);
    }

    public void start(View view){
        intent=new Intent(this, ServiceDemo.class);
        myConnection=new MyConnection();
        bindService(intent,myConnection,BIND_AUTO_CREATE);
    }

    public void invoke(View view){
        myBinder.invokeMethodInMyservice();
    }

    private class MyConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder= (IMyBinder) service;
            Log.i("zwh","service connect");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("zwh","service disconnect");
        }
    }
}
