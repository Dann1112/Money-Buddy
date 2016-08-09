package com.manrique.daniel.moneybuddy.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.manrique.daniel.moneybuddy.R;

import java.util.ArrayList;

public class ItemListAdapter extends BaseAdapter {

    private ArrayList<String> itemName;
    private ArrayList<String> itemAmount;
    private int length;
    private Context context;


    public ItemListAdapter(Context context, ArrayList<String> itemName, ArrayList<String> itemAmount) {

        this.context = context;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
    }

    @Override
    public int getCount() {
        return itemName.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView itemNameView, itemAmountView;
        View list_item;

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            list_item = inflater.inflate(R.layout.list_item, viewGroup, false);

        } else
            list_item = view;

        itemNameView = (TextView) list_item.findViewById(R.id.item_name);
        itemAmountView = (TextView) list_item.findViewById(R.id.item_amount);

        itemNameView.setText(itemName.get(i));
        itemAmountView.setText(itemAmount.get(i));

        return list_item;

    }


}