package com.trickyandroid.fragmenttranslate.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private static final String LIST_FRAGMENT_TAG = "list_fragment";
    private GridView gridViewPhoto;
    private RelativeLayout gridViewLayout;
    private ArrayList<Integer> image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewLayout = (RelativeLayout) findViewById(R.id.gridViewLayout);
        gridViewPhoto = (GridView) findViewById(R.id.gridViewPhoto);

        fillImages();
        gridViewPhoto.setAdapter(new ImageAdapter(this, image));
        gridViewPhoto.setNumColumns(2);

        gridViewPhoto.setOnItemClickListener(gridviewOnItemClickListener);
    }

    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position,
                                long id) {
            toggleList();
        }
    };

    private void fillImages() {
        image = new ArrayList<Integer>();

        for ( int i = 0; i < mThumbIds.length; i++ ) {
            image.add(mThumbIds[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_show_list) {
            toggleList();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void toggleList() {


        Fragment f = getFragmentManager().findFragmentByTag(LIST_FRAGMENT_TAG);
        if (f != null) {
            Animation logoMoveAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_more);
            gridViewLayout.startAnimation(logoMoveAnimation);

            getFragmentManager().popBackStack();
        } else {
            Animation logoMoveAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_less);
            gridViewLayout.startAnimation(logoMoveAnimation);

            getFragmentManager().beginTransaction()
                    .setCustomAnimations(R.animator.slide_up,
                            R.animator.slide_down,
                            R.animator.slide_up,
                            R.animator.slide_down)
                    .add(R.id.list_fragment_container, SlidingListFragment
                                    .instantiate(this, SlidingListFragment.class.getName()),
                            LIST_FRAGMENT_TAG
                    ).addToBackStack(null).commit();
        }
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
