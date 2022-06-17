package com.example.pixel_effect_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.canhub.cropper.CropImageView;
import com.example.pixel_effect_app.R;

public class MainActivity4 extends AppCompatActivity {
    CropImageView imagecrop;
    ImageView images;

    public static Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        imagecrop = findViewById(R.id.imagecrop);
        images = findViewById(R.id.images);


        imagecrop.setImageUriAsync(MainActivity2.uri);

        images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bitmap = imagecrop.getCroppedImage();

                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intent);


            }
        });
    }
}