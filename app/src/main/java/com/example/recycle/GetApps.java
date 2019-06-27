package com.example.recycle;

import android.graphics.drawable.Drawable;

class GetApps {
    private String nameApp, namePackage, version, versionCode;
    private Drawable image;

    GetApps(String nameApp, String namePackage, String version, String versionCode, Drawable image) {
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

    String getVersionCode() {
        return versionCode;
    }

    Drawable getImage() {
        return image;
    }
}
