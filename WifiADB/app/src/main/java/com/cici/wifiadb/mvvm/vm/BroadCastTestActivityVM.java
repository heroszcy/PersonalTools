package com.cici.wifiadb.mvvm.vm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.databinding.ObservableField;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

import com.cici.wifiadb.R;
import com.cici.wifiadb.mvvm.v.broadcast.NetWorkReceiver;

public class BroadCastTestActivityVM extends ViewModel {

    /**
     * Network receiver
     */
    private NetWorkReceiver netWorkReceiver;

    public BroadCastTestActivityVM(Context context) {
        super(context);
        wifiState.set(context.getResources().getString(R.string.wifi_state,"unknown state"));
        ethernetState.set(context.getResources().getString(R.string.ethernet_state,"unknown state"));
    }

    public final ObservableField<String> wifiState = new ObservableField<>();
    public final ObservableField<String> ethernetState = new ObservableField<>();

    private void regNetWorkReceiver(Context context){
        netWorkReceiver = new NetWorkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        context.registerReceiver(netWorkReceiver,intentFilter);
    }

    private void unRegNetWorkReceiver(Context context){
        if(netWorkReceiver != null){
            context.unregisterReceiver(netWorkReceiver);
            netWorkReceiver = null;
        }
    }

    public void regReceiver(Context context){
        regNetWorkReceiver(context);
    }

    public void unRegReceiver(Context context){
        unRegNetWorkReceiver(context);
    }
}
