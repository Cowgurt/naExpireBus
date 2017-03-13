package com.capstone.naexpire.naexpirebusiness;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegFoodTypes extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> selected = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_food_types);

        setTitle("Types of Food Served"); //set activity title

        //food types for testing
        String[] types = {"Mexican", "Italian", "Indian", "Cajun", "Thai", "Greek",
                "Chinese", "Lebanese", "Japanese", "Mediterranean", "French", "Korean",
                "Vietnamese", "Caribbean"};

        //generate list view for arraylist
        for(int i = 0; i < types.length; i++){
            list.add(types[i]);
        }

        //set layout & data for the list's adapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        final ListView listView = (ListView) findViewById(R.id.lstFoodType);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //gets text of selected element
                String sel = listView.getItemAtPosition(position).toString();
                if(isIn(sel)){ //deselect if tapped when selected
                    parent.getChildAt(position).setBackgroundColor(Color.TRANSPARENT);
                    selected.remove(sel); //remove from list of selected food types
                }
                else{ //select if tapped when deselected
                    //change background color to accent color
                    parent.getChildAt(position).setBackgroundColor(Color.argb(255,255,64,129));
                    selected.add(sel); //add to list of selected food types
                }
                /*String s = "";
                for(int i = 0; i < selected.size(); i++){
                    s += selected.get(i)+" ";
                }
                Toast toast = Toast.makeText(getApplicationContext(), position + "selected: " + s, Toast.LENGTH_SHORT);
                toast.show();*/
            }
        });
    }

    public Boolean isIn(String food){
        for(int i = 0; i < selected.size(); i++){
            if (food.equals(selected.get(i))) return true;
        }
        return false;
    }

    public void clickNewFood(View view){
        EditText newFood = (EditText) findViewById(R.id.txtNewFood);
        String nFood = newFood.getText().toString();
        if(nFood.length() != 0){ //if food type string is not empty
            list.add(nFood); //add the food type to the arraylist
            adapter.notifyDataSetChanged(); //redraw the list on the screen
            newFood.setText("");
            Toast toast = Toast.makeText(getApplicationContext(), nFood+" added", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
