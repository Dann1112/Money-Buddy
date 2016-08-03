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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;

public class NewCatDialog extends Fragment implements View.OnClickListener {

    private final String[] categories = {"People", "Transportation", "Places", "Activities", "Others"};
    ImageView cancel;
    Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final GridView colorGrid;
        final ExpandableHeightGridView iconGrid;

        final Context context = this.getContext();

        View view = inflater.inflate(R.layout.new_category, null);
        spinner = (Spinner) view.findViewById(R.id.spinner);

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

    private class IconAdapter extends BaseAdapter {


        private final int[] people = {
                R.drawable.accesibility, R.drawable.baby, R.drawable.circle_person,
                R.drawable.person, R.drawable.run, R.drawable.face, R.drawable.heart,
                R.drawable.fingerprint, R.drawable.group, R.drawable.bad, R.drawable.good,
                R.drawable.nature, R.drawable.hand, R.drawable.pool, R.drawable.eye,
                R.drawable.pregnant};
        private final int[] transportation = {
                R.drawable.airplane, R.drawable.truck, R.drawable.truck1, R.drawable.bike,
                R.drawable.boat, R.drawable.bus, R.drawable.train, R.drawable.run,
                R.drawable.subway, R.drawable.taxi};
        private final int[] places = {
                R.drawable.bank, R.drawable.beach, R.drawable.seat, R.drawable.gym, R.drawable.gavel,
                R.drawable.healing, R.drawable.home, R.drawable.hotel, R.drawable.landscape,
                R.drawable.bar, R.drawable.restaurant, R.drawable.gas, R.drawable.library,
                R.drawable.parking, R.drawable.nature, R.drawable.pool, R.drawable.world,
                R.drawable.place, R.drawable.school, R.drawable.eshop, R.drawable.shopping,
                R.drawable.shopping1, R.drawable.store, R.drawable.movies, R.drawable.work};
        private final int[] activities = {
                R.drawable.brush, R.drawable.camera, R.drawable.tools, R.drawable.run,
                R.drawable.puzzle, R.drawable.flower, R.drawable.gamepad, R.drawable.golf,
                R.drawable.book, R.drawable.landscape, R.drawable.bar, R.drawable.cafe,
                R.drawable.restaurant, R.drawable.library, R.drawable.nature, R.drawable.art,
                R.drawable.pets, R.drawable.pool, R.drawable.chat, R.drawable.row, R.drawable.voice,
                R.drawable.shopping, R.drawable.shopping1, R.drawable.smoke, R.drawable.videocam,
                R.drawable.vg, R.drawable.couch, R.drawable.work};
        private final int[] others = {
                R.drawable.bookmark, R.drawable.bug, R.drawable.cake, R.drawable.call, R.drawable.clock,
                R.drawable.cloud, R.drawable.currency, R.drawable.file, R.drawable.moon,
                R.drawable.refresh, R.drawable.task, R.drawable.wallet, R.drawable.laptop,
                R.drawable.watch, R.drawable.scissors, R.drawable.credit_card, R.drawable.trash,
                R.drawable.desktop, R.drawable.dial, R.drawable.dns, R.drawable.email, R.drawable.seat,
                R.drawable.compass, R.drawable.puzzle, R.drawable.flower, R.drawable.streak,
                R.drawable.star, R.drawable.headset, R.drawable.lock, R.drawable.book, R.drawable.drop,
                R.drawable.keyboard, R.drawable.kitchen, R.drawable.bulbe, R.drawable.ticket,
                R.drawable.cafe, R.drawable.bar, R.drawable.car_wash, R.drawable.pizza, R.drawable.bell,
                R.drawable.pets, R.drawable.printer, R.drawable.room_service, R.drawable.voice,
                R.drawable.eshop, R.drawable.smoke, R.drawable.speaker, R.drawable.mobile,
                R.drawable.traffic, R.drawable.translate, R.drawable.usb, R.drawable.videocam,
                R.drawable.vg, R.drawable.volume, R.drawable.watch, R.drawable.bulbe1,
                R.drawable.couch, R.drawable.fire};
        public int cat;
        private Context context;
        private int selectedItem = -1;

        IconAdapter(Context context, int spinnerChoice) {

            this.context = context;
            cat = spinnerChoice;
        }

        @Override
        public int getCount() {
            switch (cat) {
                case 0:
                    return people.length;
                case 1:
                    return transportation.length;
                case 2:
                    return places.length;
                case 3:
                    return activities.length;
                case 4:
                    return others.length;
                default:
                    return 0;
            }
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

            ImageView icon;

            if (view == null) {

                icon = new ImageView(context);
                icon.setLayoutParams(new GridView.LayoutParams(100, 100));
                icon.setPadding(10, 10, 10, 10);
            } else
                icon = (ImageView) view;

            switch (cat) {
                case 0:
                    icon.setImageResource(people[i]);
                    break;
                case 1:
                    icon.setImageResource(transportation[i]);
                    break;
                case 2:
                    icon.setImageResource(places[i]);
                    break;
                case 3:
                    icon.setImageResource(activities[i]);
                    break;
                case 4:
                    icon.setImageResource(others[i]);
                    break;
            }

            if (i == selectedItem) {
                icon.setAlpha(255);
            } else
                icon.setAlpha(50);

            return icon;

        }
    }

    }


