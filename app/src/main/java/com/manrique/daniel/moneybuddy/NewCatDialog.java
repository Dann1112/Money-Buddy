package com.manrique.daniel.moneybuddy;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NewCatDialog extends Fragment implements View.OnClickListener {

    private final String[] categories = {"People", "Transportation", "Places", "Activities", "Others"};
    ImageView cancel;
    TextView createButton;
    EditText categoryNameBox;
    Spinner spinner;
    View view;
    GridView colorGrid;
    ExpandableHeightGridView iconGrid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.new_category, null);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        createButton = (TextView) view.findViewById(R.id.create);
        categoryNameBox = (EditText) view.findViewById(R.id.category_name_box);


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String catName, iconSelected;


                if (Validation.validateAlpha(getContext(), categoryNameBox, "Category Name")) {

                    catName = String.valueOf(categoryNameBox.getText());
                    Toast.makeText(getContext(), catName, Toast.LENGTH_SHORT).show();

                    if (!validateIconSelected().equals("default")) {
                        iconSelected = validateIconSelected();
                        Toast.makeText(getContext(), iconSelected, Toast.LENGTH_SHORT).show();
                    } else return;


                } else return;


                //colorSelected = validateColorSelected();


                //Toast.makeText(getContext(), colorSelected, Toast.LENGTH_SHORT).show();

                //AQUI SE ENVIA LA INFORMACION DE LA NUEVA CATEGORIA
                //TITULO DE LA CATEGORIA = STRING
                //ICONO = STRING
                //COLOR = STRING
            }
        });

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);


        iconGrid = (ExpandableHeightGridView) view.findViewById(R.id.grid_icons);
        IconAdapter iconAdapter =
                new IconAdapter(this.getContext(), spinner.getSelectedItemPosition());

        iconGrid.setAdapter(iconAdapter);
        iconGrid.setExpanded(true);

        colorGrid = (GridView) view.findViewById(R.id.grid_colors);
        colorGrid.setAdapter(new ColorAdapter(this.getContext()));


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

        cancel = (ImageView) view.findViewById(R.id.cancel_action);
        cancel.setOnClickListener(this);


        return view;
    }

    private String validateIconSelected() {

        IconAdapter myAdapter = (IconAdapter) iconGrid.getAdapter();
        if (myAdapter.getItem(myAdapter.selectedItem) != null && myAdapter.selectedItem > -1)
            return (String) myAdapter.getItem(myAdapter.selectedItem);
        else {
            Toast.makeText(getContext(), "Select an Icon " + myAdapter.selectedItem, Toast.LENGTH_SHORT).show();
            return "default";
        }
    }

    @Override
    public void onClick(View view) {
        if (view == cancel) {
            getFragmentManager().popBackStackImmediate();
        }
    }


    private class ColorAdapter extends BaseAdapter {

        //Colors from Google Material Design ( A200 Colors )
        private final String red = "#FF5252";
        private final String pink = "#FF4081";
        private final String purple = "#E040FB";
        private final String deep_purple = "#7C4DFF";
        private final String blue = "#448AFF";
        private final String teal = "#64FFDA";
        private final String green = "#B2FF59";
        private final String yellow = "#FFFF00";
        private final String orange = "#FFAB40";
        private final String grey = "#E0E0E0"; //Grey 300
        Context mContext;
        String[] colors = {red, pink, purple, deep_purple, blue, teal, green,
                yellow, orange, grey};
        private int selectedItem = -1;

        ColorAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return colors.length;
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

            ImageView color;

            if (view == null) {

                color = new ImageView(mContext);
                color.setLayoutParams(new GridView.LayoutParams(100, 100));
                color.setPadding(20, 20, 20, 20);
            } else
                color = (ImageView) view;

            color.setBackgroundColor(Color.parseColor(colors[i]));
            if (i == selectedItem) {
                color.setImageResource(R.drawable.ok);
            } else
                color.setImageResource(0);

            return color;

        }
    }


}


