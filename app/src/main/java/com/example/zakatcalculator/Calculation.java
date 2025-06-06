package com.example.zakatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Calculation extends AppCompatActivity {

    EditText gold, silver, property;
    TextView tv;
    Double goldValue,silverValue,propertyValue;
    Dialog dialogAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        gold = findViewById(R.id.etgold);
        silver = findViewById(R.id.etsilver);
        property = findViewById(R.id.etproperty);
        tv =  findViewById(R.id.tvzkat);
        gold.requestFocus();

        findViewById(R.id.ivback).setOnClickListener(view -> {
            finish();
        });
        findViewById(R.id.btnClear).setOnClickListener(view -> {
            clearFields();
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            goldValue = Double.parseDouble(bundle.getString("gold","0.00"));
            silverValue = Double.parseDouble(bundle.getString("silver","0.00"));
            propertyValue = Double.parseDouble(bundle.getString("property","0.00"));
        }
        findViewById(R.id.btnCalc).setOnClickListener(view -> {
            if(allFieldsCorrect()){
                double goldD = Double.parseDouble(gold.getText().toString());
                double silverD = Double.parseDouble(silver.getText().toString());

                if ((goldD)>=7.5 || (silverD)>=52.5 || isProperty()){
                    double totalGold = goldD * goldValue;
                    double totalSil = silverD * silverValue;
                    double totalProp = Double.parseDouble((property.getText().toString())) * propertyValue;
                    double moneyTotal = totalGold + totalSil + totalProp;
                    double totalZakat = (moneyTotal*2.5)/100;
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    dialogAction(formatter.format(totalZakat));
                }
                else{
                    dialogAction("");
                }
            }
        });
    }

    private void clearFields(){
        gold.setText("");
        silver.setText("");
        property.setText("");
        gold.requestFocus();
    }
    private boolean isProperty() {
        double propertyD = Double.parseDouble((property.getText().toString())) * propertyValue;
            if((propertyD >= goldValue*7.5))
                return true;
        return false;
    }

    private boolean allFieldsCorrect() {
        String goldPriceD = (gold.getText().toString());
        String silverPriceD = (silver.getText().toString());
        String propertyPriceD = (property.getText().toString());
        if (goldPriceD.isEmpty()){
            gold.setError("Required!");
            gold.requestFocus();
        }
        else if (silverPriceD.isEmpty()){
            silver.setError("Required!");
            silver.requestFocus();
        }

        else if (propertyPriceD.isEmpty()){
            property.setError("Required!");
            property.requestFocus();
        }
        else
            return true;

        return false;
    }
    private void dialogAction(String rslt){
        dialogAction = new Dialog(Calculation.this);
        dialogAction.setContentView(R.layout.result_dialog);
        dialogAction.setCancelable(false);
        dialogAction.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialogAction.findViewById(R.id.btnCancel).setOnClickListener(view -> dialogAction.dismiss());
        dialogAction.findViewById(R.id.btnDone).setOnClickListener(view -> dialogAction.dismiss());

        TextView tvEligible = dialogAction.findViewById(R.id.txtEligible);
        TextView tvZakat = dialogAction.findViewById(R.id.txtZakat);
        if (!rslt.isEmpty()){
            tvEligible.setText("You are eligible.");
            tvZakat.setText("Rs. " + rslt + "/-");
        }
        dialogAction.show();
    }
}