package com.example.recycle;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    private FragmentCallToActivity connect;

    public interface FragmentCallToActivity{
        void getInfoForDialog(String nameApp, String namePackage, Drawable icon, String version, int versionCode);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        if(context instanceof FragmentCallToActivity){
            connect = (FragmentCallToActivity) context;
        }
    }

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
                connect.getInfoForDialog(getApps.getNameApp(),getApps.getNamePackage(),getApps.getImage(), getApps.getVersion(), getApps.getVersionCode());
            }
        });
        holder.tvNameAppView.setText(getApps.getNameApp());
        holder.tvNamePackageView.setText(getApps.getNamePackage());
        holder.ivIconView.setImageDrawable(getApps.getImage());
    }
    @Override
    public int getItemCount() {
        return apps.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivIconView;
        TextView tvNameAppView, tvNamePackageView;
        ViewHolder(View view){
            super(view);
            ivIconView = view.findViewById(R.id.ivIcon);
            tvNameAppView = view.findViewById(R.id.tvNameApp);
            tvNamePackageView = view.findViewById(R.id.tvNamePackage);
        }
    }
}
