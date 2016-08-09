package com.manrique.daniel.moneybuddy.UI;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.manrique.daniel.moneybuddy.Adapters.ColorAdapter;
import com.manrique.daniel.moneybuddy.Adapters.IconAdapter;
import com.manrique.daniel.moneybuddy.CustomViews.ExpandableHeightGridView;
import com.manrique.daniel.moneybuddy.Database.DatabaseContract;
import com.manrique.daniel.moneybuddy.Database.DatabaseOpenHelper;
import com.manrique.daniel.moneybuddy.R;
import com.manrique.daniel.moneybuddy.Validation;

public class NewCatDialog extends Fragment implements View.OnClickListener {

    private final String[] categories = {"People", "Transportation", "Places", "Activities", "Others"};
    ImageView cancel;
    TextView createButton;
    EditText categoryNameBox;
    Spinner spinner;
    View view;
    ExpandableHeightGridView colorGrid;
    ExpandableHeightGridView iconGrid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.new_category, null);
        spinner = (Spinner) view.findViewById(R.id.spinner);

        categoryNameBox = (EditText) view.findViewById(R.id.category_name_box);

        createButton = (TextView) view.findViewById(R.id.create);
        createButton.setOnClickListener(this);
        cancel = (ImageView) view.findViewById(R.id.cancel_action);
        cancel.setOnClickListener(this);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);


        iconGrid = (ExpandableHeightGridView) view.findViewById(R.id.grid_icons);
        IconAdapter iconAdapter =
                new IconAdapter(this.getContext(), spinner.getSelectedItemPosition());

        iconGrid.setAdapter(iconAdapter);
        iconGrid.setExpanded(true);

        colorGrid = (ExpandableHeightGridView) view.findViewById(R.id.grid_colors);
        colorGrid.setAdapter(new ColorAdapter(this.getContext()));
        colorGrid.setExpanded(true);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                IconAdapter myAdapter = (IconAdapter) iconGrid.getAdapter();
                myAdapter.cat = i;
                myAdapter.selectedItem = -1;
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        iconGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                IconAdapter myAdapter = (IconAdapter) iconGrid.getAdapter();
                myAdapter.selectedItem = position;
                myAdapter.notifyDataSetChanged();
            }
        });

        colorGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ColorAdapter myAdapter = (ColorAdapter) colorGrid.getAdapter();
                myAdapter.selectedItem = position;
                myAdapter.notifyDataSetChanged();
            }
        });




        return view;
    }

    private String validateIconSelected() {

        IconAdapter myAdapter = (IconAdapter) iconGrid.getAdapter();
        if (myAdapter.getItem(myAdapter.selectedItem) != null && myAdapter.selectedItem > -1)
            return (String) myAdapter.getItem(myAdapter.selectedItem);
        else {
            Toast.makeText(getContext(), "Select an Icon", Toast.LENGTH_SHORT).show();
            return "default";
        }
    }

    private String validateColorSelected() {

        ColorAdapter myAdapter = (ColorAdapter) colorGrid.getAdapter();
        if (myAdapter.getItem(myAdapter.selectedItem) != null && myAdapter.selectedItem > -1)
            return (String) myAdapter.getItem(myAdapter.selectedItem);
        else {
            Toast.makeText(getContext(), "Select a Color", Toast.LENGTH_SHORT).show();
            return "default";
        }
    }

    @Override
    public void onClick(View view) {
        if (view == cancel) {
            getFragmentManager().popBackStackImmediate();
        } else if (view == createButton) {
            String catName, iconSelected, colorSelected;


            if (Validation.validateAlpha(getContext(), categoryNameBox, "Category Name")) {

                catName = String.valueOf(categoryNameBox.getText()).trim();
                Toast.makeText(getContext(), catName, Toast.LENGTH_SHORT).show();

                if (!validateIconSelected().equals("default")) {
                    iconSelected = validateIconSelected();
                    Toast.makeText(getContext(), iconSelected, Toast.LENGTH_SHORT).show();

                    if (!validateColorSelected().equals("default")) {
                        colorSelected = validateColorSelected();
                        Toast.makeText(getContext(), colorSelected, Toast.LENGTH_SHORT).show();


                        SQLiteDatabase db = new DatabaseOpenHelper(this.getContext()).getWritableDatabase();
                        ContentValues testValues = new ContentValues();
                        testValues.put(DatabaseContract.Category.COLUMN_NAME_TITLE, catName);
                        testValues.put(DatabaseContract.Category.COLUMN_NAME_ICON, iconSelected);
                        testValues.put(DatabaseContract.Category.COLUMN_NAME_COLOR, Integer.parseInt(colorSelected));

                        try {
                            db.insert(DatabaseContract.Category.TABLE_NAME, null, testValues);
                            Toast.makeText(this.getContext(), "Nailed It", Toast.LENGTH_SHORT).show();
                            getFragmentManager().popBackStack();
                        } catch (Exception e) {
                            Toast.makeText(this.getContext(), "Impossible", Toast.LENGTH_SHORT).show();
                        }


                    } else return;


                } else return;


            } else return;
        }
    }





}


