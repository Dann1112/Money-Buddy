package com.manrique.daniel.moneybuddy;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class Validation {


    public static boolean validateAlpha(Context context, EditText box, String boxDescription) {

        //Variable where we are going to store what is inside the EditText
        String text;

        //If it is null, is INVALID
        if (box != null) {
            text = String.valueOf(box.getText());

            //If it es empty, is INVALID
            if (text.equals("") || text.isEmpty()) {
                Toast.makeText(context, boxDescription + " is empty", Toast.LENGTH_SHORT).show();
                return false;
            }

            //If any character is neither a letter nor a digit, is INVALID
            for (char c : text.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    Toast.makeText(context, "Only letter or numbers for name", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }

            //Else, is VALID
            return true;

        } else
            return false;

    }

    public static boolean validateNumber(Context context, EditText box, String boxDescription) {

        //Variable where we are going to store what is inside the EditText
        String number;

        int decimal = 0;

        //If it is null, is INVALID
        if (box != null) {
            number = String.valueOf(box.getText());

            //If it es empty, is INVALID
            if (number.equals("") || number.isEmpty()) {
                Toast.makeText(context, boxDescription + " is empty", Toast.LENGTH_SHORT).show();
                return false;
            }

            //If any character is not a digit or a decimal point, is INVALID
            for (char c : number.toCharArray()) {

                if (!Character.isDigit(c)) {

                    //If there is a decimal point, counter adds one
                    if (String.valueOf(c).equals(".")) decimal++;
                    //If there is more than a point, is INVALID
                    if (decimal > 1) {
                        Toast.makeText(context, "Only one decimal point", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    Toast.makeText(context, "Only numbers for amount", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }

            //Else, is VALID
            return true;

        } else
            return false;
    }

    public static int transformToIcon(String string) {
        switch (string) {
            case "accessibility":
                return R.drawable.accessibility;
            case "baby":
                return R.drawable.baby;
            case "circle_person":
                return R.drawable.circle_person;
            case "person":
                return R.drawable.person;
            case "run":
                return R.drawable.run;
            case "face":
                return R.drawable.face;
            case "heart":
                return R.drawable.heart;
            case "fingerprint":
                return R.drawable.fingerprint;
            case "group":
                return R.drawable.group;
            case "bad":
                return R.drawable.bad;
            case "good":
                return R.drawable.good;
            case "nature":
                return R.drawable.nature;
            case "hand":
                return R.drawable.hand;
            case "pool":
                return R.drawable.pool;
            case "eye":
                return R.drawable.eye;
            case "pregnant":
                return R.drawable.pregnant;
            case "restaurant":
                return R.drawable.restaurant;
            case "airplane":
                return R.drawable.airplane;
            case "truck":
                return R.drawable.truck;
            case "truck1":
                return R.drawable.truck1;
            case "bike":
                return R.drawable.bike;
            case "boat":
                return R.drawable.boat;
            case "bus":
                return R.drawable.bus;
            case "train":
                return R.drawable.train;
            case "subway":
                return R.drawable.subway;
            case "taxi":
                return R.drawable.taxi;
            case "bank":
                return R.drawable.bank;
            case "beach":
                return R.drawable.beach;
            case "seat":
                return R.drawable.seat;
            case "gym":
                return R.drawable.gym;
            case "gavel":
                return R.drawable.gavel;
            case "healing":
                return R.drawable.healing;
            case "home":
                return R.drawable.home;
            case "hotel":
                return R.drawable.hotel;
            case "landscape":
                return R.drawable.landscape;
            case "bar":
                return R.drawable.bar;
            case "gas":
                return R.drawable.gas;
            case "library":
                return R.drawable.library;
            case "parking":
                return R.drawable.parking;
            case "world":
                return R.drawable.world;
            case "place":
                return R.drawable.place;
            case "school":
                return R.drawable.school;
            case "eshop":
                return R.drawable.eshop;
            case "shopping":
                return R.drawable.shopping;
            case "shopping1":
                return R.drawable.shopping1;
            case "store":
                return R.drawable.store;
            case "movies":
                return R.drawable.movies;
            case "brush":
                return R.drawable.brush;
            case "camera":
                return R.drawable.camera;
            case "tools":
                return R.drawable.tools;
            case "puzzle":
                return R.drawable.puzzle;
            case "flower":
                return R.drawable.flower;
            case "gamepad":
                return R.drawable.gamepad;
            case "golf":
                return R.drawable.golf;
            case "book":
                return R.drawable.book;
            case "cafe":
                return R.drawable.cafe;
            case "art":
                return R.drawable.art;
            case "pets":
                return R.drawable.pets;
            case "chat":
                return R.drawable.chat;
            case "row":
                return R.drawable.row;
            case "voice":
                return R.drawable.voice;
            case "smoke":
                return R.drawable.smoke;
            case "videocam":
                return R.drawable.videocam;
            case "vg":
                return R.drawable.vg;
            case "couch":
                return R.drawable.couch;
            case "work":
                return R.drawable.work;
            case "bookmark":
                return R.drawable.bookmark;
            case "bug":
                return R.drawable.bug;
            case "cake":
                return R.drawable.cake;
            case "call":
                return R.drawable.call;
            case "clock":
                return R.drawable.clock;
            case "currency":
                return R.drawable.currency;
            case "file":
                return R.drawable.file;
            case "moon":
                return R.drawable.moon;
            case "refresh":
                return R.drawable.refresh;
            case "task":
                return R.drawable.task;
            case "wallet":
                return R.drawable.wallet;
            case "laptop":
                return R.drawable.laptop;
            case "watch":
                return R.drawable.watch;
            case "scissors":
                return R.drawable.scissors;
            case "credit_card":
                return R.drawable.credit_card;
            case "trash":
                return R.drawable.trash;
            case "desktop":
                return R.drawable.desktop;
            case "dial":
                return R.drawable.dial;
            case "dns":
                return R.drawable.dns;
            case "email":
                return R.drawable.email;
            case "compass":
                return R.drawable.compass;
            case "streak":
                return R.drawable.streak;
            case "star":
                return R.drawable.star;
            case "headset":
                return R.drawable.headset;
            case "lock":
                return R.drawable.lock;
            case "drop":
                return R.drawable.drop;
            case "keyboard":
                return R.drawable.keyboard;
            case "kitchen":
                return R.drawable.kitchen;
            case "ticket":
                return R.drawable.ticket;
            case "car_wash":
                return R.drawable.car_wash;
            case "pizza":
                return R.drawable.pizza;
            case "bell":
                return R.drawable.bell;
            case "printer":
                return R.drawable.printer;
            case "room_service":
                return R.drawable.room_service;
            case "speaker":
                return R.drawable.speaker;
            case "mobile":
                return R.drawable.mobile;
            case "traffic":
                return R.drawable.traffic;
            case "translate":
                return R.drawable.translate;
            case "usb":
                return R.drawable.usb;
            case "bulbe1":
                return R.drawable.bulbe1;
            case "fire":
                return R.drawable.fire;
            default:
                return 0;

        }
    }

    public static String transformToColor(int color) {

        switch (color) {
            case 1:
                return "#FF5252";
            case 2:
                return "#FF4081";
            case 3:
                return "#E040FB";
            case 4:
                return "#7C4DFF";
            case 5:
                return "#448AFF";
            case 6:
                return "#64FFDA";
            case 7:
                return "#B2FF59";
            case 8:
                return "#FFFF00";
            case 9:
                return "#FFAB40";
            case 10:
                return "#E0E0E0";

            default:
                return null;
        }
    }

}
