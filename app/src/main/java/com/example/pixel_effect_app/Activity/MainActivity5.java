package com.example.pixel_effect_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.canhub.cropper.CropImage;
import com.example.pixel_effect_app.Adapter.EffectAdapter;
import com.example.pixel_effect_app.Adapter.Filter;
import com.example.pixel_effect_app.Adapter.FilterAdapter;
import com.example.pixel_effect_app.Adapter.GlareAdapter;
import com.example.pixel_effect_app.Adapter.LanguageAdapter;
import com.example.pixel_effect_app.R;
import com.example.pixel_effect_app.modal.EffectData;
import com.example.pixel_effect_app.modal.FilterData;
import com.example.pixel_effect_app.modal.GlareData;
import com.example.pixel_effect_app.modal.LanguageData;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.util.ArrayList;
import java.util.List;

import Utils.Ulits;

public class MainActivity5<position> extends AppCompatActivity {

    private static Object CropImage;
    ImageView back, chake;
    LinearLayout threed;
    LinearLayout Effect;
    LinearLayout Glare;
    LinearLayout Color;
    LinearLayout rotate;
    LinearLayout flip;
   
    int check = 0, c2 = 0, c3 = 0, r1 = 0, f1 = 0;

    public static Bitmap bitmap;
    public static ImageView image, front_img;

    private static final String TAG = "MainActivity5";
    List<LanguageData> dataList = new ArrayList<>();
    List<EffectData> effectData = new ArrayList<>();
    List<GlareData> GlareData = new ArrayList<>();

    RecyclerView language_list, Effect_data, Glare_Data, Color_Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        binding();
        image.setImageBitmap(MainActivity4.bitmap);

        chake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chake.setImageBitmap(bitmap);
                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                startActivity(intent);
            }
        });

        for (int i = 0; i < Ulits.img.length; i++) {
            LanguageData data = new LanguageData(Ulits.img[i]);
            dataList.add(data);
        }
        RecyclerView.LayoutManager manager = new GridLayoutManager(MainActivity5.this, 1, GridLayoutManager.HORIZONTAL, false);
        LanguageAdapter adapter = new LanguageAdapter(MainActivity5.this, dataList);
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
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(MainActivity5.this, 1, GridLayoutManager.HORIZONTAL, false);
        EffectAdapter adapter1 = new EffectAdapter(MainActivity5.this, effectData);
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
        RecyclerView.LayoutManager manager2 = new GridLayoutManager(MainActivity5.this, 1, GridLayoutManager.HORIZONTAL, false);
        GlareAdapter adapter2 = new GlareAdapter(MainActivity5.this, GlareData);
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
                        .with(MainActivity5.this)
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



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private void binding() {

        back = findViewById(R.id.back);
        image = findViewById(R.id.image);
        chake = findViewById(R.id.chake);
        threed = findViewById(R.id.threed);
        Effect = findViewById(R.id.Effect_icon);
        Glare = findViewById(R.id.Glare_icon);
        front_img = findViewById(R.id.front_img);
        Color = findViewById(R.id.Color_icon);
        rotate = findViewById(R.id.rotate_icon);
        flip = findViewById(R.id.flip_icon);

        language_list = findViewById(R.id.language_list);
        Effect_data = findViewById(R.id.Effect_Data);
        Glare_Data = findViewById(R.id.Glare_Data);
        Color_Data = findViewById(R.id.Color_Data);


    }


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
}


