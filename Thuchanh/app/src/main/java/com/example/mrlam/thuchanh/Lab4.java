package com.example.mrlam.thuchanh;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class Lab4 extends Activity implements View.OnClickListener {

    private TextView tvTitle,tvAddr;
    private Restaurant r=new Restaurant("","","");
    private List<Restaurant> restaurantList=new ArrayList<Restaurant>();
    private ArrayAdapter adapter=null;
    private Button btnSave;
    private EditText etName,etAddress;
    private RadioGroup rgTypes;
    private ListView lvRes;
    private ImageView ivRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);

        Anhxa();

        restaurantList.add(new Restaurant("Lam","123","Take out"));
        restaurantList.add(new Restaurant("phu","234","Sit down"));

        btnSave.setOnClickListener(this);

        adapter=new RestaurantAdapter();
        lvRes.setAdapter(adapter);

    }

    private void Anhxa(){
        btnSave=(Button)findViewById(R.id.btnSave);
        etName=(EditText) findViewById(R.id.etName);
        etAddress=(EditText) findViewById(R.id.etAddress);
        rgTypes=(RadioGroup)findViewById(R.id.rgTypes);
        lvRes=(ListView)findViewById(R.id.lstRes);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnSave.getId()){
            String name=etName.getText().toString();
            String address=etAddress.getText().toString();
            r.setName(name);
            r.setAddress(address);
            switch (rgTypes.getCheckedRadioButtonId()){
                case R.id.rdTakeout:
                    r.setType("Take out");
                    break;
                case R.id.rdSitdown:
                    r.setType("Sit down");
                    break;
                case R.id.rdDelivery:
                    r.setType("Delivery");
                    break;
            }
            restaurantList.add(r);
        }
        Toast.makeText(this, "Đã lưu", Toast.LENGTH_SHORT).show();
    }

    class RestaurantAdapter extends ArrayAdapter<Restaurant>{

        public RestaurantAdapter(@NonNull Context context, int resource, int textViewResourceId) {
            super(context, resource, textViewResourceId);
        }

        public RestaurantAdapter(){
            super(Lab4.this,android.R.layout.simple_list_item_1,restaurantList);
        }

        @Override
        public View getView(int pos,View convertView,ViewGroup parent){
            View List_Item=convertView;
            if(List_Item==null){
                List_Item=getLayoutInflater().inflate(R.layout.row,parent,false);
            }
            Restaurant restaurant=restaurantList.get(pos);
            tvTitle=(TextView)List_Item.findViewById(R.id.tvTitle);
            tvAddr=(TextView)List_Item.findViewById(R.id.tvAddr);
            ivRes=(ImageView)List_Item.findViewById(R.id.ivRes);
            if(restaurant.getType().toString()=="Take out")
                ivRes.setImageResource(R.drawable.type_t);
            else
            if(restaurant.getType().toString()=="Sit down")
                ivRes.setImageResource(R.drawable.type_s);
            else
            if(restaurant.getType().toString()=="Delivery")
                ivRes.setImageResource(R.drawable.type_d);
            tvTitle.setText(restaurant.getName());
            tvAddr.setText(restaurant.getAddress());
            return List_Item;
        }
    }
}




