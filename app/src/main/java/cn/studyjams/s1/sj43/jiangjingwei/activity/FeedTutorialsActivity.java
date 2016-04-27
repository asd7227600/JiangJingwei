package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.adapter.FeedTutorialAdapter;
import cn.studyjams.s1.sj43.jiangjingwei.bean.FeedTutorialItem;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomImageUtils;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomNumUtils;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;
import us.feras.mdv.MarkdownView;

public class FeedTutorialsActivity extends AppCompatActivity implements
        ActionBar.TabListener {

    ViewPager mViewPager;
    FeedSectionPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_tutorials);

        mAdapter = new FeedSectionPagerAdapter(getSupportFragmentManager());

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) findViewById(R.id.pager_feed_tutorial);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager
                .SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        for (int i = 0; i < mAdapter.getCount(); i++) {
            actionBar.addTab(actionBar.newTab()
                    .setText(mAdapter.getPageTitle(i))
                    .setTabListener(this));
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    private class FeedSectionPagerAdapter extends FragmentPagerAdapter {


        public FeedSectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt(CustomTextUtils.ARG_POSITION, position);
            FeedTutorialFragment fragment = new FeedTutorialFragment();
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
                    return "喂桶表";
                case 1:
                    return "狗粮是啥";
                case 2:
                    return "圣灵/拌饭/桶";
                default:
                    return null;
            }
        }
    }

    public static class FeedTutorialFragment extends Fragment {

        private static final String TAG = "FeedTutorialFragment";
        private int position;
        private ListView lv;
        private FeedTutorialItem item;
        private List<FeedTutorialItem> lists = new ArrayList<>();

        public FeedTutorialFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup
                container, @Nullable Bundle savedInstanceState) {
            position = getArguments().getInt(CustomTextUtils.ARG_POSITION);

            View view;
            MarkdownView mv;
            if (position != 2) {
                view = inflater.inflate(R.layout.fragment_prime_strategy_page1, container, false);
                mv = (MarkdownView) view.findViewById(R.id.mv_prime_strategy);
                Log.d(TAG, "onCreateView: the position is: " + position);
                mv.loadMarkdownFile(CustomTextUtils.file_feed[position], CustomTextUtils.css);
                Log.d(TAG, "onCreateView: the file is: " + CustomTextUtils.file_feed[position]);
                return view;
            } else {
                Log.d(TAG, "onCreateView: the position is: " + position);

                view = inflater.inflate(R.layout.fragment_feed_tutorial_list, container, false);

                lv = (ListView) view.findViewById(R.id.lv_feed_tutorial);

                for (int i = 0; i < CustomNumUtils.quantity_feed_tutorial_list; i++) {
                    item = new FeedTutorialItem(
                            CustomImageUtils.image_feed_tutorial[i],
                            CustomTextUtils.name_feed_tutorial[i],
                            CustomTextUtils.introduce_feed_tutorial[i]
                    );
                    lists.add(item);
                }

                FeedTutorialAdapter adapter = new FeedTutorialAdapter(
                        getContext(), R.layout.worth_build_item, lists);

                lv.setAdapter(adapter);

                return view;

            }

        }

    }
}
