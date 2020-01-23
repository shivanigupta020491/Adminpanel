package com.shivani.adminpanel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddItemActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private EditText itemName;
//    private EditText itemDesc;
    private Button addItem;
    String name, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        initView();
        initializationView();
        setListeners();

    }



    private void initView(){

        toolbar = findViewById(R.id.toolbarAddItem);
        itemName = findViewById(R.id.itemEditText);
        //itemDesc = findViewById(R.id.descEditText);
        addItem = findViewById(R.id.addItemBtn);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initializationView() {


        //desc = itemDesc.getText().toString();
    }

    private void setListeners() {
        addItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        name = itemName.getText().toString();
        switch (id){

            case R.id.addItemBtn:{

                Intent returnIntent = new Intent();
                returnIntent.putExtra("name",name);
                //returnIntent.putExtra("desc",desc);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        }
    }
}
