package com.shivani.adminpanel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Item_Activity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinnerItemType;
    FloatingActionButton fab;
    TextView editBtn, nextBtn;
    Toolbar toolbar;
    private String itemName;
    ArrayList<String> arrayList;
    private static final int ADDITEM_REQUEST_CODE = 1;
    //String[] arraySpinnerItem = new String[]{"TV", "Refridgerator", "Washing Machine"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_);

        initView();
        initiationView();
        setListeners();

    }

    private void initView() {

        spinnerItemType = findViewById(R.id.spinnerItem);
        fab = findViewById(R.id.fab);
        editBtn = findViewById(R.id.editBtn);
        nextBtn = findViewById(R.id.nextBtn);
        toolbar = findViewById(R.id.toolbarItem);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void initiationView() {

        arrayList = new ArrayList<>();

        arrayList.add("Available Items List");

        ArrayAdapter<String> spinner1Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        spinner1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItemType.setAdapter(spinner1Adapter);

    }

    private void setListeners() {

        fab.setOnClickListener(this);
        editBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id){

            case R.id.fab:{
                Intent intent = new Intent(this, AddItemActivity.class);
                startActivityForResult(intent,1);

            }
            case R.id.editBtn:{
                Intent intent = new Intent(this, AddItemActivity.class);
                startActivity(intent);

            }

            case R.id.nextBtn:{
//                Intent intent = new Intent(this, Item_Activity.class);
//                startActivity(intent);

            }
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == ADDITEM_REQUEST_CODE ) {

            if (resultCode == Activity.RESULT_OK) {
                itemName = data.getStringExtra("name");
                System.out.println(">>>>>>>>>>. item intent data" + itemName);

            }

                //startActivity(new Intent(Intent.ACTION_VIEW, data));
            }
        else {
                // Toast.makeText(this,"Item Data Not Found",Toast.LENGTH_SHORT).show();
                System.out.println(">>>>>>>>>>. item intent data not found");
        }
        arrayList.add(itemName);
        super.onActivityResult(requestCode, resultCode, data);


    }
}
