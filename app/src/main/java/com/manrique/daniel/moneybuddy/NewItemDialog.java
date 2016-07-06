package com.manrique.daniel.moneybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewItemDialog extends DialogFragment implements View.OnClickListener {

    Button cancelBtn, confirmBtn;
    EditText descriptionEdTxt, amountEdTxt;


    public NewItemDialog() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.new_item_dialog, null);
        confirmBtn = (Button) view.findViewById(R.id.confirm_new_item_button);
        cancelBtn = (Button) view.findViewById(R.id.cancel_new_item_button);

        descriptionEdTxt = (EditText) view.findViewById(R.id.set_description);
        amountEdTxt = (EditText) view.findViewById(R.id.set_amount);

        confirmBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {
        if (view == confirmBtn) {
            Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
            dismiss();
        } else if (view == cancelBtn) {
            Toast.makeText(getContext(), "Cancel", Toast.LENGTH_SHORT).show();
            dismiss();
        }
    }


}
