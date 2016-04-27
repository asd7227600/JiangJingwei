package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.support.v7.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.fragment.AttentionFragment;

public class AttentionActivity extends AppCompatActivity implements android.support.v7.app.ActionBar
        .TabListener {

    private static final String TAG = "Attention";
    ViewPager mViewPager;
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);

        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter
                (getSupportFragmentManager());

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager
                .SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            Log.d(TAG, "onCreate: the Adapter.getPageTitle(i) is: " +
                    mAppSectionsPagerAdapter.getPageTitle(i));
            actionBar.addTab(actionBar.newTab().setText(mAppSectionsPagerAdapter
                    .getPageTitle
                    (i)).setTabListener(this));

        }
    }


    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }


    private class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Bundle b1 = new Bundle();
                    b1.putInt("test", position);
                    AttentionFragment fragment1 = new AttentionFragment();
                    fragment1.setArguments(b1);
                    return fragment1;
                case 1:
                    Bundle b2 = new Bundle();
                    b2.putInt("test", position);
                    AttentionFragment fragment2 = new AttentionFragment();
                    fragment2.setArguments(b2);
                    return fragment2;
                case 2:
                    Bundle b3 = new Bundle();
                    b3.putInt("test", position);
                    AttentionFragment fragment3 = new AttentionFragment();
                    fragment3.setArguments(b3);
                    return fragment3;
                default:

            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "绝对别做的事";

                case 1:
                    return "正确的态度";

                case 2:
                    return "踏上正轨";

                default:
                    return null;
            }
//
        }
    }


}
