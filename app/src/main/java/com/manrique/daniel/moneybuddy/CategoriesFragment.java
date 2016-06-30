package com.manrique.daniel.moneybuddy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CategoriesFragment extends Fragment {

    private final String[] titles = {"Transporte", "Comida", "Escuela"};
    private final String[] amounts = {" $300.30", "$ 64.50", "52.89"};
    private final int[] colors = {Color.GREEN, Color.RED, Color.YELLOW};
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
