package com.example.mrlam.thuchanh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lab3_2 extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTen,tvGia,tvTang;
    private Button btnOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_2);
        tvTen=(TextView)findViewById(R.id.tvTenphong);
        tvGia=(TextView)findViewById(R.id.tvGia);
        tvTang=(TextView)findViewById(R.id.tvTang);

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("datphong");

        tvTen.setText("Phòng: "+bundle.getString("ten"));
        tvGia.setText("Giá: "+bundle.getString("gia"));
        tvTang.setText("Tầng: "+bundle.getString("tang"));

        btnOK=(Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnOK.getId()){
            finish();
        }
    }
}
