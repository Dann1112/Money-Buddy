package com.manrique.daniel.moneybuddy.UI;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.Adapters.CategoryAdapter;
import com.manrique.daniel.moneybuddy.Adapters.ItemListAdapter;
import com.manrique.daniel.moneybuddy.CustomViews.ExpandableHeightGridView;
import com.manrique.daniel.moneybuddy.Database.DatabaseContract;
import com.manrique.daniel.moneybuddy.Database.DatabaseOpenHelper;
import com.manrique.daniel.moneybuddy.MainActivity;
import com.manrique.daniel.moneybuddy.R;

import java.util.ArrayList;


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

    private ArrayList<String> title, icon;
    private ArrayList<Integer> color, categoryId;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (isAdded()) {

            TextView dateView;
            ListView exclusiveList;
            ItemListAdapter exclusiveAdapter;
            Cursor exclusiveCursor;
            final StringBuilder date = new StringBuilder();
            String day, month, monthNumber, year;
            View new_item;
            SQLiteDatabase db;
            Cursor categoriesCursor;


            day = this.getArguments().getString("day");
            month = this.getArguments().getString("month");
            monthNumber = this.getArguments().getString("monthNumber");
            year = this.getArguments().getString("year");

            month = month.substring(0, 1).toUpperCase() + month.substring(1);
            //monthNumber sirve para la base de datos

            date.append(month).append(" ")
                    .append(day).append(", ")
                    .append(year);

            db = new DatabaseOpenHelper(this.getContext()).getReadableDatabase();

            categoriesCursor = db.query(DatabaseContract.Category.TABLE_NAME,
                    new String[]{
                            "rowid _id",
                            DatabaseContract.Category.COLUMN_NAME_TITLE,
                            DatabaseContract.Category.COLUMN_NAME_ICON,
                            DatabaseContract.Category.COLUMN_NAME_COLOR},
                    null,
                    null,
                    null,
                    null,
                    null);

            categoriesCursor.moveToFirst();
            categoryId = new ArrayList<>();
            title = new ArrayList<>();
            icon = new ArrayList<>();
            color = new ArrayList<>();


            for (; !categoriesCursor.isAfterLast(); categoriesCursor.moveToNext()) {


                categoryId.add(
                        categoriesCursor.getInt(
                                categoriesCursor.getColumnIndexOrThrow(
                                        "_id")));

                title.add(
                        categoriesCursor.getString(
                                categoriesCursor.getColumnIndexOrThrow(
                                        DatabaseContract.Category.COLUMN_NAME_TITLE)));

                icon.add(
                        categoriesCursor.getString(
                                categoriesCursor.getColumnIndexOrThrow(
                                        DatabaseContract.Category.COLUMN_NAME_ICON)));

                color.add(
                        categoriesCursor.getInt(
                                categoriesCursor.getColumnIndexOrThrow(
                                        DatabaseContract.Category.COLUMN_NAME_COLOR)));


            }

            categoriesCursor.close();


            CategoryAdapter adapter =
                    new CategoryAdapter(this.getContext(), title, icon, color, categoryId,
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

            exclusiveList = (ListView) view.findViewById(R.id.exclusive_listview);

            db = new DatabaseOpenHelper(this.getContext()).getReadableDatabase();

            exclusiveCursor = db.query(DatabaseContract.ExclusiveExpense.TABLE_NAME,
                    new String[]{
                            "rowid _id",
                            DatabaseContract.ExclusiveExpense.COLUMN_NAME_DATE,
                            DatabaseContract.ExclusiveExpense.COLUMN_NAME_DESCRIPTION,
                            DatabaseContract.ExclusiveExpense.COLUMN_NAME_AMOUNT},
                    null,
                    null,
                    null,
                    null,
                    null);

            exclusiveCursor.moveToFirst();

            ArrayList<String> descriptions, amounts;
            descriptions = new ArrayList<>();
            amounts = new ArrayList<>();

            for (; !exclusiveCursor.isAfterLast(); exclusiveCursor.moveToNext()) {

                descriptions.add(
                        exclusiveCursor.getString(
                                exclusiveCursor.getColumnIndexOrThrow(
                                        DatabaseContract.ExclusiveExpense.COLUMN_NAME_DESCRIPTION)));

                amounts.add("$ " +
                        exclusiveCursor.getString(
                                exclusiveCursor.getColumnIndexOrThrow(
                                        DatabaseContract.ExclusiveExpense.COLUMN_NAME_AMOUNT)));

            }
            exclusiveCursor.close();

            exclusiveAdapter = new ItemListAdapter(getContext(), descriptions, amounts);
            exclusiveList.setAdapter(exclusiveAdapter);

            return view;
        } else return null;

    }
}

