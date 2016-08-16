package com.manrique.daniel.moneybuddy.UI;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.Database.DatabaseContract;
import com.manrique.daniel.moneybuddy.Database.DatabaseOpenHelper;
import com.manrique.daniel.moneybuddy.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainMenuFragment extends android.support.v4.app.Fragment
        implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    Calendar today;
    private TextView dateView;
    private Button income_btn, expense_btn, balance_btn;
    private ImageView lastDay, nextDay;
    private Calendar calendar;
    private SimpleDateFormat sdf;
    private TextView incomeAmount;
    private StringBuilder amount;
    private RelativeLayout layout;
    private DatePickerDialog dpd;

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
        incomeAmount = (TextView) view.findViewById(R.id.income_amount);
        layout = (RelativeLayout) view.findViewById(R.id.date_layout);

        calendar = Calendar.getInstance();
        today = Calendar.getInstance();


        layout.setBackgroundColor(ContextCompat.getColor(this.getContext(), R.color.colorAccent));

        sdf = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault());
        dateView.setText(sdf.format(calendar.getTime()));

        income_btn.setOnClickListener(this);
        expense_btn.setOnClickListener(this);
        balance_btn.setOnClickListener(this);
        nextDay.setOnClickListener(this);
        lastDay.setOnClickListener(this);
        dateView.setOnClickListener(this);

        amount = new StringBuilder();

        amount.append("$ ").append(String.valueOf(getTotalIncomeOfTheDay()));
        incomeAmount.setText(amount);

        return view;
    }

    private Double getTotalIncomeOfTheDay() {

        Double totalAmount;
        SQLiteDatabase db;
        Cursor incomeCursor;
        StringBuilder date;
        String day, month, year;

        //Gets Readable Database to read from DB
        db = new DatabaseOpenHelper(this.getContext()).getReadableDatabase();

        day = new SimpleDateFormat("dd", Locale.getDefault())
                .format(calendar.getTime());
        month = new SimpleDateFormat("MM", Locale.getDefault())
                .format(calendar.getTime());
        year = new SimpleDateFormat("yyyy", Locale.getDefault())
                .format(calendar.getTime());

        date = new StringBuilder();
        date.setLength(0);
        date.append(day).append(month).append(year);

        //Fetches data from DB
        incomeCursor = db.query(DatabaseContract.Income.TABLE_NAME,
                new String[]{
                        "rowid _id",
                        DatabaseContract.Income.COLUMN_NAME_DATE,
                        DatabaseContract.Income.COLUMN_NAME_AMOUNT},
                DatabaseContract.Income.COLUMN_NAME_DATE + " = " + date,
                null,
                null,
                null,
                null);

        //Moves cursor to first row
        incomeCursor.moveToFirst();

        totalAmount = 0.0;
        //Moves through cursor to store data from it to corresponding Arraylists
        for (; !incomeCursor.isAfterLast(); incomeCursor.moveToNext()) {

            totalAmount = totalAmount + Double.parseDouble(
                    incomeCursor.getString(
                            incomeCursor.getColumnIndexOrThrow(
                                    DatabaseContract.Income.COLUMN_NAME_AMOUNT)));

        }

        //Closes cursor
        incomeCursor.close();

        return totalAmount;

    }

    @Override
    public void onClick(View view) {

        IncomeFragment incomeFragment = new IncomeFragment();
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putString("day", new SimpleDateFormat("dd", Locale.getDefault())
                .format(calendar.getTime()));
        args.putString("month", new SimpleDateFormat("MMMM", Locale.getDefault())
                .format(calendar.getTime()));
        args.putString("year", new SimpleDateFormat("yyyy", Locale.getDefault())
                .format(calendar.getTime()));
        args.putString("monthNumber", new SimpleDateFormat("MM", Locale.getDefault())
                .format(calendar.getTime()));


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
            setDateToolbarTodayColor();

            amount = new StringBuilder();

            amount.append("$ ").append(String.valueOf(getTotalIncomeOfTheDay()));
            incomeAmount.setText(amount);


        } else if (view == lastDay) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
            dateView.setText(sdf.format(calendar.getTime()));
            setDateToolbarTodayColor();

            amount = new StringBuilder();

            amount.append("$ ").append(String.valueOf(getTotalIncomeOfTheDay()));
            incomeAmount.setText(amount);


        } else if (view == dateView) {

            int day, month, year;

            day = Integer.parseInt(
                    new SimpleDateFormat("dd", Locale.getDefault()).format(calendar.getTime()));
            month = Integer.parseInt(
                    new SimpleDateFormat("M", Locale.getDefault()).format(calendar.getTime()));
            year = Integer.parseInt(
                    new SimpleDateFormat("yyyy", Locale.getDefault()).format(calendar.getTime()));

            dpd = new DatePickerDialog(getContext(), this, year, month - 1, day);
            dpd.show();
        }

    }

    private void setDateToolbarTodayColor() {

        if (dateView.getText().equals(sdf.format(today.getTime())))
            layout.setBackgroundColor(
                    ContextCompat.getColor(this.getContext(), R.color.colorAccent));

        else
            layout.setBackgroundColor(
                    ContextCompat.getColor(this.getContext(), R.color.colorPrimary));


    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        calendar.set(i, i1, i2);
        dateView.setText(sdf.format(calendar.getTime()));
        setDateToolbarTodayColor();

        amount = new StringBuilder();
        amount.append("$ ").append(String.valueOf(getTotalIncomeOfTheDay()));
        incomeAmount.setText(amount);
    }
}
