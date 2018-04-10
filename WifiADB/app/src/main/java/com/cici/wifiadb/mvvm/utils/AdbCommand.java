package com.cici.wifiadb.mvvm.utils;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by zhaochongyou on 2018/4/4.
 * @author cici
 */

public class AdbCommand {
    public static void execute(String command){
        Runtime runtime = Runtime.getRuntime();
        try {
            Process exec = runtime.exec("su");
            exec.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openADB(){
        try {
            Runtime.getRuntime().exec(new String[]{"/system/bin/su", "-c", "setprop service.adb.tcp.port 5555"});
            Runtime.getRuntime().exec(new String[]{"/system/bin/su", "-c", "start adbd"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeADB() {
        try {
            Runtime.getRuntime().exec(new String[]{"/system/bin/su", "-c", "stop adbd"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
