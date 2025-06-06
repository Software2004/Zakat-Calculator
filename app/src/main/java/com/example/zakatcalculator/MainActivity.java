package com.example.zakatcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView editCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editCard = findViewById(R.id.cardView2);
        SharedPreferences preferences = getSharedPreferences("prices",MODE_PRIVATE);
        boolean isSaved = preferences.getBoolean("isSaved",false);
        findViewById(R.id.cardView).setOnClickListener(view -> {

            if(isSaved){
                Intent calIntent = new Intent(MainActivity.this,Calculation.class);
                calIntent.putExtra("gold",preferences.getString("gold","0"));
                calIntent.putExtra("silver",preferences.getString("silver","0"));
                calIntent.putExtra("property",preferences.getString("property","0"));
                startActivity(calIntent);
            }
            else{
                startActivity(new Intent(MainActivity.this,PriceDetails.class));
            }
        });
        if (isSaved){
            editCard.setVisibility(View.VISIBLE);
        }else {
            editCard.setVisibility(View.INVISIBLE);
        }
        editCard.setOnClickListener(view -> {
            Intent calIntent = new Intent(MainActivity.this,PriceDetails.class);
            calIntent.putExtra("gold",preferences.getString("gold","0"));
            calIntent.putExtra("silver",preferences.getString("silver","0"));
            calIntent.putExtra("property",preferences.getString("property","0"));
            startActivity(calIntent);
        });

    }
}