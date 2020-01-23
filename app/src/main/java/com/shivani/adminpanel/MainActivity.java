package com.shivani.adminpanel;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private LinearLayout linearLayoutItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initializeView();
        setListeners();



//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


    }



    private void initializeView() {
        toggle = new ActionBarDrawerToggle(this, drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

     private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         drawer = findViewById(R.id.drawer_layout);
         navigationView = findViewById(R.id.nav_view);
         linearLayoutItem = findViewById(R.id.itemLayout);

    }
    private void setListeners() {
        navigationView.setNavigationItemSelectedListener(this);
        linearLayoutItem.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//       // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();
        switch (id){
            case R.id.nav_home:{
                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_gallery:{
                Toast.makeText(this,"Gallery",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_slideshow:{
                Toast.makeText(this,"Slideshow",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_tools:{
                Toast.makeText(this,"Tools",Toast.LENGTH_SHORT).show();
                break;
            }
        }


        return true;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id){

            case R.id.itemLayout:{
                Intent intent = new Intent(this, Item_Activity.class);
                startActivity(intent);
            }

        }
    }
}
