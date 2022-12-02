package com.example.pixel_effect_app.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixel_effect_app.Activity.ImageEdit_Activity;
import com.example.pixel_effect_app.Filter;
import com.example.pixel_effect_app.R;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FontHolder> {

    Activity activity;

    public <position> FilterAdapter(ImageEdit_Activity positionMainActivity5) {
        activity = positionMainActivity5;
    }


    @NonNull
    @Override
    public FontHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.filteritem, parent, false);
        return new FontHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FontHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.Filter.setImageResource(R.drawable.filter_image);

        

                switch (position) {
                    case 0:
                        Filter.applyEffectNone(holder.Filter);
                        break;
                    case 1:
                        Filter.applyEffect1(holder.Filter);
                        break;
                    case 2:
                        Filter.applyEffect2(holder.Filter);
                        break;
                    case 3:
                        Filter.applyEffect3(holder.Filter);
                        break;
                    case 4:
                        Filter.applyEffect4(holder.Filter);
                        break;
                    case 5:
                        Filter.applyEffect5(holder.Filter);
                        break;
                    case 6:
                        Filter.applyEffect6(holder.Filter);
                        break;
                    case 7:
                        Filter.applyEffect7(holder.Filter);
                        break;
                    case 8:
                        Filter.applyEffect8(holder.Filter);
                        break;
                    case 9:
                        Filter.applyEffect9(holder.Filter);
                        break;
                    case 10:
                        Filter.applyEffect10(holder.Filter);
                        break;
                    case 11:
                        Filter.applyEffect11(holder.Filter);
                        break;
                    case 12:
                        Filter.applyEffect12(holder.Filter);
                        break;
                    case 13:
                        Filter.applyEffect13(holder.Filter);
                        break;
                    case 14:
                        Filter.applyEffect14(holder.Filter);
                        break;
                    case 15:
                        Filter.applyEffect15(holder.Filter);
                        break;
                    case 16:
                        Filter.applyEffect16(holder.Filter);
                        break;
                    case 17:
                        Filter.applyEffect17(holder.Filter);
                        break;
                    case 18:
                        Filter.applyEffect18(holder.Filter);
                        break;
                    case 19:
                        Filter.applyEffect19(holder.Filter);
                        break;
                    case 20:
                        Filter.applyEffect20(holder.Filter);
                        break;
                    case 21:
                        Filter.applyEffect21(holder.Filter);
                        break;
                    case 22:
                        Filter.applyEffect22(holder.Filter);
                        break;


                }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageEdit_Activity.setFilter(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 23;
    }

    public class FontHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        ImageView Filter;
//        LinearLayout item_Filter;

        public FontHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            Filter = itemView.findViewById(R.id.Filter);
//            item_Filter = itemView.findViewById(R.id.item_Filter);
        }
    }
}
