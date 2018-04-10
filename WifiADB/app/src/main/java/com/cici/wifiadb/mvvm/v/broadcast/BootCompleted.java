package com.cici.wifiadb.mvvm.v.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.cici.wifiadb.mvvm.utils.AdbCommand;

/**
 * @author zhaochongyou
 * @date 2018/4/4
 */

public class BootCompleted extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Boot completed !!!!", Toast.LENGTH_LONG).show();
        AdbCommand.openADB();
    }
}
