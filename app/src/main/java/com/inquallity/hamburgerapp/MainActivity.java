package com.inquallity.hamburgerapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * @author Maxim Radko on 04.11.2017.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mActionBarToggle;
    private NavigationView mNavigationView;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment targetFragment;
        switch (item.getItemId()) {
            case R.id.m1:
                targetFragment = new PageOneFragment();
                break;
            case R.id.m2:
                targetFragment = new PageTwoFragment();
                break;
            case R.id.m3:
                targetFragment = new PageThreeFragment();
                break;
            default:
                targetFragment = null;
                break;
        }
        if (targetFragment != null) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.content, targetFragment)
                    .commit();
        }
        mDrawerLayout.closeDrawers();
        return targetFragment != null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToolbar = findViewById(R.id.toolbar);
        mNavigationView = findViewById(R.id.navigation_view);

        setSupportActionBar(mToolbar);
        mActionBarToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                R.string.drawer_opened,
                R.string.drawer_closed
        );
        mDrawerLayout.addDrawerListener(mActionBarToggle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActionBarToggle.syncState();
        getSupportActionBar().setTitle("Example title");
        mNavigationView.setNavigationItemSelectedListener(this);

    }
}
