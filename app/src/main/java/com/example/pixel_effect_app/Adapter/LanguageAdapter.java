package com.example.pixel_effect_app.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixel_effect_app.Activity.MainActivity5;
import com.example.pixel_effect_app.R;
import com.example.pixel_effect_app.modal.LanguageData;

import java.util.List;
public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LangugaeHolder> {
    Activity activity;
    List<LanguageData> dataList;
    public LanguageAdapter(MainActivity5 mainActivity5, List<LanguageData> dataList) {

        activity = mainActivity5;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public LangugaeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item, parent, false);
        return new LangugaeHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LangugaeHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.logo.setImageResource(dataList.get(position).img);

        holder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity5.front_img.setImageResource(dataList.get(position).img);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    class LangugaeHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        LinearLayout bake;
        ImageView logo;
        public LangugaeHolder(@NonNull View itemView) {
            super(itemView);
            bake = itemView.findViewById(R.id.bake);
            logo = itemView.findViewById(R.id.logo);
            image = itemView.findViewById(R.id.image);
        }
    }
}


