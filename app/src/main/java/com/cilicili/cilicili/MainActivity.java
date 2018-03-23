package com.cilicili.cilicili;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    private BottomBar mBottomBar;
    private NoScrollViewPager mViewPager;
    private int position;
    private IndexFragment mIndexFragment;
    private UserFragment mUserFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar = (BottomBar)findViewById(R.id.bottomBar);
        mViewPager = (NoScrollViewPager)findViewById(R.id.view_pager);
        mViewPager.setAdapter(new HomeFragmentAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(3);

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        position = 0;
                        break;
                    case R.id.tab_user:
                        position = 1;
                        break;
                }
                mViewPager.setCurrentItem(position);
            }
        });
    }

    public class HomeFragmentAdapter extends FragmentPagerAdapter {


        public HomeFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return createFragment(position);
        }

        @Override
        public int getCount() {
            return 2;
        }

    }

    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                mIndexFragment = IndexFragment.newInstance();
                fragment = mIndexFragment;
                break;
            case 1:
                mUserFragment = UserFragment.newInstance();
                fragment = mUserFragment;
                break;
        }
        return fragment;
    }
}
