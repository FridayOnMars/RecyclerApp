package com.example.recycle;

import android.graphics.drawable.Drawable;

class GetApps {
    private String nameApp, namePackage, version;
    private int versionCode;
    private Drawable image;

    GetApps(String nameApp, String namePackage, String version, int versionCode, Drawable image) {
        this.nameApp = nameApp;
        this.namePackage = namePackage;
        this.version = version;
        this.versionCode = versionCode;
        this.image = image;
    }

    String getNameApp() {
        return nameApp;
    }

    String getNamePackage() {
        return namePackage;
    }

    String getVersion() {
        return version;
    }

    int getVersionCode() {
        return versionCode;
    }

    Drawable getImage() {
        return image;
    }
}
