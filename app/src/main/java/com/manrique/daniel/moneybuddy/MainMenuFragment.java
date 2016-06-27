package com.manrique.daniel.moneybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainMenuFragment extends android.support.v4.app.Fragment {

    TextView dateView;
    ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_menu, container, false);
        dateView = (TextView) view.findViewById(R.id.date);
        dateView.setText(new SimpleDateFormat("dd - MMM - yy", Locale.getDefault()).format(new Date()));
        imageView = (ImageView) view.findViewById(R.id.income);


        return view;


    }



}
