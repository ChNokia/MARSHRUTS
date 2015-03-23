package com.trickyandroid.fragmenttranslate.app;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SlidingListFragment extends Fragment {
    private GridView gridViewOpt;
    private ArrayList<Integer> images;

    private	Integer[] mThumbIds = { R.drawable.location, R.drawable.thumbnails,
            R.drawable.document, R.drawable.info, R.drawable.gears, R.drawable.wifi};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sliding_fragment_layout, container, false);

        fillImages();

        gridViewOpt = (GridView) view.findViewById(R.id.grid_options);
        ImageAdapter adapter = new ImageAdapter(getActivity(), images);
        gridViewOpt.setAdapter(adapter);
        gridViewOpt.setNumColumns(3);

        gridViewOpt.setOnItemClickListener(gridviewOnItemClickListener);

        return view;
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
            if ( position == 1 ) {
                Intent i = new Intent(getActivity().getApplicationContext(),
                        GalleryActivity.class);

                startActivity(i);
            }
           // toggleList();
        }
    };
/*
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //setListAdapter(new MyListAdapter());
    }*/

    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 30;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView result = (TextView) convertView;
            if (result == null) {
                result = (TextView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_view_item, parent, false);
            }
            result.setText("My custom element #" + position);

            return result;
        }
    }
}
