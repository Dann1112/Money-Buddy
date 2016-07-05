package com.manrique.daniel.moneybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainMenuFragment extends android.support.v4.app.Fragment {

    TextView dateView;
    Button income_btn, expense_btn, balance_btn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_menu, container, false);
        dateView = (TextView) view.findViewById(R.id.date);
        dateView.setText(new SimpleDateFormat("dd - MMM - yy", Locale.getDefault()).format(new Date()));

        income_btn = (Button) view.findViewById(R.id.income_button);
        expense_btn = (Button) view.findViewById(R.id.expense_button);
        balance_btn = (Button) view.findViewById(R.id.balance_button);

        setListener(income_btn, new CategoriesFragment());
        setListener(expense_btn, new CategoriesFragment());
        setListener(balance_btn, new CategoriesFragment());
        income_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().
                        replace(R.id.mainFrame, new CategoriesFragment()).commit();

            }
        });



        return view;
    }

    public void setListener(View view, final Fragment destination) {

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.mainFrame, destination).commit();
            }
        };

        view.setOnClickListener(listener);

    }



}
