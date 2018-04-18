package com.sunzn.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.sunzn.fragment.subs.AudioFragment;
import com.sunzn.fragment.subs.ImageFragment;
import com.sunzn.fragment.subs.VideoFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initData();
        initView();
    }

    private void initData() {
        mFragments.add(AudioFragment.newInstance());
        mFragments.add(ImageFragment.newInstance());
        mFragments.add(VideoFragment.newInstance());
    }

    private void initView() {
        FocusAdapter mAdapter = new FocusAdapter(getSupportFragmentManager());
        TabLayout mTab = findViewById(R.id.tab);
        ViewPager mViewPager = findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter);
        mTab.setupWithViewPager(mViewPager);
    }

    private class FocusAdapter extends FragmentPagerAdapter {

        private final String[] mTitles = {"音频", "图片", "视频"};

        FocusAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

}
