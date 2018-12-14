package com.example.mrlam.thuchanh;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.zip.Inflater;

public class Lab2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.clear:
                AlertDialog.Builder message = new AlertDialog.Builder(this);
                message.setTitle(R.string.message_caption);
                message.setMessage(R.string.message_content);
                message.setNegativeButton(R.string.yes, new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText et=(EditText)findViewById(R.id.Edittext1);
                                et.setText("");
                            }
                        }
                ).show();
                break;

            case R.id.setting:
                Intent intent=new Intent(this,Lab2_1.class);
                final int result=1;
                startActivityForResult(intent,result);
                break;

            case R.id.exit:
                AlertDialog.Builder message1=new AlertDialog.Builder(this);
                message1.setTitle(R.string.message_caption);
                message1.setMessage(R.string.message1_content);

                message1.setNegativeButton(R.string.yes, new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }
                );

                message1.setPositiveButton(R.string.no, new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        }
                ).show();

                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Bundle bundle=data.getExtras();
        int index1=bundle.getInt("mauchu");
        int index2=bundle.getInt("maunen");
        int index3=bundle.getInt("TextSize");

        String colorArray[]=getResources().getStringArray(R.array.listColorArray);
        String textSide[]=getResources().getStringArray(R.array.list_size);

        EditText et=(EditText)findViewById(R.id.Edittext1);

        et.setTextColor(Color.parseColor(colorArray[index1]));
        et.setBackgroundColor(Color.parseColor(colorArray[index2]));
        et.setTextSize(Float.parseFloat(textSide[index3]));
    }

    }

