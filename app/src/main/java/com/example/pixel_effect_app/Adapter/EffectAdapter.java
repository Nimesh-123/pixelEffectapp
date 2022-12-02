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

import com.example.pixel_effect_app.Activity.ImageEdit_Activity;
import com.example.pixel_effect_app.R;
import com.example.pixel_effect_app.modal.EffectData;

import java.util.List;

public class EffectAdapter extends RecyclerView.Adapter<EffectAdapter.EffectHolder> {
    Activity activity;
    List<EffectData> effectData;

    public EffectAdapter(ImageEdit_Activity positionMainActivity5, List<EffectData> effectData) {

        activity = positionMainActivity5;
        this.effectData = effectData;
    }

    @NonNull
    @Override
    public EffectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.effect_item, parent, false);
        return new EffectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EffectHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.Effect.setImageResource(effectData.get(position).images_Effect);
        holder.Effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageEdit_Activity.front_img.setImageResource(effectData.get(position).images_Effect);
            }
        });
    }

    @Override
    public int getItemCount() {
        return effectData.size();
    }

    public class EffectHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        LinearLayout item_Effect;
        ImageView Effect;

        public EffectHolder(@NonNull View itemView) {
            super(itemView);
            item_Effect = itemView.findViewById(R.id.item_Effect);
            Effect = itemView.findViewById(R.id.Effect);
            image = itemView.findViewById(R.id.image);
        }
    }
}
