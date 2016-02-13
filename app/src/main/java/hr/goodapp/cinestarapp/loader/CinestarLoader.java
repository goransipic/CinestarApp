package hr.goodapp.cinestarapp.loader;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by User on 10.2.2016..
 */
public class CinestarLoader extends AsyncTaskLoader<String> {

    public static final String CINESTAR_LOADER_ACTION = "hr.goodapp.loader";
    LocalBroadcastManager localBroadcastManager;
    Broadcast broadcast = new Broadcast();

    String data;

    public CinestarLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {

        if (data != null) {
            deliverResult(data);

        } else {
            forceLoad();
        }

        if (localBroadcastManager == null) {

            localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
            IntentFilter intentFilter = new IntentFilter(CINESTAR_LOADER_ACTION);
            localBroadcastManager.registerReceiver(broadcast, intentFilter);
        }


    }

    @Override
    public String loadInBackground() {



        return "Hello Word !!!!";
    }

    @Override
    public void deliverResult(String data) {

        this.data = data;

        super.deliverResult(data);


    }

    @Override
    protected void onReset() {

        localBroadcastManager.unregisterReceiver(broadcast);

    }

    private class Broadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            forceLoad();
        }
    }

}
