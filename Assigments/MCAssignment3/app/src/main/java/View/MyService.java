package View;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import Controller.LiveDataProvider;
import Model.ResponseBO;

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        //ResponseBO responseBO= new ResponseBO();
        //LiveDataProvider liveDataProvider = new LiveDataProvider();
        //ResponseBO responseBO = liveDataProvider.getServerData();
        //broadcastIntent(responseBO);

        Thread thread= new Thread(new MyThread());
        thread.start();
        return START_STICKY;
    }

    /**
     * A client is binding to the service with bindService()
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void broadcastIntent(ResponseBO responseBO) {
        Intent intent = new Intent();
        intent.putExtra("ListOfContacts", responseBO.getMovieArrayList());
        intent.setAction("pk.edu.pucit.mcassignment3.CUSTOM_INTENT");
        BroadcastReceiver myReceiver = new MyReceiver();
        IntentFilter myFilter = new IntentFilter();
        myFilter.addAction("pk.edu.pucit.mcassignment3.CUSTOM_INTENT");
        registerReceiver(myReceiver, myFilter);
        sendBroadcast(intent);
    }

    final class MyThread implements Runnable {

        @Override
        public void run() {
            LiveDataProvider liveDataProvider = new LiveDataProvider();
            ResponseBO responseBO = liveDataProvider.getServerData();
            broadcastIntent(responseBO);
            stopSelf();
        }
    }

}
