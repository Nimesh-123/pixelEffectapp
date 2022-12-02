package com.example.pixel_effect_app.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.pixel_effect_app.BuildConfig;
import com.example.pixel_effect_app.R;

public class Start_Activity extends AppCompatActivity {
    ImageView ImageView, imageView4, imageView2, dot;

    public static Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        imageView2 = findViewById(R.id.imageView2);
        imageView4 = findViewById(R.id.imageView4);
        ImageView = findViewById(R.id.imageView);
        dot = findViewById(R.id.dot);


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start_Activity.this, crop_Activity.class);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Start_Activity.this, Creation.class);
                startActivity(intent);
            }
        });


        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu menu = new PopupMenu(Start_Activity.this, dot);
                menu.getMenuInflater().inflate(R.menu.option_menu, menu.getMenu());

                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {

                            case R.id.Rate:
                                Toast.makeText(Start_Activity.this, "Rate", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.share:
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Pixel Effect");
                                String shareMessage = "\nLet me recommend you this Application\n\n";
                                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                                intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                                startActivity(Intent.createChooser(intent, "Choose One"));

                                break;

                            case R.id.more:
                                Toast.makeText(Start_Activity.this, "more", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.police:
                                Toast.makeText(Start_Activity.this, "police", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                menu.show();
            }
        });
    }

    public void open_gallaery(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 1001);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            if (requestCode == 1001) {
                uri = data.getData();
                Intent intent1 = new Intent(Start_Activity.this, crop_Activity.class);
                startActivity(intent1);
            }
        }
    }
}
