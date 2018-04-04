package com.example.ray.poit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    BottomBarAdapter pagerAdapter;
    ViewPager viewPager;
    static final int REQUEST_CODE_CAMERA = 1;
    String message;
    String message2;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        viewPager = (ViewPager) findViewById(R.id.view);
        pagerAdapter = new BottomBarAdapter(getSupportFragmentManager());
        pagerAdapter.addFragments(ShareFragment.newInstance());
        pagerAdapter.addFragments(GalleryFragment.newInstance());
        pagerAdapter.addFragments(AddFragment.newInstance());
        pagerAdapter.addFragments(ProfileFragment.newInstance());
        viewPager.setAdapter(pagerAdapter);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_share:
                        viewPager.setCurrentItem(0);
                        Log.d("押したボタン", "sharebutton");
                        Toast.makeText(getApplicationContext(), "sharebutton", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_gallery:
                        viewPager.setCurrentItem(1);
                        Log.d("押したボタン", "gallelybutton");
                        Toast.makeText(getApplicationContext(), "gallerybutton", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_add:
                        viewPager.setCurrentItem(2);
                        Log.d("押したボタン", "addbutton");
                        Toast.makeText(getApplicationContext(), "addbutton", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_profile:
                        viewPager.setCurrentItem(3);
                        Log.d("押したボタン", "profilebutton");
                        Toast.makeText(getApplicationContext(), "profilebutton", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });



    }


    public void send(View v){
        editText = (EditText)findViewById(R.id.editText);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        message = editText.getText().toString();
        intent.setData(Uri.parse("line://msg/text/" + message));
        startActivity(intent);
    }

    public void send2(View v){
        editText2 = (EditText)findViewById(R.id.editText2);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        message2 = editText2.getText().toString();
        intent.setData(Uri.parse("twitter://post?message=" + message2));
        startActivity(intent);
    }

    public void capture(View v) {
        //AddFragment aaa = (AddFragment) pagerAdapter.getItem(2);
        //aaa.setBitmap();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == RESULT_OK) {

            if(requestCode == REQUEST_CODE_CAMERA){
                Uri uri = null;
                if (intent != null) {
                    uri = intent.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        AddFragment test = (AddFragment) pagerAdapter.getItem(2);
                        test.imageView.setImageBitmap(bitmap);
                        //imageView.setImageBitmap(bitmap);
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(requestCode == RESULT_CANCELED){
                Toast.makeText(MainActivity.this,"キャンセル",Toast.LENGTH_SHORT).show();
            }
        }
    }
}