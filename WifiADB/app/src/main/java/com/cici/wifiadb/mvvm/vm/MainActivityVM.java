package com.cici.wifiadb.mvvm.vm;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.cici.wifiadb.R;
import com.cici.wifiadb.mvvm.m.User;
import com.cici.wifiadb.mvvm.utils.AdbCommand;

import java.util.Observable;

/**
 * @author zhaochongyou
 * @date 2018/4/9
 */

public class MainActivityVM extends ViewModel {
    //model
    /**
     * user 用户信息
     */
    private User user;

    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();

    public MainActivityVM(Context context) {
        super(context);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_open_adb:
                firstName.set("CiCi");
                lastName.set("ZHAO");
                AdbCommand.openADB();
                break;
            case R.id.btn_close_adb:
                AdbCommand.closeADB();
                break;
            default:
                break;
        }
        super.onClick(v);
    }
}
