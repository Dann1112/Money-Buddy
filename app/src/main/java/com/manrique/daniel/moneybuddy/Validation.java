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
}
