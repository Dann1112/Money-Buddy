package com.manrique.daniel.moneybuddy.UI;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.manrique.daniel.moneybuddy.Database.DatabaseContract;
import com.manrique.daniel.moneybuddy.Database.DatabaseOpenHelper;
import com.manrique.daniel.moneybuddy.R;
import com.manrique.daniel.moneybuddy.Validation;

public class NewItemDialog extends DialogFragment implements View.OnClickListener {


    private int origin;
    private Button cancelBtn, confirmBtn;
    private EditText descriptionEdTxt, amountEdTxt;
    private String date;


    public NewItemDialog() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle;


        bundle = this.getArguments();
        origin = bundle.getInt("origin");
        date = bundle.getString("date");

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
            if (Validation.validateAlpha(getContext(), descriptionEdTxt, "Item Name") &&
                    Validation.validateNumber(getContext(), amountEdTxt, "Amount")) {

                SQLiteDatabase db = new DatabaseOpenHelper(this.getContext()).getWritableDatabase();
                ContentValues testValues = new ContentValues();
                testValues.put(DatabaseContract.Income.COLUMN_NAME_DATE, date);
                testValues.put(DatabaseContract.Income.COLUMN_NAME_DESCRIPTION,
                        String.valueOf(descriptionEdTxt.getText()));
                testValues.put(DatabaseContract.Income.COLUMN_NAME_AMOUNT,
                        String.valueOf(amountEdTxt.getText()));

                try{
                    db.insert(DatabaseContract.Income.TABLE_NAME, null, testValues);
                    Toast.makeText(this.getContext(), "NAILED IT", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(this.getContext(),"Impossible",Toast.LENGTH_SHORT).show();
                }


                //AQUI SE CARGA INFORMACION A BASE DE DATOS DEPENDIENDO DEL VALOR
                //QUE TENGA origin, PARA SABER EN QUE TABLA SE VA A GUARDAR
                // 1 = NEW_INCOME    2 = NEW_EXPENSE
                dismiss();
            }

        } else if (view == cancelBtn) {
            dismiss();
        }
    }

}
