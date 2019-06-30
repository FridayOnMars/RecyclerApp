package com.example.recycle;

import android.app.Activity;
import android.app.Dialog;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements Adapter.FragmentCallToActivity {

    private List<GetApps> apps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter(this, apps);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }

    private void setData(){
        final PackageManager pm = getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo packageInfo : packages) {
            try {
                PackageInfo info = pm.getPackageInfo(packageInfo.packageName, 0);
                apps.add(new GetApps(packageInfo.loadLabel(pm).toString(), info.packageName, info.versionName, info.versionCode, packageInfo.loadIcon(pm)));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void getInfoForDialog(String nameApp, String namePackage, Drawable icon, String version, int versionCode) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog_window);
        TextView tvNameAppView = dialog.findViewById(R.id.tvDialogNameApp);
        TextView tvNamePackageView = dialog.findViewById(R.id.tvDialogNamePackage);
        ImageView ivIconView = dialog.findViewById(R.id.ivDialogIcon);
        TextView tvVersionCodeView = dialog.findViewById(R.id.tvDialogVersionCode);
        TextView tvVersionView = dialog.findViewById(R.id.tvDialogVersion);
        Button btClose = dialog.findViewById(R.id.btClose);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tvNameAppView.setText(nameApp);
        tvNamePackageView.setText(namePackage);
        ivIconView.setImageDrawable(icon);
        tvVersionView.setText(String.format(getString(R.string.format_dialogVersion), version));
        tvVersionCodeView.setText(String.format("%s", versionCode));
        dialog.show();
    }
}