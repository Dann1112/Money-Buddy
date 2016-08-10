package com.manrique.daniel.moneybuddy.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.MainActivity;
import com.manrique.daniel.moneybuddy.R;
import com.manrique.daniel.moneybuddy.UI.ExpenseFragment;
import com.manrique.daniel.moneybuddy.UI.NewCatDialog;
import com.manrique.daniel.moneybuddy.Validation;

import java.util.ArrayList;


public class CategoryAdapter extends BaseAdapter implements View.OnClickListener {

    public ArrayList<String> icon;
    private ArrayList<String> title;
    private ArrayList<Integer> color;
    private Context context;
    private String iconSelected;
    private String day, month, year, monthNumber;

    public CategoryAdapter(Context context, ArrayList<String> title, ArrayList<String> icon,
                           ArrayList<Integer> color, String day, String month, String year,
                           String monthNumber) {

        this.context = context;
        this.title = title;
        this.icon = icon;
        this.color = color;
        this.day = day;
        this.month = month;
        this.year = year;
        this.monthNumber = monthNumber;

    }


    @Override
    public int getCount() {
        return title.size() + 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        View cat;

        //Set last view as the "New Category" view
        if (i == title.size()) {
            // get layout from mobile.xml
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cat = inflater.inflate(R.layout.category_new_item, viewGroup, false);

            cat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.mainFrame, new NewCatDialog())
                            .addToBackStack(null).commit();
                }
            });

            return cat;
        }


        //If it is the first view to be populated, populate with this
        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cat = inflater.inflate(R.layout.category_item, viewGroup, false);

            cat.setOnClickListener(this);

        }
        //Else, if it is a recycled view, just return last configuration
        else
            cat = view;


        //Set values to the view
        TextView txt = (TextView) cat.findViewById(R.id.category_name);
        txt.setText(title.get(i));

        ImageView img = (ImageView) cat.findViewById(R.id.category_icon);
        iconSelected = icon.get(i);
        img.setImageResource(Validation.transformToIcon(iconSelected));
        img.setTag(String.valueOf(iconSelected));

        LinearLayout linear = (LinearLayout) cat.findViewById(R.id.category_layout);
        linear.setBackgroundColor(Color.parseColor(Validation.transformToColor(color.get(i))));

        return cat;

    }

    @Override
    public void onClick(View view) {

        TextView description;
        ColorDrawable background;
        ImageView icon;


        ExpenseFragment newFrag = new ExpenseFragment();
        Bundle args = new Bundle();
        background = (ColorDrawable) view.getBackground();
        description = (TextView) view.findViewById(R.id.category_name);
        icon = (ImageView) view.findViewById(R.id.category_icon);


        args.putInt("color", background.getColor());
        args.putString("description", (String) description.getText());
        args.putString("day", day);
        args.putString("month", month);
        args.putString("year", year);
        args.putString("monthNumber", monthNumber);
        args.putString("icon", String.valueOf(icon.getTag()));

        newFrag.setArguments(args);
        FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainFrame, newFrag)
                .addToBackStack(null).commit();
    }
}

