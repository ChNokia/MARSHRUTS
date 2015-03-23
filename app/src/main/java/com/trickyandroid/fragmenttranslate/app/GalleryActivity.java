package com.trickyandroid.fragmenttranslate.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class GalleryActivity extends Activity {
    private ArrayList<Integer> images;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galary_main);

        GridView gridview = (GridView) findViewById(R.id.gridGalleryPhoto);

        fillImages();
        gridview.setAdapter(new ImageAdapter(this, images));

        gridview.setOnItemClickListener(gridviewOnItemClickListener);
    }

    private void fillImages() {
        images = new ArrayList<Integer>();

        for ( int i = 0; i < mThumbIds.length; i++ ) {
            images.add(mThumbIds[i]);
        }
    }

    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position,
                                long id) {
            Intent i = new Intent(getApplicationContext(),
                    FullImageActivity.class);
            // passing array index
            i.putExtra("id", position);
            startActivity(i);
        }
    };

    private	Integer[] mThumbIds = { R.drawable.photo1, R.drawable.photo2,
            R.drawable.photo3, R.drawable.photo4, R.drawable.photo5,
            R.drawable.photo6, R.drawable.photo7, R.drawable.photo8,
            R.drawable.photo9, R.drawable.photo10, R.drawable.photo11,
            R.drawable.photo12, R.drawable.photo13, R.drawable.photo14,
            R.drawable.photo15, R.drawable.photo16, R.drawable.photo17,
            R.drawable.photo18, R.drawable.photo19, R.drawable.photo20,
            R.drawable.photo21 };
}
