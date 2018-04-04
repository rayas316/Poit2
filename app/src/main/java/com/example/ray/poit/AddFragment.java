package com.example.ray.poit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.example.ray.poit.MainActivity.REQUEST_CODE_CAMERA;


public class AddFragment extends Fragment {
    ImageView imageView;

    public static AddFragment newInstance() {
        AddFragment frag = new AddFragment();
        return frag;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add,container,false);
        imageView = (ImageView)view.findViewById(R.id.imageView1);


        return inflater.inflate(R.layout.fragment_add, container, false);
    }



}
