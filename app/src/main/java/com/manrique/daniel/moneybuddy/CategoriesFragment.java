package com.manrique.daniel.moneybuddy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CategoriesFragment extends android.support.v4.app.Fragment {


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

    private final String[] titles = {"Transporte", "Comida", "Escuela"};
    private final String[] amounts = {" $300.30", "$ 64.50", "52.89"};

    private final int[] colors = {Color.parseColor(red), Color.parseColor(pink), Color.parseColor(purple)};
    private final int[] icons = {R.drawable.balance, R.drawable.right_arrow, R.drawable.left_arrow};

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (isAdded()) {

            CategoryAdapter adapter =
                    new CategoryAdapter(this.getContext(), titles, amounts, colors, icons);

            ExpandableHeightGridView grid;

            View view = inflater.inflate(R.layout.categories, container, false);

            grid = (ExpandableHeightGridView) view.findViewById(R.id.grid_usual);
            grid.setAdapter(adapter);
            grid.setExpanded(true);


            grid = (ExpandableHeightGridView) view.findViewById(R.id.grid_unusual);
            grid.setAdapter(adapter);
            grid.setExpanded(true);

            return view;
        } else return null;

    }
}
