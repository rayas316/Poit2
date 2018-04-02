package com.example.ray.poit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    BottomBarAdapter pagerAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        viewPager=(ViewPager)findViewById(R.id.navigation);
        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());
        pagerAdapter.addFragments(ShareFragment.newInstance("fragment1","share"));
        pagerAdapter.addFragments(AddFragment.newInstance("fragment2","add"));
        pagerAdapter.addFragments(GalleryFragment.newInstance("fragment3","gallery"));
        pagerAdapter.addFragments(ProfileFragment.newInstance("fragment4","profile"));
        viewPager.setAdapter(pagerAdapter);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_share:
                        viewPager.setCurrentItem(0);
                        Log.d("押したボタン","sharebutton");
                        Toast.makeText(getApplicationContext(),"sharebutton",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_gallery:
                        viewPager.setCurrentItem(1);
                        Log.d("押したボタン","gallelybutton");
                        Toast.makeText(getApplicationContext(),"gallerybutton",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_profile:
                        viewPager.setCurrentItem(2);
                        Log.d("押したボタン","profilebutton");
                        Toast.makeText(getApplicationContext(),"profilebutton",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_add:
                        viewPager.setCurrentItem(3);
                        Log.d("押したボタン","addbutton");
                        Toast.makeText(getApplicationContext(), "addbutton", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

}
