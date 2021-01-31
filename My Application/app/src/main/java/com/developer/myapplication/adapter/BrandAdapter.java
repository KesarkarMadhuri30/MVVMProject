package com.developer.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.myapplication.R;
import com.developer.myapplication.model.BrandInfoModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder> {
    Context context;
    ArrayList<BrandInfoModel> brandInfoList = new ArrayList<>();

    public BrandAdapter(Context context, ArrayList<BrandInfoModel> brandInfoModels) {
        this.context = context;
        this.brandInfoList = brandInfoModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rootitem = inflater.inflate(R.layout.recycler_row_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(rootitem);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return brandInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView brand_id,brand_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brand_id = itemView.findViewById(R.id.brand_id);
            brand_name = itemView.findViewById(R.id.brand_name);

        }

        public void onBind(int position) {
            brand_id.setText(""+brandInfoList.get(position).getId());
            brand_name.setText(""+brandInfoList.get(position).getBrand_name());

        }
    }
}
