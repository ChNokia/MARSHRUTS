package com.trickyandroid.fragmenttranslate.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FullImageActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        //ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(mThumbIds[position]);
    }

    private	Integer[] mThumbIds = { R.drawable.photo1, R.drawable.photo2,
            R.drawable.photo3, R.drawable.photo4, R.drawable.photo5,
            R.drawable.photo6, R.drawable.photo7, R.drawable.photo8,
            R.drawable.photo9, R.drawable.photo10, R.drawable.photo11,
            R.drawable.photo12, R.drawable.photo13, R.drawable.photo14,
            R.drawable.photo15, R.drawable.photo16, R.drawable.photo17,
            R.drawable.photo18, R.drawable.photo19, R.drawable.photo20,
            R.drawable.photo21 };
}