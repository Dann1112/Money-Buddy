package com.manrique.daniel.moneybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainMenuFragment extends android.support.v4.app.Fragment
        implements View.OnClickListener {

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

        income_btn.setOnClickListener(this);
        expense_btn.setOnClickListener(this);
        balance_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (view == income_btn)
            getFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, new CategoriesFragment()).commit();

        else if (view == expense_btn) {
            NewItemDialog newItemDialog = new NewItemDialog();
            newItemDialog.show(getFragmentManager(), "My Dialog");
        }

        else if (view == balance_btn)
            getFragmentManager().beginTransaction()
                    .replace(R.id.mainFrame, new CategoryItemsListFragment()).commit();

    }
}
