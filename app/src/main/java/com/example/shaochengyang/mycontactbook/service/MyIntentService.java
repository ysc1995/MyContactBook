package com.example.shaochengyang.mycontactbook.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent i) {
        String phone = i.getStringExtra("Phone");
        Intent intent = new Intent("CUSTOM_ACTION");
        intent.putExtra("Phone", phone);
        Log.d(MyIntentService.class.getSimpleName(), "sending broadcast"+phone);


        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
