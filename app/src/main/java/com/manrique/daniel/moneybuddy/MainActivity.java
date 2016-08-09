package com.manrique.daniel.moneybuddy;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.manrique.daniel.moneybuddy.UI.CategoriesFragment;
import com.manrique.daniel.moneybuddy.UI.MainMenuFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction trans = manager.beginTransaction();

    CategoriesFragment categories = new CategoriesFragment();
    MainMenuFragment main_menu = new MainMenuFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trans.add(R.id.mainFrame, main_menu);
        trans.commit();

    }


}
