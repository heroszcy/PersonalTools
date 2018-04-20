package com.cici.wifiadb.mvvm.v.activity;

import android.os.Bundle;

import com.cici.wifiadb.R;
import com.cici.wifiadb.databinding.ActivityBroadcastBinding;
import com.cici.wifiadb.mvvm.v.base.BaseActivity;
import com.cici.wifiadb.mvvm.vm.BroadCastTestActivityVM;

public class BroadCastTestActivity extends BaseActivity<ActivityBroadcastBinding,BroadCastTestActivityVM> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.unRegReceiver(getApplicationContext());
    }

    private void init() {
        //register broadcast receiver
        viewModel.regReceiver(getApplicationContext());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_broadcast;
    }

    @Override
    public BroadCastTestActivityVM getViewModel() {
        return new BroadCastTestActivityVM(this);
    }
}
