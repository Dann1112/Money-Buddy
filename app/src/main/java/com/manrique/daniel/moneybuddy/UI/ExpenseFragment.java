package com.manrique.daniel.moneybuddy.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.MainActivity;
import com.manrique.daniel.moneybuddy.R;
import com.manrique.daniel.moneybuddy.Validation;

public class ExpenseFragment extends Fragment {

    ListView listView;
    View layout;
    TextView descTxt;
    ImageView iconHeader;


    public ExpenseFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.cat_items_list, container, false);

        TextView dateView;
        final StringBuilder date = new StringBuilder();
        String day, month, monthNumber, year;
        String icon;
        final int categoryId;

        day = this.getArguments().getString("day");
        month = this.getArguments().getString("month");
        monthNumber = this.getArguments().getString("monthNumber");
        year = this.getArguments().getString("year");

        icon = this.getArguments().getString("icon");
        categoryId = this.getArguments().getInt("categoryId");

        month = month.substring(0, 1).toUpperCase() + month.substring(1);
        //monthNumber sirve para la base de datos

        date.append(month).append(" ")
                .append(day).append(", ")
                .append(year);

        dateView = (TextView) view.findViewById(R.id.date);

        dateView.setText(date);

        date.setLength(0);
        date.append(day).append(monthNumber).append(year);

        layout = view.findViewById(R.id.item_list_header);
        descTxt = (TextView) view.findViewById(R.id.description_header);
        iconHeader = (ImageView) view.findViewById(R.id.header_icon);
        iconHeader.setImageResource(Validation.transformToIcon(icon));
        View new_item = view.findViewById(R.id.add_new_item);

        new_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = ((MainActivity) getContext()).getSupportFragmentManager();

                Bundle bundle = new Bundle();
                bundle.putInt("origin", 3);
                bundle.putInt("categoryId", categoryId);
                bundle.putString("date", String.valueOf(date));
                NewItemDialog newItemDialog = new NewItemDialog();
                newItemDialog.setArguments(bundle);
                newItemDialog.show(fragmentManager, "New Item");
            }
        });

        int color = getArguments().getInt("color", 0);
        String description = getArguments().getString("description", "Default");


        layout.setBackgroundColor(color);
        descTxt.setText(description);


        listView = (ListView) view.findViewById(R.id.items_listview);

        //ItemListAdapter itemListAdapter = new ItemListAdapter(getContext(), names, amounts, names.length);

        //listView.setAdapter(itemListAdapter);
        return view;
    }
}
