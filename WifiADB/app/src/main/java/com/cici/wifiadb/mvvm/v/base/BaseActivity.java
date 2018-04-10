package com.cici.wifiadb.mvvm.v.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cici.wifiadb.BR;
import com.cici.wifiadb.mvvm.vm.ViewModel;

/**
 *
 * @author zhaochongyou
 * @date 2018/4/9
 */

public abstract class BaseActivity<VB extends ViewDataBinding,VM extends ViewModel> extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();
    protected VB viewDataBinding;
    protected VM viewModel;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = getViewModel();
        viewDataBinding.setVariable(BR.viewModel,viewModel);
    }

    /**
     * root layout id
     * @return
     */
    public abstract int getLayoutId();

    /**
     * get View Model
     * @return
     */
    public abstract VM getViewModel();

}
