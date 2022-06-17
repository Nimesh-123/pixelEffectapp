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
import com.example.pixel_effect_app.modal.GlareData;

import java.util.List;

public class GlareAdapter extends RecyclerView.Adapter<GlareAdapter.Glareholder> {
    Activity activity;
    List<GlareData> glareData;
    public <position> GlareAdapter(MainActivity5 positionMainActivity5, List<GlareData> glareData) {

        activity = positionMainActivity5;
        this.glareData = glareData;
    }
    @NonNull
    @Override
    public Glareholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.glare_item, parent, false);

        return new Glareholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Glareholder holder, @SuppressLint("RecyclerView") int position) {
        holder.Glare.setImageResource(glareData.get(position).imges_Glare);
        holder.Glare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity5.front_img.setImageResource(glareData.get(position).imges_Glare);
            }
        });
    }
    @Override
    public int getItemCount() {
        return glareData.size();
    }
    public class Glareholder extends RecyclerView.ViewHolder {
        public ImageView image;
        ImageView Glare;
        LinearLayout item_Glare;

        public Glareholder(@NonNull View itemView) {
            super(itemView);
            item_Glare = itemView.findViewById(R.id.item_Glare);
            Glare = itemView.findViewById(R.id.Glare);
            image = itemView.findViewById(R.id.image);
        }
    }
}
