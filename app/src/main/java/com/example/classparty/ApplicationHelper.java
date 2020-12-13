package com.example.classparty;

import android.content.Context;
import android.util.Log;


public class ApplicationHelper {
    private static final Object _lock = new Object();
    private static String TAG = "debesh";
    private static ApplicationHelper _instance;
    private User user;


    public synchronized static ApplicationHelper getInstance() {
        if (_instance == null) {
            _instance = new ApplicationHelper();
            Log.d(TAG, "instance of ActivityHelper created.");
        }
        return _instance;
    }

    public User getUser(Context context) {
        if (_instance.user == null) {
            _instance.user = PreferenceUtil.getUser(context);
        }
        return _instance.user;
    }


    public void setUser(Context context, User user) {
        PreferenceUtil.setUser(context, user);
        synchronized (_lock) {
            _instance.user = user;
        }
    }


    public Boolean isLogin(Context context) {
        return PreferenceUtil.getLogin(context);
    }

    public void setLogin(Context context, Boolean login) {
        PreferenceUtil.setLogin(context, login);
    }

}
