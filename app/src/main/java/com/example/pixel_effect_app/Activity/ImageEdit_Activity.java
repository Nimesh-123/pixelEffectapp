package com.example.pixel_effect_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pixel_effect_app.Adapter.EffectAdapter;
import com.example.pixel_effect_app.Adapter.FilterAdapter;
import com.example.pixel_effect_app.Adapter.GlareAdapter;
import com.example.pixel_effect_app.Adapter.LanguageAdapter;
import com.example.pixel_effect_app.Adapter.StickerAdapter;
import com.example.pixel_effect_app.Filter;
import com.example.pixel_effect_app.R;
import com.example.pixel_effect_app.modal.EffectData;
import com.example.pixel_effect_app.modal.GlareData;
import com.example.pixel_effect_app.modal.LanguageData;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.util.ArrayList;
import java.util.List;

import Utils.StickerPropertyModel;
import Utils.Ulits;

public class ImageEdit_Activity extends AppCompatActivity {
    ImageView back, chake, backe, im1, im2, im3, im4, im5;
    LinearLayout threed;
    LinearLayout Effect;
    LinearLayout Glare;
    LinearLayout Color;
    LinearLayout rotate;
    LinearLayout flip;
    LinearLayout Filter1;
    LinearLayout Sticker;
    LinearLayout text;
    Dialog dialog, dailog1;


    int check = 0, c2 = 0, c3 = 0, r1 = 0, f1 = 0, c4 = 0;

    public static Bitmap bitmap;
    public static ImageView image, front_img;

    private static final String TAG = "MainActivity5";
    List<LanguageData> dataList = new ArrayList<>();
    List<EffectData> effectData = new ArrayList<>();
    List<GlareData> GlareData = new ArrayList<>();

    RecyclerView language_list, Effect_data, Glare_Data, Color_Data, Filter_Data, Sticker_Data, Text_Data;


