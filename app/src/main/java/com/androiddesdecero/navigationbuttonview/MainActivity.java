package com.androiddesdecero.navigationbuttonview;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private Option1Fragment option1Fragment;
    private Option2Fragment option2Fragment;
    private Option3Fragment option3Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        option1Fragment = new Option1Fragment();
        option2Fragment = new Option2Fragment();
        option3Fragment = new Option3Fragment();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        setFragment(option1Fragment);
        bottomNavigationView.setSelectedItemId(R.id.option1);
        setTitle("Option 1");

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.option1:
                        setTitle("Option 1");
                        bottomNavigationView.setItemBackgroundResource(R.color.colorOrange);
                        setFragment(option1Fragment);
                        return true;
                    case R.id.option2:
                        setTitle("Option 2");
                        bottomNavigationView.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(option2Fragment);
                        return true;
                    case R.id.option3:
                        setTitle("Option 3");
                        bottomNavigationView.setItemBackgroundResource(R.color.colorGreen);
                        setFragment(option3Fragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
