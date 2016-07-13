package com.manrique.daniel.moneybuddy;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class NewCatDialog extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        GridView colorGrid;

        View view = inflater.inflate(R.layout.new_category, null);
        colorGrid = (GridView) view.findViewById(R.id.grid_colors);
        colorGrid.setAdapter(new ColorAdapter(this.getContext()));

        return view;
    }


    private class ColorAdapter extends BaseAdapter {

        //Colors from Google Material Design ( A200 Colors )
        private final String red = "#FF5252";
        private final String pink = "#FF4081";
        private final String purple = "#E040FB";
        private final String deep_purple = "#7C4DFF";
        private final String blue = "#448AFF";
        private final String teal = "#64FFDA";
        private final String green = "#B2FF59";
        private final String yellow = "#FFFF00";
        private final String orange = "#FFAB40";
        private final String grey = "#E0E0E0"; //Grey 300
        Context mContext;
        String[] colors = {red, pink, purple, deep_purple, blue, teal, green,
                yellow, orange, grey};

        ColorAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ImageView color;

            if (view == null) {

                color = new ImageView(mContext);
                color.setLayoutParams(new GridView.LayoutParams(100, 100));
            } else
                color = (ImageView) view;

            color.setBackgroundColor(Color.parseColor(colors[i]));
            return color;

        }
    }

    }


