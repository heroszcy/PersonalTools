package com.cici.wifiadb;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.cici.wifiadb.mvvm.v.activity.WifiAdbActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by zhaochongyou on 2018/4/8.
 */
@RunWith(AndroidJUnit4.class)
public class WifiAdbActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<WifiAdbActivity> mActivityRule = new ActivityTestRule(WifiAdbActivity.class);

    @Test
    public void openAdb(){
        onView(withId(R.id.btn_open_adb))
                .perform(click());
    }
}
