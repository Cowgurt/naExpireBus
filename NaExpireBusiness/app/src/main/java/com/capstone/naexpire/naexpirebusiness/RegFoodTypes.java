package com.capstone.naexpire.naexpirebusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class RegFoodTypes extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_food_types);

        setTitle("Types of Food Served"); //set activity title

        String[] types = {"Mexican", "Itialian", "Indian", "Cajun", "Thai", "Greek",
                "Chinese", "Lebanese", "Japanese", "Mediterranean", "French", "Korean",
                "Vietnamese", "Caribbean"};

        //generate list view for arraylist
        for(int i = 0; i < types.length; i++){
            list.add(types[i]);
        }

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);

        ListView listView = (ListView) findViewById(R.id.lstFoodType);
        listView.setAdapter(adapter);

    }

    public void clickNewFood(View view){
        EditText newFood = (EditText) findViewById(R.id.txtNewFood);
        String nFood = newFood.getText().toString();
        if(nFood.length() != 0){
            list.add(nFood.toLowerCase());
            adapter.notifyDataSetChanged();
        }
    }
}
