package com.manrique.daniel.moneybuddy.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.manrique.daniel.moneybuddy.Database.DatabaseContract.Category;
import com.manrique.daniel.moneybuddy.Database.DatabaseContract.CategoryItem;
import com.manrique.daniel.moneybuddy.Database.DatabaseContract.ExclusiveExpense;
import com.manrique.daniel.moneybuddy.Database.DatabaseContract.Expense;
import com.manrique.daniel.moneybuddy.Database.DatabaseContract.Income;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "moneyBuddy.db";


    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String CREATE_INCOME_TABLE = "CREATE TABLE " + Income.TABLE_NAME + "(" +
                Income._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Income.COLUMN_NAME_DATE + " TEXT NOT NULL, " +
                Income.COLUMN_NAME_DESCRIPTION + " TEXT NOT NULL, " +
                Income.COLUMN_NAME_AMOUNT + " TEXT NOT NULL);";

        final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + Category.TABLE_NAME + "(" +
                Category.CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Category.COLUMN_NAME_TITLE + " TEXT NOT NULL, " +
                Category.COLUMN_NAME_ICON + " TEXT NOT NULL, " +
                Category.COLUMN_NAME_COLOR + " INTEGER NOT NULL);";

        final String CREATE_EXCLUSIVE_EXPENSE_TABLE = "CREATE TABLE " + ExclusiveExpense.TABLE_NAME + "(" +
                ExclusiveExpense._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ExclusiveExpense.COLUMN_NAME_DATE + " TEXT NOT NULL, " +
                ExclusiveExpense.COLUMN_NAME_DESCRIPTION + " TEXT NOT NULL, " +
                ExclusiveExpense.COLUMN_NAME_AMOUNT + " TEXT NOT NULL);";


        final String CREATE_CATEGORY_ITEM_TABLE = "CREATE TABLE " + CategoryItem.TABLE_NAME + "(" +
                CategoryItem._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoryItem.COLUMN_NAME_CATEGORY_KEY + " INTEGER NOT NULL, " +
                CategoryItem.COLUMN_NAME_DESCRIPTION + " TEXT NOT NULL, " +
                "FOREIGN KEY (" + CategoryItem.COLUMN_NAME_CATEGORY_KEY + ") REFERENCES " +
                Category.TABLE_NAME + "(" + Category._ID + "));";

        final String CREATE_EXPENSE_TABLE = "CREATE TABLE " + Expense.TABLE_NAME + "(" +
                Expense._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Expense.COLUMN_NAME_DATE + " INTEGER NOT NULL, " +
                Expense.COLUMN_NAME_CATEGORY_ITEM_KEY + " INTEGER, " +
                Expense.COLUMN_NAME_AMOUNT + " REAL NOT NULL, " +
                "FOREIGN KEY (" + Expense.COLUMN_NAME_CATEGORY_ITEM_KEY + ") REFERENCES " +
                CategoryItem.TABLE_NAME + "(" + CategoryItem._ID + "));";

        db.execSQL(CREATE_INCOME_TABLE);
        db.execSQL(CREATE_EXCLUSIVE_EXPENSE_TABLE);
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_CATEGORY_ITEM_TABLE);
        db.execSQL(CREATE_EXPENSE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
