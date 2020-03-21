package com.example.imageprocessor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

public class ImageEditActivity extends AppCompatActivity {

    ImageView filteredImage;
    Spinner filterSpinner;
    String imgPathString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_edit);

        filteredImage = (ImageView) findViewById(R.id.img_filtered);
        filterSpinner = (Spinner) findViewById(R.id.spn_filters);

        ArrayAdapter<String> filtersAdapter = new ArrayAdapter<String>(ImageEditActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.filters));
        filtersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(filtersAdapter);

        imgPathString = getIntent().getStringExtra("path_string");

        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadImgByInternetUrl(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void loadImgByInternetUrl(int option) {
        File file = new File(imgPathString);

        switch (option){
            case 0:
                Glide.with(this)
                        .load(file)
                        .into(filteredImage);
                Log.d("Sssssssss", "loadImgByInternetUrl: shutuppp");
                break;
            case 1:
                Glide.with(this)
                        .load(file)
                        .apply(new RequestOptions().transform(new Greyscale()))
                        .into(filteredImage);
                break;
            default:
                Glide.with(this)
                        .load(file)
                        .into(filteredImage);
                break;

        }


    }
}
