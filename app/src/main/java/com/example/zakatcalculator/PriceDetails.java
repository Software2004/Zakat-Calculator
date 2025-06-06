package com.example.zakatcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class PriceDetails extends AppCompatActivity {

    EditText goldPrice, silverPrice, propertyPrice;
    CheckBox saveBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_details);
        goldPrice = findViewById(R.id.etgoldprice);
        silverPrice = findViewById(R.id.etsilverprice);
        propertyPrice = findViewById(R.id.etmarlaprice);
        saveBox = findViewById(R.id.chbox);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            goldPrice.setText(bundle.getString("gold"));
            silverPrice.setText(bundle.getString("silver"));
            propertyPrice.setText(bundle.getString("property"));
        }

        findViewById(R.id.llsearch).setOnClickListener(view -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=gold+rate+in+pakistan+today"))));

        findViewById(R.id.btnNext).setOnClickListener(view -> {
            if(allFieldsCorrect()){
                if(saveBox.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("prices",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putBoolean("isSaved",true);
                    editor.putString("gold",goldPrice.getText().toString());
                    editor.putString("silver",silverPrice.getText().toString());
                    editor.putString("property",propertyPrice.getText().toString());
                    editor.apply();
                }
                Intent calIntent = new Intent(PriceDetails.this,Calculation.class);
                    calIntent.putExtra("gold",goldPrice.getText().toString());
                    calIntent.putExtra("silver",silverPrice.getText().toString());
                    calIntent.putExtra("property",propertyPrice.getText().toString());
                startActivity(calIntent);
                finish();
            }
        });


    }

    private boolean allFieldsCorrect() {
        String goldPriceD = (goldPrice.getText().toString());
        String silverPriceD = (silverPrice.getText().toString());
        String propertyPriceD = (propertyPrice.getText().toString());
        if (goldPriceD.isEmpty()){
            goldPrice.setError("Gold price is required!");
            goldPrice.requestFocus();
        }
        else if (Double.parseDouble(goldPriceD)<1){
            goldPrice.setError("Invalid price!");
            goldPrice.requestFocus();
        }
        else if (silverPriceD.isEmpty()){
            silverPrice.setError("Silver price is required!");
            silverPrice.requestFocus();
        }
        else if (Double.parseDouble(silverPriceD)<1){
            silverPrice.setError("Invalid price!");
            silverPrice.requestFocus();
        }
        else if (propertyPriceD.isEmpty()){
            propertyPrice.setError("Property price is required!");
            propertyPrice.requestFocus();
        }
        else if (Double.parseDouble(propertyPriceD)<1){
            propertyPrice.setError("Invalid price!");
            propertyPrice.requestFocus();
        }
        else
            return true;

        return false;
    }
}