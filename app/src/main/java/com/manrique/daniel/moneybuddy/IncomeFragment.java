package com.manrique.daniel.moneybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IncomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.income_list, container, false);
        View new_item = view.findViewById(R.id.add_income);

        new_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = ((MainActivity) getContext()).getSupportFragmentManager();

                Bundle bundle = new Bundle();
                bundle.putInt("origin", 1);
                NewItemDialog newItemDialog = new NewItemDialog();
                newItemDialog.setArguments(bundle);
                newItemDialog.show(fragmentManager, "New Item");
            }
        });

        return view;
    }
}
