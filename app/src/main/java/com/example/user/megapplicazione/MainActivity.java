package com.example.user.megapplicazione;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolbar;

    //PER IL FRAGMENT HOME
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar =(Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //GESTIONE DEL FRAGMENT HOME (PAGINA PRINCIPALE)
        fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home Fragment");

        //NAVIGAZIONE TRA ITEMS DEL NAVIGATION DRAWER
        navigationView =(NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home Fragment");
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_settings:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new SettingsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Settings Fragment");
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_pics:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new PicsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Pics Fragment");
                       // item.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_maintenance:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new MaintenanceFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Maintenance Fragment");
                        mDrawerLayout.closeDrawers();
                        break;

                    case R.id.nav_veichles:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new VeichlesFragments());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Veichles Fragment");
                        mDrawerLayout.closeDrawers();
                        break;
                }
                return true ;
            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

