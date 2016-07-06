package com.manrique.daniel.moneybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemListAdapter extends BaseAdapter {

    private String itemName;
    private String itemAmount;
    private int length;
    private Context context;


    public ItemListAdapter(Context contex, String itemName, String itemAmount, int length) {

        this.context = context;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
        this.length = length;

    }

    @Override
    public int getCount() {
        return length;
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
        View itemLayout;
        View list_item;

        if (i == length) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            list_item = inflater.inflate(R.layout.new_list_item, viewGroup, false);

            return list_item;

        }

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            list_item = inflater.inflate(R.layout.list_item, viewGroup, false);

        } else
            list_item = view;

        itemLayout = list_item.findViewById(R.id.list_item);
        itemNameView = (TextView) list_item.findViewById(R.id.item_name);
        itemAmountView = (TextView) list_item.findViewById(R.id.item_amount);

        if (i % 2 != 0)
            itemLayout.setBackgroundResource(R.color.item_light_gray);

        itemNameView.setText(itemName);
        itemAmountView.setText(itemAmount);

        return list_item;

    }
}
