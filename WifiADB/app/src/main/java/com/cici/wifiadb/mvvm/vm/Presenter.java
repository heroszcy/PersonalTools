package com.cici.wifiadb.mvvm.vm;

import android.view.View;

/**
 * @author zhaochongyou
 * @date 2018/4/8
 */

public interface Presenter extends View.OnClickListener {
    /**
     * view onClick event
     *
     * @param v
     */
    @Override
    public void onClick(View v);
}
