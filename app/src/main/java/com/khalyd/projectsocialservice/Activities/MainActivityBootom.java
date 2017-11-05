package com.khalyd.projectsocialservice.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.khalyd.projectsocialservice.Fragments.FragmentDirectory;
import com.khalyd.projectsocialservice.Fragments.FragmentFBTW;
import com.khalyd.projectsocialservice.Fragments.FragmentOption1;
import com.khalyd.projectsocialservice.R;

public class MainActivityBootom extends AppCompatActivity {



      private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();

                        switch (item.getItemId()) {

                            case R.id.directory:
                                ft.replace(R.id.content, new FragmentDirectory()).commit();
                                return true;

                            case R.id.news:
                                ft.replace(R.id.content, new FragmentFBTW()).commit();
                                return true;
                            case R.id.option:
                                ft.replace(R.id.content, new FragmentOption1()).commit();
                                return true;
                        }
                        return true;
                    }

                };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.content, new FragmentDirectory()).commit();

        setContentView(R.layout.activity_main_bootom);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }



}
