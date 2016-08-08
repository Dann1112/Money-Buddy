package com.manrique.daniel.moneybuddy;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ColorAdapter extends BaseAdapter {

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
    public int selectedItem = -1;
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

        if (i < 0) return null;

        switch (colors[i]) {
            case red:
                return "1";

            case pink:
                return "2";

            case purple:
                return "3";

            case deep_purple:
                return "4";

            case blue:
                return "5";

            case teal:
                return "6";

            case green:
                return "7";

            case yellow:
                return "8";

            case orange:
                return "9";

            case grey:
                return "10";

            default:
                return "default";

        }
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
            color.setPadding(20, 20, 20, 20);
        } else
            color = (ImageView) view;

        color.setBackgroundColor(Color.parseColor(colors[i]));
        if (i == selectedItem) {
            color.setImageResource(R.drawable.ok);
        } else
            color.setImageResource(0);

        return color;

    }
}
