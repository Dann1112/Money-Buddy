package com.manrique.daniel.moneybuddy.UI;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.Adapters.ItemListAdapter;
import com.manrique.daniel.moneybuddy.CustomViews.ExpandableHeightListView;
import com.manrique.daniel.moneybuddy.Database.DatabaseContract;
import com.manrique.daniel.moneybuddy.Database.DatabaseOpenHelper;
import com.manrique.daniel.moneybuddy.MainActivity;
import com.manrique.daniel.moneybuddy.R;

import java.util.ArrayList;

public class IncomeFragment extends Fragment implements View.OnClickListener {

    SQLiteDatabase db; //Database to be queried
    Cursor incomeCursor; //Cursor to save incomes read
    private StringBuilder date; //Stringbuilder to create the date to be set on the UI
    private String day, month, monthNumber, year; //Individual parts of the date
    private View new_item; //View that represents the 'Add new item' function
    private ExpandableHeightListView incomeListView; //Listview to be fulfilled with incomes
    private ArrayList<String> descriptions; //Arraylist to store incomes' descriptions DB
    private ArrayList<String> amounts;//Arraylist to store incomes' amounts from DB
    private ItemListAdapter incomeAdapter; //Adapter to fulfill 'incomeListView'

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view; //Main User Interface
        TextView dateView; //View to set date


        //Inflates layout to view
        view = inflater.inflate(R.layout.income_list, container, false);

        //Assigns id's to views
        dateView = (TextView) view.findViewById(R.id.date);
        incomeListView = (ExpandableHeightListView) view.findViewById(R.id.income_listview);

        new_item = view.findViewById(R.id.add_income);

        //Getting date arguments passed from MainMenuFragment
        day = this.getArguments().getString("day");
        month = this.getArguments().getString("month");
        monthNumber = this.getArguments().getString("monthNumber");
        year = this.getArguments().getString("year");

        //Set first letter as capital letter
        if (month != null)
            month = month.substring(0, 1).toUpperCase() + month.substring(1);

        //Builds date to set it on the toolbar
        date = new StringBuilder();
        date.append(month).append(" ")
                .append(day).append(", ")
                .append(year);

        //Sets date in toolbar
        dateView.setText(date);

        //Cleans date to build date to store it if there is a new item to be created
        date.setLength(0);
        date.append(day).append(monthNumber).append(year);

        //Gets data from database
        updateListView();


        new_item.setOnClickListener(this);

        return view;
    }

    private void updateListView() {

        descriptions = new ArrayList<>();
        amounts = new ArrayList<>();

        //Gets Readable Database to read from DB
        db = new DatabaseOpenHelper(this.getContext()).getReadableDatabase();

        //Fetches data from DB
        incomeCursor = db.query(DatabaseContract.Income.TABLE_NAME,
                new String[]{
                        "rowid _id",
                        DatabaseContract.Income.COLUMN_NAME_DATE,
                        DatabaseContract.Income.COLUMN_NAME_DESCRIPTION,
                        DatabaseContract.Income.COLUMN_NAME_AMOUNT},
                DatabaseContract.Income.COLUMN_NAME_DATE + " = " + date,
                null,
                null,
                null,
                null);

        //Moves cursor to first row
        incomeCursor.moveToFirst();

        //Moves through cursor to store data from it to corresponding Arraylists
        for (; !incomeCursor.isAfterLast(); incomeCursor.moveToNext()) {

            descriptions.add(
                    incomeCursor.getString(
                            incomeCursor.getColumnIndexOrThrow(
                                    DatabaseContract.Income.COLUMN_NAME_DESCRIPTION)));

            amounts.add("$ " +
                    incomeCursor.getString(
                            incomeCursor.getColumnIndexOrThrow(
                                    DatabaseContract.Income.COLUMN_NAME_AMOUNT)));

        }

        incomeAdapter = new ItemListAdapter(getContext(), descriptions, amounts);


        //Sets adapter to fulfill ListView with data
        incomeListView.setAdapter(incomeAdapter);

        //Closes cursor
        incomeCursor.close();

    }

    //Updates income listview while returning from New Item Dialog
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        updateListView();
    }

    @Override
    public void onClick(View view) {

        if (view == new_item) {

            FragmentManager fragmentManager;
            Bundle bundle;
            NewItemDialog newItemDialog;

            //Gets support fragment manager
            fragmentManager = ((MainActivity) getContext()).getSupportFragmentManager();


            bundle = new Bundle();
            bundle.putString("date", String.valueOf(date));

            /*Tells next dialog to store an INCOME
                1 - New Income
                2 - New Exclusive Expense
                3 - New Expense*/
            bundle.putInt("origin", 1);

            newItemDialog = new NewItemDialog();
            newItemDialog.setArguments(bundle);
            newItemDialog.show(fragmentManager, "New Item");
            newItemDialog.setTargetFragment(this, 1);


            if (newItemDialog.isDetached()) {
                incomeAdapter.notifyDataSetChanged();
            }
        }
    }
}
