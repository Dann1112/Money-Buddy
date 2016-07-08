package com.manrique.daniel.moneybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewCatDialog extends DialogFragment implements View.OnClickListener {
    Button cancelBtn, confirmBtn, color;
    EditText descriptionEdTxt, amountEdTxt;
    ImageView icon;


    public NewCatDialog() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_cat_dialog, null);
        confirmBtn = (Button) view.findViewById(R.id.confirm_new_category_button);
        cancelBtn = (Button) view.findViewById(R.id.cancel_new_category_button);
        icon = (ImageView) view.findViewById(R.id.category_icon);
        color = (Button) view.findViewById(R.id.category_color);

        descriptionEdTxt = (EditText) view.findViewById(R.id.set_description);

        confirmBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        icon.setOnClickListener(this);
        color.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.confirm_new_category_button:
                Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                dismiss();
                break;

            case R.id.cancel_new_category_button:
                Toast.makeText(getContext(), "Cancel", Toast.LENGTH_SHORT).show();
                dismiss();
                break;

            case R.id.category_icon:
                Toast.makeText(getContext(), "Icon", Toast.LENGTH_SHORT).show();
                dismiss();
                break;

            case R.id.category_color:
                Toast.makeText(getContext(), "Color", Toast.LENGTH_SHORT).show();
                dismiss();
                break;

            default:
                break;

        }

    }


}
