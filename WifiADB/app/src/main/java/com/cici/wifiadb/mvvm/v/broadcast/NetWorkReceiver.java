package com.cici.wifiadb.mvvm.v.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetWorkReceiver extends BroadcastReceiver {
    private static NetworkInfo currentNetWorkInfo;
    @Override
    public void onReceive(Context context, Intent intent) {
        if(null != intent){
            String action = intent.getAction();
            if(WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)){
                //wifi 打开 关闭 正在打开 正在关闭
                int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1);
                String message = " ";
                switch (wifiState){
                    case WifiManager.WIFI_STATE_DISABLED:
                        message = "wifi disabled";
                        break;
                    case WifiManager.WIFI_STATE_ENABLED:
                        message = "wifi enabled";
                        break;
                    case WifiManager.WIFI_STATE_ENABLING:
                        message = "wifi enabling";
                        break;
                    case WifiManager.WIFI_STATE_DISABLING:
                        message = "wifi disabling";
                        break;
                    case WifiManager.WIFI_STATE_UNKNOWN:
                        break;
                    default:
                        message = "unknown";
                        break;
                }
                Log.d("zcy",message);
//                Toast.makeText(context,"action = " + action
//                +message,Toast.LENGTH_LONG).show();

            }else if(WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(action)){
                //wifi 网络连接变化
                NetworkInfo networkInfo = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
//                if(networkInfo.)
                Log.d("zcy",networkInfo.toString());
                NetworkInfo.State state = networkInfo.getState();
                String typeName = networkInfo.getTypeName();
                String extraInfo = networkInfo.getExtraInfo();
                StringBuilder builder = new StringBuilder();
                builder.append("[ type = ").append(typeName).append(", extraInfo = ")
                        .append(extraInfo).append(", state = ").append(state);
//                Toast.makeText(context,"action = " + action
//                        + builder.toString(),Toast.LENGTH_LONG).show();
            }else if(ConnectivityManager.CONNECTIVITY_ACTION.equals(action)){
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(isSameNetWorkInfo(currentNetWorkInfo,networkInfo)){
                    Toast.makeText(context,"same network info ",Toast.LENGTH_LONG).show();
                    currentNetWorkInfo = networkInfo;
                    return;
                }
                if(null != networkInfo) {
                    NetworkInfo.State state = networkInfo.getState();
                    String typeName = networkInfo.getTypeName();
                    String extraInfo = networkInfo.getExtraInfo();
                    boolean available = networkInfo.isAvailable();
//                    boolean ping = ping();
                    StringBuilder builder = new StringBuilder();
                    builder.append("[ type = ").append(typeName).append(", extraInfo = ")
                            .append(extraInfo).append(", state = ").append(state)
                            .append(", available = ").append(available).append("]");
                    Log.d("zcy", builder.toString());
                    Toast.makeText(context,"action = " + action +"\n"
                            + builder.toString(),Toast.LENGTH_LONG).show();
                    ping(context);
                }else {
                    Log.d("zcy","network Info is null");
                    Toast.makeText(context,"network info is null",Toast.LENGTH_LONG).show();
                }
                currentNetWorkInfo= networkInfo;
            }
//            int type = intent.getIntExtra(ConnectivityManager.EXTRA_NETWORK_TYPE,-1);
//            boolean isFailover = intent.getBooleanExtra(ConnectivityManager.EXTRA_IS_FAILOVER, false);
//            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
//            String message = "action = " + action
//                                +"; network type = " + type
//                                +"; isFailover= " + isFailover
//                                +"; noConnectivity = " + noConnectivity
//                                ;
//            Toast.makeText(context,message,Toast.LENGTH_LONG).show();
        }
    }

    private boolean isSameNetWorkInfo(NetworkInfo oldNetworkInfo, NetworkInfo newNetworkInfo){
        if(newNetworkInfo == null && oldNetworkInfo != null){
            return false;
        }
        if(oldNetworkInfo == null && newNetworkInfo != null){
            return false;
        }
        if(newNetworkInfo == null && oldNetworkInfo == null){
            return true;
        }
        if(oldNetworkInfo.getType() == newNetworkInfo.getType()){
            //网络类型相同
            if(oldNetworkInfo.getState().ordinal() == newNetworkInfo.getState().ordinal()){//状态一样
                if(oldNetworkInfo.isConnected() == newNetworkInfo.isConnected() && oldNetworkInfo.isAvailable() == newNetworkInfo.isAvailable()){
                    if(oldNetworkInfo.getExtraInfo().equals(newNetworkInfo.getExtraInfo())){//extra info 一样
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void ping(final Context context){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = null;
                try {
                    String ip = "www.baidu.com";
                    Process p = Runtime.getRuntime().exec("ping -c 3 -w 100 " + ip);
                    //read result of ping
                    InputStream inputStream = p.getInputStream();
                    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuffer stringBuffer = new StringBuffer();
                    String content;
                    while ((content = in.readLine()) != null) {
                        stringBuffer.append(content);
                    }
                    Log.d("------ping-----", "result content : " + stringBuffer.toString());
                    // ping的状态
                    int status = p.waitFor();
                    if (status == 0) {
                        result = "success";
                    } else {
                        result = "failed";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    result = "IOException";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    result = "InterruptedException";
                } finally {
                    Log.d("----result---", "result = " + result);
                }
                final String temp = result;
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context,"ping result = " + temp,Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();
    }

}
