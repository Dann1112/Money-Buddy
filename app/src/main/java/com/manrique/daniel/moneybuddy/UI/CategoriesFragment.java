package com.manrique.daniel.moneybuddy.UI;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.Adapters.CategoryAdapter;
import com.manrique.daniel.moneybuddy.CustomViews.ExpandableHeightGridView;
import com.manrique.daniel.moneybuddy.MainActivity;
import com.manrique.daniel.moneybuddy.R;


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
    private final String[] amounts = {" $300.30", "$64.50", "$52.89"};

    private final int[] colors = {Color.parseColor(orange), Color.parseColor(blue), Color.parseColor(purple)};
    private final int[] icons = {R.drawable.train, R.drawable.restaurant, R.drawable.school};

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (isAdded()) {

            TextView dateView;
            final StringBuilder date = new StringBuilder();
            String day, month, monthNumber, year;

            day = this.getArguments().getString("day");
            month = this.getArguments().getString("month");
            monthNumber = this.getArguments().getString("monthNumber");
            year = this.getArguments().getString("year");

            month = month.substring(0, 1).toUpperCase() + month.substring(1);
            //monthNumber sirve para la base de datos

            date.append(month).append(" ")
                    .append(day).append(", ")
                    .append(year);




            View new_item;
            CategoryAdapter adapter =
                    new CategoryAdapter(this.getContext(), titles, amounts, colors, icons,
                            day, month, year, monthNumber);

            ExpandableHeightGridView grid;

            View view = inflater.inflate(R.layout.categories, container, false);

            dateView = (TextView) view.findViewById(R.id.date);

            dateView.setText(date);

            date.setLength(0);
            date.append(day).append(monthNumber).append(year);

            new_item = view.findViewById(R.id.new_exclusive_list_item);
            new_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentManager fragmentManager = ((MainActivity) getContext()).getSupportFragmentManager();

                    Bundle bundle = new Bundle();
                    bundle.putString("date", String.valueOf(date));
                    bundle.putInt("origin", 2);
                    NewItemDialog newItemDialog = new NewItemDialog();
                    newItemDialog.setArguments(bundle);
                    newItemDialog.show(fragmentManager, "New Item");
                }
            });

            grid = (ExpandableHeightGridView) view.findViewById(R.id.grid_usual);
            grid.setAdapter(adapter);
            grid.setExpanded(true);

            return view;
        } else return null;

    }
}
