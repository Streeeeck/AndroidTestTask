package com.example.androidtesttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etwater;
    EditText eteditwater;
    String str;
    float water;
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etwater = (EditText) findViewById(R.id.editTextNumber);
        eteditwater = (EditText) findViewById(R.id.editTextNumber2);
        myPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        myEditor = myPreferences.edit();

        loadWater();

    }

    public void onClickIncrement(View view){
        water++;
        etwater.setText(Float.toString(water));
        saveWater();
    }
    public void onClickPlus(View view){
        String s = eteditwater.getText().toString();
        if (s.equals("")) return;
        water += Float.parseFloat(s);
        viewWater();
        saveWater();
        eteditwater.setText("");
    }
    public void onClickMinus(View view){
        String s = eteditwater.getText().toString();
        if (s.equals("")) return;
        water -= Float.parseFloat(s);
        if(water < 0) water = 0;
        viewWater();
        saveWater();
        eteditwater.setText("");
    }

    protected void saveWater(){
        myEditor.putFloat("Water", water);
        myEditor.commit();

    }

    protected void loadWater(){
        water = myPreferences.getFloat("Water", 0);
        viewWater();
    }
    protected void viewWater(){
        etwater.setText(Float.toString(water));
    }



}