    public static void setFilter(int position) {

        switch (position) {
            case 0:
                Filter.applyEffectNone(image);
                break;
            case 1:
                Filter.applyEffect1(image);
                break;
            case 2:
                Filter.applyEffect2(image);
                break;
            case 3:
                Filter.applyEffect3(image);
                break;
            case 4:
                Filter.applyEffect4(image);
                break;
            case 5:
                Filter.applyEffect5(image);
                break;
            case 6:
                Filter.applyEffect6(image);
                break;
            case 7:
                Filter.applyEffect7(image);
                break;
            case 8:
                Filter.applyEffect8(image);
                break;
            case 9:
                Filter.applyEffect9(image);
                break;
            case 10:
                Filter.applyEffect10(image);
                break;
            case 11:
                Filter.applyEffect11(image);
                break;
            case 12:
                Filter.applyEffect12(image);
                break;
            case 13:
                Filter.applyEffect13(image);
                break;
            case 14:
                Filter.applyEffect14(image);
                break;
            case 15:
                Filter.applyEffect15(image);
                break;
            case 16:
                Filter.applyEffect16(image);
                break;
            case 17:
                Filter.applyEffect17(image);
                break;
            case 18:
                Filter.applyEffect18(image);
                break;
            case 19:
                Filter.applyEffect19(image);
                break;
            case 20:
                Filter.applyEffect20(image);
                break;
            case 21:
                Filter.applyEffect21(image);
                break;
            case 22:
                Filter.applyEffect22(image);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageedite_activity);

        binding();
        image.setImageBitmap(crop_Activity.bitmap);

        chake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chake.setImageBitmap(bitmap);
                Intent intent = new Intent(ImageEdit_Activity.this, Share_Activity.class);
                startActivity(intent);
            }
        });

        for (int i = 0; i < Ulits.img.length; i++) {
            LanguageData data = new LanguageData(Ulits.img[i]);
            dataList.add(data);
        }
        RecyclerView.LayoutManager manager = new GridLayoutManager(ImageEdit_Activity.this, 1, GridLayoutManager.HORIZONTAL, false);
        LanguageAdapter adapter = new LanguageAdapter(ImageEdit_Activity.this, dataList);
        language_list.setAdapter(adapter);
        language_list.setVisibility(View.GONE);
        language_list.setLayoutManager(manager);

        threed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check == 0) {
                    language_list.setVisibility(View.VISIBLE);
                    Effect_data.setVisibility(View.GONE);
                    Glare_Data.setVisibility(View.GONE);
                    check = 1;
                } else {
                    language_list.setVisibility(View.GONE);
                    Effect_data.setVisibility(View.GONE);
                    Glare_Data.setVisibility(View.GONE);
                    check = 0;
                }
            }
        });
        for (int i = 0; i < Ulits.imges_Effect.length; i++) {
            EffectData data = new EffectData(Ulits.imges_Effect[i]);
            effectData.add(data);
        }
        Effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c2 == 0) {
                    Effect_data.setVisibility(View.VISIBLE);
                    language_list.setVisibility(View.GONE);
                    Glare_Data.setVisibility(View.GONE);
                    c2 = 1;
                } else {
                    Effect_data.setVisibility(View.GONE);
                    language_list.setVisibility(View.GONE);
                    Glare_Data.setVisibility(View.GONE);
                    c2 = 0;
                }
            }
        });
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(ImageEdit_Activity.this, 1, GridLayoutManager.HORIZONTAL, false);
        EffectAdapter adapter1 = new EffectAdapter(ImageEdit_Activity.this, effectData);
        Effect_data.setAdapter(adapter1);
        Effect_data.setVisibility(View.GONE);
        Effect_data.setLayoutManager(manager1);

        for (int i = 0; i < Ulits.imges_Glare.length; i++) {
            GlareData data = new GlareData(Ulits.imges_Glare[i]);
            GlareData.add(data);
        }
        Glare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c3 == 0) {
                    Glare_Data.setVisibility(View.VISIBLE);
                    Effect_data.setVisibility(View.GONE);
                    language_list.setVisibility(View.GONE);
                    c3 = 1;
                } else {
                    Glare_Data.setVisibility(View.GONE);
                    Effect_data.setVisibility(View.GONE);
                    language_list.setVisibility(View.GONE);
                    c3 = 0;
                }
            }
        });
        RecyclerView.LayoutManager manager2 = new GridLayoutManager(ImageEdit_Activity.this, 1, GridLayoutManager.HORIZONTAL, false);
        GlareAdapter adapter2 = new GlareAdapter(ImageEdit_Activity.this, GlareData);
        Glare_Data.setAdapter(adapter2);
        Glare_Data.setVisibility(View.GONE);
        Glare_Data.setLayoutManager(manager2);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (r1 == 0) {
                    image.setRotation(90);
                    r1 = 1;
                } else if (r1 == 1) {
                    image.setRotation(180);
                    r1 = 2;
                } else if (r1 == 2) {
                    image.setRotation(270);
                    r1 = 3;
                } else if (r1 == 3) {
                    image.setRotation(360);
                    r1 = 0;
                }
            }
        });
        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (f1 == 0) {
                    image.setRotationY(180);
                    f1 = 1;
                } else if (f1 == 1) {
                    image.setRotationY(0);
                    f1 = 0;
                }
            }
        });
        Color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialogBuilder
                        .with(ImageEdit_Activity.this)
                        .setTitle("Choose color")
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .setOnColorSelectedListener(new OnColorSelectedListener() {
                            @Override
                            public void onColorSelected(int selectedColor) {
                            }
                        })
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                changeBackgroundColor(selectedColor);
                                front_img.setColorFilter(selectedColor);
                            }

                            private void changeBackgroundColor(int selectedColor) {
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();
            }
        });
        Filter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (c4 == 0) {
                    Filter_Data.setVisibility(View.VISIBLE);
                    Glare_Data.setVisibility(View.GONE);
                    Effect_data.setVisibility(View.GONE);
                    language_list.setVisibility(View.GONE);
                    c4 = 1;
                } else {
                    Glare_Data.setVisibility(View.GONE);
                    Effect_data.setVisibility(View.GONE);
                    language_list.setVisibility(View.GONE);
                    Filter_Data.setVisibility(View.GONE);
                    c4 = 0;
                }
            }
        });
        RecyclerView.LayoutManager manager3 = new GridLayoutManager(ImageEdit_Activity.this, 1, GridLayoutManager.HORIZONTAL, false);
        FilterAdapter adapter3 = new FilterAdapter(ImageEdit_Activity.this);
        Filter_Data.setLayoutManager(manager3);
        Filter_Data.setVisibility(View.GONE);
        Filter_Data.setAdapter(adapter3);


        View view = getLayoutInflater().inflate(R.layout.stickeritem, null);
        dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dialog.setContentView(view);

        Sticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                im1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        StickerAdapter adapter4 = new StickerAdapter(ImageEdit_Activity.this,Ulits.s1);

                    }
                });

                dialog.show();
            }
        });
        Sticker_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        View view1 = getLayoutInflater().inflate(R.layout.addtexeitem, null);
        dailog1 = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dailog1.setContentView(view1);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailog1.show();
            }
        });

        Text_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailog1.dismiss();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ImageEdit_Activity.this, Start_Activity.class);
                startActivity(intent);
            }
        });
    }


    private void binding() {

        back = findViewById(R.id.back);
        backe = findViewById(R.id.backe);
        image = findViewById(R.id.image);
        chake = findViewById(R.id.chake);
        threed = findViewById(R.id.threed);
        Effect = findViewById(R.id.Effect_icon);
        Glare = findViewById(R.id.Glare_icon);
        front_img = findViewById(R.id.front_img);
        Color = findViewById(R.id.Color_icon);
        rotate = findViewById(R.id.rotate_icon);
        flip = findViewById(R.id.flip_icon);
        Filter1 = findViewById(R.id.Filter_icon);
        Sticker = findViewById(R.id.Sticker_icon);
        text = findViewById(R.id.text_icon);
        im1 = dialog.findViewById(R.id.im1);
        im2 =dialog.findViewById(R.id.im2);
        im3 = dialog.findViewById(R.id.im3);
        im4 = dialog.findViewById(R.id.im4);
        im5 = dialog.findViewById(R.id.im5);

        language_list = findViewById(R.id.language_list);
        Effect_data = findViewById(R.id.Effect_Data);
        Glare_Data = findViewById(R.id.Glare_Data);
        Color_Data = findViewById(R.id.Color_Data);
        Filter_Data = findViewById(R.id.Filter_Data);
        Sticker_Data = findViewById(R.id.Sticker_Data);
        Text_Data = findViewById(R.id.Text_Data);


    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }
}


