package com.example.test.Model;

/**
 * Created by emad on 2/5/19.
 */

public class App {
     String AppName;
    String packageName;

    public App( String appName, String packageName) {
         AppName = appName;
        this.packageName = packageName;
    }


    public String getAppName() {
        return AppName;
    }

    public void setAppName(String appName) {
        AppName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
