package com.example.mrlam.thuchanh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lab3 extends AppCompatActivity implements View.OnClickListener {

    Button btnReserve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);

        btnReserve=(Button)findViewById(R.id.btnReserve);
        btnReserve.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnReserve.getId()){
            Intent intent=new Intent(this,Lab3_1.class);
            startActivity(intent);
        }
    }
}
