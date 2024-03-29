package com.example.oppari02;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);  /* Pikkunäppäin näytön alanurkassa (s-posti tms.) */
        fab.setOnClickListener(view ->
                Snackbar.make(view, "Tähän jotain tekstiä joka tulee kun painaa alareunan Email-kuvaketta", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        View m = findViewById(R.id.textView);   //nämä kaksi laittaa sisällön/tekstin näkyvyyden
        m.setVisibility(View.VISIBLE);

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                launchMainActivity();
                break;
            case R.id.nav_temperature:
                launchTemperatureActivity();
                break;
            case R.id.nav_humidity:
                launchHumidityActivity();
                break;
            case R.id.nav_airPressure:
                launchAirPressureActivity();
                break;
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void launchMainActivity() {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    private void launchTemperatureActivity() {
        Intent temperature = new Intent(this, temperatureActivity.class);
        startActivity(temperature);
    }

    private void launchHumidityActivity() {
        Intent humidity = new Intent(this, humidityActivity.class);
        startActivity(humidity);
    }

    private void launchAirPressureActivity() {
        Intent airPressure = new Intent(this, airPressureActivity.class);
        startActivity(airPressure);
    }
}