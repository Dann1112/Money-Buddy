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
            if (validate(descriptionEdTxt, amountEdTxt)) {
                Toast.makeText(getContext(), descriptionEdTxt.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), amountEdTxt.getText(), Toast.LENGTH_SHORT).show();
                dismiss();
            }

        } else if (view == cancelBtn) {
            Toast.makeText(getContext(), "Cancel", Toast.LENGTH_SHORT).show();
            dismiss();
        }
    }

    private boolean validate(EditText desc, EditText amount) {
        String text;
        int decimal = 0;
        if (desc != null) {
            text = String.valueOf(desc.getText());

            if (text.equals("") || text.isEmpty()) {
                Toast.makeText(getContext(), "Set the description", Toast.LENGTH_SHORT).show();
                return false;
            }

            for (char c : text.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    Toast.makeText(getContext(), "Only letters or numbers for description", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }

            text = String.valueOf(amount.getText());

            if (text.equals("") || text.isEmpty()) {
                Toast.makeText(getContext(), "Set the amount", Toast.LENGTH_SHORT).show();
                return false;
            }


            return true;

        } else
            return false;

    }


}
