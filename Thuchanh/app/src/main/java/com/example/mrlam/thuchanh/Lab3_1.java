package com.example.mrlam.thuchanh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Lab3_1 extends AppCompatActivity implements View.OnClickListener {
    private Button btDat;
    private EditText etTen,etGia,etTang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_1);
        btDat=(Button)findViewById(R.id.btDat);
        btDat.setOnClickListener(this);
        etTen=(EditText)findViewById(R.id.etTen);
        etGia=(EditText)findViewById(R.id.etGia);
        etTang=(EditText)findViewById(R.id.etTang);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btDat.getId()){
            Intent intent=new Intent(this,Lab3_2.class);
            Bundle bundle=new Bundle();

            bundle.putString("ten",etTen.getText().toString());
            bundle.putString("gia",etGia.getText().toString());
            bundle.putString("tang",etTang.getText().toString());

            intent.putExtra("datphong",bundle);
            startActivity(intent);
        }
    }
}
