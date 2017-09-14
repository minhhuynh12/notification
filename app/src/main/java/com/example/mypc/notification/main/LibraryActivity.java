package com.example.mypc.notification.main;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mypc.notification.FragmentInteraction;
import com.example.mypc.notification.R;

import extras.Enumes;
import fragment.BaseFragment;
import fragment.FragmentDownload;
import fragment.FragmentHot;
import fragment.FragmentType;

/**
 * Created by MyPC on 11/09/2017.
 */

public class LibraryActivity extends AppCompatActivity implements FragmentInteraction {
    Fragment frag;
    android.support.v4.app.FragmentTransaction transaction;
    TextView tvTaive;
    TextView tvLishsu;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity);
        tvTaive = (TextView) findViewById(R.id.tvTaive);
        tvLishsu = (TextView) findViewById(R.id.tvLishsu);

        frag = new FragmentHot();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameMain, frag);
        transaction.commit();


        tvTaive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag = new FragmentDownload();
                transaction = getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, frag);
                transaction.commit();
            }
        });
        tvLishsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag = new FragmentHot();
                transaction = getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, frag);
                transaction.commit();

            }
        });
    }



    @Override
    public void openFragmnet(Enumes.FragmentType fragmentType, Bundle bundle, Enumes.Direction direction) {
        Fragment fragment = null;
        switch (fragmentType){
            case FRAGMENT_DOWNLOAD:
                fragment = new FragmentDownload();
                break;
            case FRAGMENT_HOT:
                fragment = new FragmentHot();
                break;
            case FRAGMENT_TYPE:
                fragment = new FragmentType();
                break;
        }

        FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();

        switch (direction){
            case RIGHT_IN:
                transaction.setCustomAnimations(R.anim.enter_from_top , R.anim.exit_to_bottom);
                break;
        }


        if (bundle != null && bundle.size() > 0) {
            fragment.setArguments(bundle);
        }


        String tagName = fragmentType.toString();

        transaction.replace(R.id.frameMain , fragment ,tagName);
        transaction.commit();
    }

    
}
