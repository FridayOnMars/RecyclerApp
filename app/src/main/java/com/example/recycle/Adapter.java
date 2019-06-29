package com.example.recycle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<GetApps> apps;
//    private Activity activity;

    Adapter(Context context, List<GetApps> apps){
        this.apps = apps;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.list_item_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        final GetApps getApps = apps.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // final Dialog dialog = new Dialog(activity);
//                dialog.setContentView(R.layout.activity_main);
//                dialog.setCancelable(true);
              //  dialog.show();
                holder.namePackageView.setText("Я нажался!");
            }
        });
        holder.nameAppView.setText(getApps.getNameApp());
        holder.namePackageView.setText(getApps.getNamePackage());
//        holder.versionView.setText(getApps.getVersion());
//        holder.versionCodeView.setText(getApps.getVersionCode());
        holder.iconView.setImageDrawable(getApps.getImage());
    }
    @Override
    public int getItemCount() {
        return apps.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconView;
        TextView nameAppView, namePackageView;
        ViewHolder(View view){
            super(view);
            iconView = view.findViewById(R.id.ivIcon);
            nameAppView = view.findViewById(R.id.tvNameApp);
            namePackageView = view.findViewById(R.id.tvNamePackage);
//            versionView = view.findViewById(R.id.tvVersion);
//            versionCodeView = view.findViewById(R.id.tvVersionCode);
        }
    }
}
