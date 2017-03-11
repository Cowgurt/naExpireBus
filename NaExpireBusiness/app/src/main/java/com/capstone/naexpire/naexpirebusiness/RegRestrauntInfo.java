package com.capstone.naexpire.naexpirebusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegRestrauntInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_restraunt_info);
        setTitle("Register"); //set activity title
    }

    public void clickNext(View view){
        Intent intent = new Intent(this, RegFoodTypes.class);
        startActivity(intent);
    }
}
