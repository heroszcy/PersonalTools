package com.cici.wifiadb.mvvm.v.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cici.wifiadb.R;
import com.cici.wifiadb.databinding.ActivityHomeBinding;
import com.cici.wifiadb.mvvm.v.base.BaseActivity;
import com.cici.wifiadb.mvvm.vm.HomeActivityVM;
import com.cici.wifiadb.mvvm.vm.ViewModel;

/**
 * @author zhaochongyou
 */
public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeActivityVM> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeActivityVM getViewModel() {
        return new HomeActivityVM(this);
    }
}
