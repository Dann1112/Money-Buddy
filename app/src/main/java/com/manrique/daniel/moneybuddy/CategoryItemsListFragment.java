package com.manrique.daniel.moneybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CategoryItemsListFragment extends Fragment {

    ListView listView;
    String[] names = {"Metro", "Taxi", "Mexibus"};
    String[] amounts = {"192.0", "139.12", "194.27"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.cat_items_list, container, false);

        listView = (ListView) view.findViewById(R.id.items_listview);
        ItemListAdapter itemListAdapter = new ItemListAdapter(getContext(), names, amounts, names.length);

        listView.setAdapter(itemListAdapter);
        return view;
    }
}
