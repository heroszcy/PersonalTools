package com.cici.wifiadb.mvvm.v.activity;

import android.databinding.Observable;
import android.os.Bundle;
import android.util.Log;

import com.cici.wifiadb.R;
import com.cici.wifiadb.databinding.MainActivityBinding;
import com.cici.wifiadb.mvvm.v.base.BaseActivity;
import com.cici.wifiadb.mvvm.vm.MainActivityVM;

/**
 * @author cici
 */
public class WifiAdbActivity extends BaseActivity<MainActivityBinding,MainActivityVM> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.firstName.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Log.d(TAG,"firstName changed i = " + i);
            }
        });
        viewModel.lastName.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Log.d(TAG,"lastName changed i = " + i);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_activity;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

}
