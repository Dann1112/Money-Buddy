package com.manrique.daniel.moneybuddy.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainMenuFragment extends android.support.v4.app.Fragment
        implements View.OnClickListener {

    TextView dateView;
    Button income_btn, expense_btn, balance_btn;
    ImageView lastDay, nextDay;
    Calendar calendar;
    SimpleDateFormat sdf;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_menu, container, false);


        income_btn = (Button) view.findViewById(R.id.income_button);
        expense_btn = (Button) view.findViewById(R.id.expense_button);
        balance_btn = (Button) view.findViewById(R.id.balance_button);
        dateView = (TextView) view.findViewById(R.id.date);
        nextDay = (ImageView) view.findViewById(R.id.date_right_arrow);
        lastDay = (ImageView) view.findViewById(R.id.date_left_arrow);

        calendar = Calendar.getInstance();
        sdf = new SimpleDateFormat("MMMM dd, yyyy");

        dateView.setText(sdf.format(calendar.getTime()));




        income_btn.setOnClickListener(this);
        expense_btn.setOnClickListener(this);
        balance_btn.setOnClickListener(this);
        nextDay.setOnClickListener(this);
        lastDay.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        IncomeFragment incomeFragment = new IncomeFragment();
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putString("day", new SimpleDateFormat("dd").format(calendar.getTime()));
        args.putString("month", new SimpleDateFormat("MMMM").format(calendar.getTime()));
        args.putString("year", new SimpleDateFormat("yyyy").format(calendar.getTime()));
        args.putString("monthNumber", new SimpleDateFormat("MM").format(calendar.getTime()));


        incomeFragment.setArguments(args);
        categoriesFragment.setArguments(args);

        if (view == income_btn) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, incomeFragment)
                    .addToBackStack(null).commit();
        } else if (view == expense_btn) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, categoriesFragment)
                    .addToBackStack(null).commit();
        } else if (view == balance_btn) {
            this.getContext().deleteDatabase("moneyBuddy.db");
        } else if (view == nextDay) {
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            dateView.setText(sdf.format(calendar.getTime()));


        } else if (view == lastDay) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
            dateView.setText(sdf.format(calendar.getTime()));

        }

    }
}
