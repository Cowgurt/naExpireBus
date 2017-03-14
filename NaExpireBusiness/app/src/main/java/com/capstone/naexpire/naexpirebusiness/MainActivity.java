package com.capstone.naexpire.naexpirebusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickLogin(View view){
        Intent intent = new Intent(this, NavDrawer.class);
        startActivity(intent);
    }

    public void clickRegister(View view){
        Intent intent = new Intent(this, RegRestrauntInfo.class);
        startActivity(intent);
    }
}
