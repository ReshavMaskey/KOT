package com.example.kitchenorderticket;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import adapter.ViewPageAdapter;
import control.Hide;
import control.IntentControl;
import fragment.AddFoodFragment;
import fragment.AddUserFragment;
import fragment.AdminAddFragment;
import fragment.DisplayOrderFragment;
import fragment.NavDrawerFragment;

public class AdminDashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
TabLayout tabLayout;
ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Hide.hideActionAndNotificationBar(this);
        Hide.SET_FULLSCREEN(this);
        setContentView(R.layout.activity_admin_dashboard);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Fragment frag = new NavDrawerFragment();
        Fragment adminFrag = new AdminAddFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("text", "Import");
//        adminFrag.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.viewPager, adminFrag);
        transaction.commit(); // commit the changes
        tabLayout = findViewById(R.id.tabId);
        viewPager = findViewById(R.id.viewPager);
        addViewPager();



    }

    private void addViewPager() {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.addFragment(new AdminAddFragment(),"Select Admin");
        viewPageAdapter.addFragment(new AddFoodFragment(),"Add Food");
        viewPageAdapter.addFragment(new AddUserFragment(),"Add User");
        viewPageAdapter.addFragment(new DisplayOrderFragment(),"Display");
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //Handle navigation view item clicks here.
        int id = menuItem.getItemId();

//        Fragment frag = new NavDrawerFragment();
        Fragment frag = new AdminAddFragment();
        Bundle bundle = new Bundle();
        if (id == R.id.item1) {
            bundle.putString("text", "Home");
            Intent i = new Intent(this,AdminDashboardActivity.class);
            startActivity(i);
            System.out.println("admin");
        } else if (id == R.id.item2) {
            bundle.putString("text", "Add");
        } else if (id == R.id.item3) {
            bundle.putString("text", "Update");
            Intent i = new Intent(this,UpdateDetailActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_share) {
            bundle.putString("text", "Share");
        } else if (id == R.id.nav_send) {
            bundle.putString("text", "Send");
        }
        frag.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.viewPager, frag); // replace a Fragment with Frame Layout
        transaction.commit(); // commit the changes

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
