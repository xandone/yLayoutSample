package com.app.xandone.ylayoutsample.bar;

import android.os.Bundle;

import com.app.xandone.ylayoutsample.R;
import com.app.xandone.ylayoutsample.bar.frag.BarFrag1;
import com.app.xandone.ylayoutsample.bar.frag.BarFrag2;
import com.app.xandone.ylayoutsample.bar.frag.BarFrag3;
import com.app.xandone.ylayoutsample.bar.frag.BarFrag4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * author: xandone
 * created on: 2017/11/23 10:37
 */

public class AppbarAct extends AppCompatActivity {
    private ViewPager bar_vp;
    private TabLayout tabLayout;

    private List<Fragment> fragmentList;
    private List<String> titleList;
    private Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_app_bar_layout);

        bar_vp = (ViewPager) findViewById(R.id.bar_vp);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>(Arrays.asList("scroll", "enterAlways", "exitUntilCollapsed", "enterAlwaysCollapsed"));
        fragmentList.add(new BarFrag1());
        fragmentList.add(new BarFrag2());
        fragmentList.add(new BarFrag3());
        fragmentList.add(new BarFrag4());

        mAdapter = new Adapter(getSupportFragmentManager());
        bar_vp.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(bar_vp);
    }


    class Adapter extends FragmentPagerAdapter {

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
