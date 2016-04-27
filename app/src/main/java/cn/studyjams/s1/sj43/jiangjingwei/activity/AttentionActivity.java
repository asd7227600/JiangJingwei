package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;
import us.feras.mdv.MarkdownView;

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
            Bundle bundle = new Bundle();
            bundle.putInt(AttentionFragment.ARG_POSITION, position);
            AttentionFragment fragment = new AttentionFragment();
            fragment.setArguments(bundle);
            return fragment;
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

    public static class AttentionFragment extends Fragment {

        public static final String ARG_POSITION = "position";
        private MarkdownView markdownView;
        private int position;
        private static int[] mv = {R.id.mv_never_do_fragment, R.id
                .mv_right_attitude_fragment, R.id.mv_gogogo_fragment};
        private static int[] layout = {R.layout.fragment_never_do, R.layout
                .fragment_right_attitude, R.layout.fragment_gogogo};
        private static String[] file = {"file:///android_asset/never_do.md",
                "file:///android_asset/right_attitude.md",
                "file:///android_asset/gogogo.md"};
        private static String css = CustomTextUtils.css;

        public AttentionFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            position = getArguments().getInt(ARG_POSITION);

            return getView(inflater, container, position);
        }

        @NonNull
        private View getView(LayoutInflater inflater, @Nullable ViewGroup
                container, int position) {
            View view = inflater.inflate(layout[position],
                    container, false);

            markdownView = (MarkdownView) view.findViewById(mv[position]);
            markdownView.loadMarkdownFile(file[position],css);
            return view;
        }
    }


}
