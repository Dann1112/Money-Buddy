package com.manrique.daniel.moneybuddy;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemListAdapter extends BaseAdapter implements View.OnClickListener {

    private String[] itemName;
    private String[] itemAmount;
    private int length;
    private Context context;


    public ItemListAdapter(Context context, String[] itemName, String[] itemAmount, int length) {

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
        View list_item;

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            list_item = inflater.inflate(R.layout.list_item, viewGroup, false);
            list_item.setOnClickListener(this);

        } else
            list_item = view;

        itemNameView = (TextView) list_item.findViewById(R.id.item_name);
        itemAmountView = (TextView) list_item.findViewById(R.id.item_amount);

        itemNameView.setText(itemName[i]);
        itemAmountView.setText(itemAmount[i]);

        return list_item;

    }


    @Override
    public void onClick(View view) {

        FragmentManager fragmentManager = ((MainActivity) context).getSupportFragmentManager();

        NewItemDialog newItemDialog = new NewItemDialog();
        newItemDialog.show(fragmentManager, "New Item");

    }
}
