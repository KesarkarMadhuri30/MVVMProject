package com.developer.mvvmapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.mvvmapplication.model.BrandInfoModel;
import com.developer.mvvmapplication.model.BrandModel;
import com.developer.mvvmapplication.viewmodel.BrandViewModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecycler extends RecyclerView.Adapter <AdapterRecycler.ViewHolder>{
    Context context;
    ArrayList<BrandInfoModel> brandlist;

    public AdapterRecycler(Context applicationContext, ArrayList<BrandInfoModel> list) {
        this.context=applicationContext;
        this.brandlist = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View listitem = inflater.inflate(R.layout.recyclerview_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(listitem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.txtid.setText(brandlist.get(position).getName());
            holder.txt_name.setText(brandlist.get(position).getTeam());
    }

    @Override
    public int getItemCount() {
        return brandlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtid,txt_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtid = itemView.findViewById(R.id.brandid);
            txt_name=itemView.findViewById(R.id.brandname);
        }
    }
}
