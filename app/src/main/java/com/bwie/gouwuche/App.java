package com.bwie.gouwuche;

import android.app.Application;

import org.xutils.x;

/**
 * 类的描述：
 * 时间：  2017/8/16.9:40
 * 姓名：chenlong
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
