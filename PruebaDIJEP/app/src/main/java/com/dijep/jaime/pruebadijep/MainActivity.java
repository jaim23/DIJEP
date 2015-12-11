package com.dijep.jaime.pruebadijep;
;
import android.app.Activity;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.astuetz.PagerSlidingTabStrip;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(), getApplicationContext()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);

        PaisFragment newFragment;
        newFragment = new PaisFragment();
        FragmentManager fragmentManager =this.getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.mContent, newFragment).commit();
    }
}
