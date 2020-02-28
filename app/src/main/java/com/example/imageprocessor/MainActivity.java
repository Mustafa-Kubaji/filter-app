package com.example.imageprocessor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST = 100;

    ImageView mainImage;
    // mustafaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImage = (ImageView) findViewById(R.id.img_main);

        requestStoragePermission();




        loadImgByInternetUrl();


    }


    private void requestStoragePermission() {
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST);
        }
    }


    private void loadImgByInternetUrl() {
        File file = new File("/storage/emulated/0/Download/1.jpg");
        Glide.with(MainActivity.this).load(file).into(mainImage);


        Glide.with(this)
                .load(file)
                .apply(new RequestOptions().transform(new Greyscale()))
                .into(mainImage);
    }

}





