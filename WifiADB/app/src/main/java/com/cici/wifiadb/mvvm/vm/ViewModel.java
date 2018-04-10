package com.cici.wifiadb.mvvm.vm;

import android.content.Context;
import android.view.View;

/**
 *
 * @author zhaochongyou
 * @date 2018/4/9
 */

public abstract class ViewModel implements Presenter {
    protected Context context;
    public ViewModel(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
    }
}
