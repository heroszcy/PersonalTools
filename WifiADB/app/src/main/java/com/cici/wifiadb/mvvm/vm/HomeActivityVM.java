package com.cici.wifiadb.mvvm.vm;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.cici.wifiadb.R;
import com.cici.wifiadb.mvvm.v.activity.BroadCastTestActivity;
import com.cici.wifiadb.mvvm.v.activity.WifiAdbActivity;

public class HomeActivityVM extends ViewModel {
    public HomeActivityVM(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_wifi_adb:
                //enter WifiAdbActivity
                Intent intent = new Intent();
                intent.setClass(context, WifiAdbActivity.class);
                context.startActivity(intent);
                break;
            case R.id.btn_broadcast_test:
                // enter BroadCastTestActivity
                Intent intent1 = new Intent();
                intent1.setClass(context, BroadCastTestActivity.class);
                context.startActivity(intent1);
                break;
            default:
                break;
        }
        super.onClick(v);
    }
}
