package com.manrique.daniel.moneybuddy.Adapters;

import android.content.Context;
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

public class CategoryAdapter extends BaseAdapter implements View.OnClickListener {

    private final String[] titles;
    private final String[] amount;
    private final int[] colors;
    private final int[] icons;
    private Context context;
    private String day, month, year, monthNumber;

    public CategoryAdapter(Context context, String[] titles, String[] amount, int[] colors,
                           int[] icons, String day, String month, String year, String monthNumber) {
        this.context = context;
        this.titles = titles;
        this.amount = amount;
        this.colors = colors;
        this.icons = icons;
        this.day = day;
        this.month = month;
        this.year = year;
        this.monthNumber = monthNumber;
    }


    @Override
    public int getCount() {
        return titles.length + 1;
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
        if (i == titles.length) {
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
        txt.setText(titles[i]);
        txt = (TextView) cat.findViewById(R.id.category_amount);
        txt.setText(amount[i]);
        ImageView img = (ImageView) cat.findViewById(R.id.category_icon);
        img.setImageResource(icons[i]);
        LinearLayout linear = (LinearLayout) cat.findViewById(R.id.category_layout);
        linear.setBackgroundColor(colors[i]);

        return cat;

    }

    @Override
    public void onClick(View view) {

        ImageView icon;
        TextView description;

        ExpenseFragment newFrag = new ExpenseFragment();
        Bundle args = new Bundle();
        ColorDrawable background = (ColorDrawable) view.getBackground();
        description = (TextView) view.findViewById(R.id.category_name);

        icon = (ImageView) view.findViewById(R.id.category_icon);

        args.putInt("color", background.getColor());
        args.putString("description", (String) description.getText());
        args.putString("day", day);
        args.putString("month", month);
        args.putString("year", year);
        args.putString("monthNumber", monthNumber);

        newFrag.setArguments(args);
        FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.mainFrame, newFrag)
                .addToBackStack(null).commit();
    }
}

