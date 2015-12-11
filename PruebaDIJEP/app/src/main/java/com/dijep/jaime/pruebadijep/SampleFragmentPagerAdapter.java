package com.dijep.jaime.pruebadijep;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by Jaime on 10/12/2015.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    String[] adapter_one_tabs;
    Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        adapter_one_tabs = context.getResources().getStringArray(R.array.tabArray);
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return adapter_one_tabs[position];
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0) return new PaisFragment();
        else return new InfoFragment();
    }
}
