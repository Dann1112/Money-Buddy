package com.manrique.daniel.moneybuddy;

import android.provider.BaseColumns;

public final class DatabaseContract {
    // To prevent someone from accidentally instantiating the contract class,
    // here it is an empty constructor.
    public DatabaseContract() {
    }

    /* Inner classes that define the tables contents */
    public static final class Category implements BaseColumns {
        public static final String TABLE_NAME = "category";
        public static final String _ID = "category_id";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_ICON = "icon";
        public static final String COLUMN_NAME_COLOR = "color";
    }

    public static final class CategoryItem implements BaseColumns {
        public static final String TABLE_NAME = "category_item";
        public static final String _ID = "category_item_id";
        public static final String COLUMN_NAME_CATEGORY_KEY = "category_id";
        public static final String COLUMN_NAME_DESCRIPTION = "desc";
    }

    public static final class Income implements BaseColumns {
        public static final String TABLE_NAME = "income";
        public static final String _ID = "income_id";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }

    public static final class Expense implements BaseColumns {
        public static final String TABLE_NAME = "expense";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String _ID = "category_id";
        public static final String COLUMN_NAME_CATEGORY_ITEM_KEY = "category_item_id";
        public static final String COLUMN_NAME_AMOUNT = "amount";

    }

}
