package com.manrique.daniel.moneybuddy.UI;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.Adapters.ItemListAdapter;
import com.manrique.daniel.moneybuddy.Database.DatabaseContract;
import com.manrique.daniel.moneybuddy.Database.DatabaseOpenHelper;
import com.manrique.daniel.moneybuddy.MainActivity;
import com.manrique.daniel.moneybuddy.R;

import java.util.ArrayList;

public class IncomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view, new_item;
        ListView incomeList;
        SQLiteDatabase db;
        Cursor incomeCursor;
        ItemListAdapter incomeAdapter;
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

        ArrayList<String> descriptions;
        ArrayList<String> amounts;

        view = inflater.inflate(R.layout.income_list, container, false);
        dateView = (TextView) view.findViewById(R.id.date);

        dateView.setText(date);

        date.setLength(0);
        date.append(day).append(monthNumber).append(year);

        incomeList = (ListView) view.findViewById(R.id.income_listview);

        descriptions = new ArrayList<>();
        amounts = new ArrayList<>();


        new_item = view.findViewById(R.id.add_income);

        db = new DatabaseOpenHelper(this.getContext()).getReadableDatabase();

        incomeCursor = db.query(DatabaseContract.Income.TABLE_NAME,
                new String[]{
                        "rowid _id",
                        DatabaseContract.Income.COLUMN_NAME_DATE,
                        DatabaseContract.Income.COLUMN_NAME_DESCRIPTION,
                        DatabaseContract.Income.COLUMN_NAME_AMOUNT},
                null,
                null,
                null,
                null,
                null);

        incomeCursor.moveToFirst();

        do {
            descriptions.add(
                    incomeCursor.getString(
                            incomeCursor.getColumnIndexOrThrow(
                                    DatabaseContract.Income.COLUMN_NAME_DESCRIPTION)));

            amounts.add("$ " +
                    incomeCursor.getString(
                            incomeCursor.getColumnIndexOrThrow(
                                    DatabaseContract.Income.COLUMN_NAME_AMOUNT)));

        } while (incomeCursor.moveToNext());

        incomeAdapter = new ItemListAdapter(getContext(), descriptions, amounts);
        incomeList.setAdapter(incomeAdapter);
        incomeCursor.close();

        new_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = ((MainActivity) getContext()).getSupportFragmentManager();

                Bundle bundle = new Bundle();
                bundle.putString("date", String.valueOf(date));
                bundle.putInt("origin", 1);
                NewItemDialog newItemDialog = new NewItemDialog();
                newItemDialog.setArguments(bundle);
                newItemDialog.show(fragmentManager, "New Item");
            }
        });

        return view;
    }
}
