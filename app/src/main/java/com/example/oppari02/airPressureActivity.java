package com.example.oppari02;

import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class airPressureActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener

{
    @Override
    protected void onStart () {
        super.onStart();
        setContentView(R.layout.not_bad_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}