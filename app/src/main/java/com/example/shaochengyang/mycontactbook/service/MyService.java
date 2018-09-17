package com.example.shaochengyang.mycontactbook.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.example.shaochengyang.mycontactbook.R;

public class MyService extends Service {
    MediaPlayer mediaPlayer;



    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        //Toast.makeText(MyService.this,"oncreate",Toast.LENGTH_LONG).show();
        mediaPlayer=MediaPlayer.create(MyService.this, R.raw.w3);

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Toast.makeText(MyService.this,"onstart",Toast.LENGTH_LONG).show();
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //Toast.makeText(MyService.this,"ondestroy",Toast.LENGTH_LONG).show();
        mediaPlayer.stop();
        super.onDestroy();
    }


}
