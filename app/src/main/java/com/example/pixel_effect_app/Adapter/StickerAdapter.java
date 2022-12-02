package com.example.pixel_effect_app.Adapter;

import android.app.Activity;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixel_effect_app.Activity.ImageEdit_Activity;
import com.example.pixel_effect_app.R;

import java.util.List;

import Utils.StickerPropertyModel;

public class StickerAdapter extends RecyclerView.Adapter <StickerAdapter.StickerHolder> {

    Activity activity;
    List<StickerPropertyModel>stickerPropertyModels;

    public StickerAdapter(ImageEdit_Activity imageEdit_activity, int[] s1) {

        activity  = imageEdit_activity;
        this.stickerPropertyModels = stickerPropertyModels;
    }

    @NonNull
    @Override
    public StickerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.stickeritem, parent, false);
        return new StickerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StickerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class StickerHolder extends RecyclerView.ViewHolder {
        public StickerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
