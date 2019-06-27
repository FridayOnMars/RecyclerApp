package com.example.recycle;

import android.content.Context;
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

    Adapter(Context context, List<GetApps> apps){
        this.apps = apps;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.list_item_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position){
        GetApps getApps = apps.get(position);
        holder.nameAppView.setText(getApps.getNameApp());
        holder.namePackageView.setText(getApps.getNamePackage());
        holder.versionView.setText(getApps.getVersion());
        holder.versionCodeView.setText(getApps.getVersionCode());
        holder.iconView.setImageDrawable(getApps.getImage());
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView iconView;
        final TextView nameAppView, namePackageView, versionView, versionCodeView;
        ViewHolder(View view){
            super(view);
            iconView = view.findViewById(R.id.ivIcon);
            nameAppView = view.findViewById(R.id.tvNameApp);
            namePackageView = view.findViewById(R.id.tvNamePackage);
            versionView = view.findViewById(R.id.tvVersion);
            versionCodeView = view.findViewById(R.id.tvVersionCode);
        }
    }
}
