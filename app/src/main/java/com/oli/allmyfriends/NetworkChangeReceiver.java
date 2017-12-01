package com.oli.allmyfriends;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by oliver on 11/26/2017.
 */

class NetworkChangeReceiver extends BroadcastReceiver {
    private static final String LOG_TAG = "NetworkChangeReceiver";
    private boolean isConnected = false;
    AlertDialog.Builder builder;

    @Override
    public void onReceive(final Context context, Intent intent) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ARE YOU CONNECTED?");
        builder.setMessage(isNetworkAvaible(context));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((Main4Activity)context).tekstKonekcija.setText(isNetworkAvaible(context));


            }


        });
        builder.create().show();
    }

    private String isNetworkAvaible(Context context){
        ConnectivityManager connectivity = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity!=null){
            NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
            if (activeNetwork !=null){
                if (activeNetwork.getState()==NetworkInfo.State.CONNECTED){
                    if (!isConnected){
                        isConnected = true;
                    }
                    return "Now you are connected to internet";
                }
            }
        }
        isConnected=false ;
        return "You are not connected to the internet";
    }


}
