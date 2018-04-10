package com.cici.wifiadb.mvvm.vm;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.cici.wifiadb.R;
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
            default:
                break;
        }
        super.onClick(v);
    }
}
