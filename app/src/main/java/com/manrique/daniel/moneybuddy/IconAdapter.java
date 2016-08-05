package com.manrique.daniel.moneybuddy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Dann on 05/08/2016.
 */
public class IconAdapter extends BaseAdapter {


    private final int[] people = {
            R.drawable.accessibility, R.drawable.baby, R.drawable.circle_person,
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
    public int selectedItem = -1;
    private Context context;

    IconAdapter(Context context, int spinnerChoice) {

        this.context = context;
        cat = spinnerChoice;
    }

    public int getCat() {
        return cat;
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

        if (i < 0) return null;

        switch (cat) {

            case 0:
                if (people[i] == R.drawable.accessibility) return String.valueOf("accessibility");
                else if (people[i] == R.drawable.baby) return String.valueOf("baby");
                else if (people[i] == R.drawable.circle_person)
                    return String.valueOf("circle_person");
                else if (people[i] == R.drawable.person) return String.valueOf("person");
                else if (people[i] == R.drawable.run) return String.valueOf("run");
                else if (people[i] == R.drawable.face) return String.valueOf("face");
                else if (people[i] == R.drawable.heart) return String.valueOf("heart");
                else if (people[i] == R.drawable.fingerprint) return String.valueOf("fingerprint");
                else if (people[i] == R.drawable.group) return String.valueOf("group");
                else if (people[i] == R.drawable.bad) return String.valueOf("bad");
                else if (people[i] == R.drawable.good) return String.valueOf("good");
                else if (people[i] == R.drawable.nature) return String.valueOf("nature");
                else if (people[i] == R.drawable.hand) return String.valueOf("hand");
                else if (people[i] == R.drawable.pool) return String.valueOf("pool");
                else if (people[i] == R.drawable.eye) return String.valueOf("eye");
                else if (people[i] == R.drawable.pregnant) return String.valueOf("pregnant");
                else return null;

            case 1:
                if (transportation[i] == R.drawable.airplane) return String.valueOf("airplane");
                else if (transportation[i] == R.drawable.truck) return String.valueOf("truck");
                else if (transportation[i] == R.drawable.truck1) return String.valueOf("truck1");
                else if (transportation[i] == R.drawable.bike) return String.valueOf("bike");
                else if (transportation[i] == R.drawable.boat) return String.valueOf("boat");
                else if (transportation[i] == R.drawable.bus) return String.valueOf("bus");
                else if (transportation[i] == R.drawable.train) return String.valueOf("train");
                else if (transportation[i] == R.drawable.run) return String.valueOf("run");
                else if (transportation[i] == R.drawable.subway) return String.valueOf("subway");
                else if (transportation[i] == R.drawable.taxi) return String.valueOf("taxi");
                else return null;

            case 2:
                if (places[i] == R.drawable.bank) return String.valueOf("bank");
                else if (places[i] == R.drawable.beach) return String.valueOf("beach");
                else if (places[i] == R.drawable.seat) return String.valueOf("seat");
                else if (places[i] == R.drawable.gym) return String.valueOf("gym");
                else if (places[i] == R.drawable.gavel) return String.valueOf("gavel");
                else if (places[i] == R.drawable.healing) return String.valueOf("healing");
                else if (places[i] == R.drawable.home) return String.valueOf("home");
                else if (places[i] == R.drawable.hotel) return String.valueOf("hotel");
                else if (places[i] == R.drawable.landscape) return String.valueOf("landscape");
                else if (places[i] == R.drawable.bar) return String.valueOf("bar");
                else if (places[i] == R.drawable.restaurant) return String.valueOf("restaurant");
                else if (places[i] == R.drawable.gas) return String.valueOf("gas");
                else if (places[i] == R.drawable.library) return String.valueOf("library");
                else if (places[i] == R.drawable.parking) return String.valueOf("parking");
                else if (places[i] == R.drawable.nature) return String.valueOf("nature");
                else if (places[i] == R.drawable.pool) return String.valueOf("pool");
                else if (places[i] == R.drawable.world) return String.valueOf("world");
                else if (places[i] == R.drawable.place) return String.valueOf("place");
                else if (places[i] == R.drawable.school) return String.valueOf("school");
                else if (places[i] == R.drawable.eshop) return String.valueOf("eshop");
                else if (places[i] == R.drawable.shopping) return String.valueOf("shopping");
                else if (places[i] == R.drawable.shopping1) return String.valueOf("shopping1");
                else if (places[i] == R.drawable.store) return String.valueOf("store");
                else if (places[i] == R.drawable.movies) return String.valueOf("movies");
                else if (places[i] == R.drawable.work) return String.valueOf("work");
                else return null;

            case 3:
                if (activities[i] == R.drawable.brush) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.camera) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.tools) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.run) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.puzzle) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.flower) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.gamepad) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.golf) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.book) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.landscape) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.bar) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.cafe) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.restaurant) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.library) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.nature) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.art) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.pets) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.pool) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.chat) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.row) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.voice) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.shopping) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.shopping1) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.smoke) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.videocam) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.vg) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.couch) return String.valueOf("bookmark");
                else if (activities[i] == R.drawable.work) return String.valueOf("bookmark");
                else return null;

            case 4:
                if (others[i] == R.drawable.bookmark) return String.valueOf("bookmark");
                else if (others[i] == R.drawable.bug) return String.valueOf("bug");
                else if (others[i] == R.drawable.cake) return String.valueOf("cake");
                else if (others[i] == R.drawable.call) return String.valueOf("call");
                else if (others[i] == R.drawable.clock) return String.valueOf("clock");
                else if (others[i] == R.drawable.cloud) return String.valueOf("cloud");
                else if (others[i] == R.drawable.currency) return String.valueOf("currency");
                else if (others[i] == R.drawable.file) return String.valueOf("file");
                else if (others[i] == R.drawable.moon) return String.valueOf("moon");
                else if (others[i] == R.drawable.refresh) return String.valueOf("refresh");
                else if (others[i] == R.drawable.task) return String.valueOf("task");
                else if (others[i] == R.drawable.wallet) return String.valueOf("wallet");
                else if (others[i] == R.drawable.laptop) return String.valueOf("laptop");
                else if (others[i] == R.drawable.watch) return String.valueOf("watch");
                else if (others[i] == R.drawable.scissors) return String.valueOf("scissors");
                else if (others[i] == R.drawable.credit_card) return String.valueOf("credit_card");
                else if (others[i] == R.drawable.trash) return String.valueOf("trash");
                else if (others[i] == R.drawable.desktop) return String.valueOf("desktop");
                else if (others[i] == R.drawable.dial) return String.valueOf("dial");
                else if (others[i] == R.drawable.dns) return String.valueOf("dns");
                else if (others[i] == R.drawable.email) return String.valueOf("email");
                else if (others[i] == R.drawable.seat) return String.valueOf("seat");
                else if (others[i] == R.drawable.compass) return String.valueOf("compass");
                else if (others[i] == R.drawable.puzzle) return String.valueOf("puzzle");
                else if (others[i] == R.drawable.flower) return String.valueOf("flower");
                else if (others[i] == R.drawable.streak) return String.valueOf("streak");
                else if (others[i] == R.drawable.star) return String.valueOf("star");
                else if (others[i] == R.drawable.headset) return String.valueOf("headset");
                else if (others[i] == R.drawable.lock) return String.valueOf("lock");
                else if (others[i] == R.drawable.book) return String.valueOf("book");
                else if (others[i] == R.drawable.drop) return String.valueOf("drop");
                else if (others[i] == R.drawable.keyboard) return String.valueOf("keyboard");
                else if (others[i] == R.drawable.kitchen) return String.valueOf("kitchen");
                else if (others[i] == R.drawable.bulbe) return String.valueOf("bulbe");
                else if (others[i] == R.drawable.ticket) return String.valueOf("ticket");
                else if (others[i] == R.drawable.cafe) return String.valueOf("cafe");
                else if (others[i] == R.drawable.bar) return String.valueOf("bar");
                else if (others[i] == R.drawable.car_wash) return String.valueOf("car_wash");
                else if (others[i] == R.drawable.pizza) return String.valueOf("pizza");
                else if (others[i] == R.drawable.bell) return String.valueOf("bell");
                else if (others[i] == R.drawable.pets) return String.valueOf("pets");
                else if (others[i] == R.drawable.printer) return String.valueOf("printer");
                else if (others[i] == R.drawable.room_service)
                    return String.valueOf("room_service");
                else if (others[i] == R.drawable.eshop) return String.valueOf("eshop");
                else if (others[i] == R.drawable.smoke) return String.valueOf("smoke");
                else if (others[i] == R.drawable.speaker) return String.valueOf("speaker");
                else if (others[i] == R.drawable.mobile) return String.valueOf("mobile");
                else if (others[i] == R.drawable.traffic) return String.valueOf("traffic");
                else if (others[i] == R.drawable.translate) return String.valueOf("translate");
                else if (others[i] == R.drawable.usb) return String.valueOf("usb");
                else if (others[i] == R.drawable.videocam) return String.valueOf("videocam");
                else if (others[i] == R.drawable.vg) return String.valueOf("vg");
                else if (others[i] == R.drawable.volume) return String.valueOf("volume");
                else if (others[i] == R.drawable.watch) return String.valueOf("watch");
                else if (others[i] == R.drawable.bulbe1) return String.valueOf("bulbe1");
                else if (others[i] == R.drawable.couch) return String.valueOf("couch");
                else if (others[i] == R.drawable.fire) return String.valueOf("fire");
                else return null;

            default:
                return null;
        }
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