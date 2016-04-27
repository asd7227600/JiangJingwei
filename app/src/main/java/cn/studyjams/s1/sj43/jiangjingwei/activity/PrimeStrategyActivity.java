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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.adapter.PrimeStrategyAdapter;
import cn.studyjams.s1.sj43.jiangjingwei.bean.PrimeStrategyItem;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomImageUtils;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomNumUtils;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;
import us.feras.mdv.MarkdownView;

public class PrimeStrategyActivity extends AppCompatActivity implements ActionBar.TabListener {

    private ViewPager mViewPager;
    private PartSectionPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_strategy);

        adapter = new PartSectionPagerAdapter(getSupportFragmentManager());

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) findViewById(R.id.pager_prime_strategy);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(new ViewPager
                .SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        for (int i = 0; i < adapter.getCount(); i++) {
            actionBar.addTab(actionBar.newTab()
                    .setText(adapter.getPageTitle(i))
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


    public class PartSectionPagerAdapter extends FragmentPagerAdapter {

        public PartSectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

                Bundle bundle = new Bundle();
                bundle.putInt(PrimeStrategyFragment.TAG, position);
                PrimeStrategyFragment fragment = new PrimeStrategyFragment();
                fragment.setArguments(bundle);
                return fragment;

        }


        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "魅力使用";
                case 1:
                    return "体力使用";
                case 2:
                    return "曜日Mission";
                case 3:
                    return "交换所重要单位";
            }
            return null;
        }
    }



    public static class PrimeStrategyFragment extends Fragment {


        public static final java.lang.String TAG = "position";
        private int position;
        private ListView lv;
        private PrimeStrategyItem item;
        private List<PrimeStrategyItem> lists = new ArrayList<>();

        public PrimeStrategyFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup
                container, @Nullable Bundle savedInstanceState) {

            position = getArguments().getInt(TAG);

            if (position != 3) {
                View view = inflater.inflate(R.layout.fragment_prime_strategy_page1, container, false);
                MarkdownView mv = (MarkdownView) view.findViewById(R.id.mv_prime_strategy);
                mv.loadMarkdownFile(CustomTextUtils.file_prime_strategy[position], CustomTextUtils.css);

                return view;
            } else {
                View view = inflater.inflate(R.layout.prime_strategy_list, container, false);

                lv = (ListView) view.findViewById(R.id.lv_prime_strategy);

                for (int i = 0; i < CustomNumUtils.quantity_prime_strategy_list; i++) {
                    item = new PrimeStrategyItem(
                            CustomImageUtils.image_prime_strategy[i],
                            CustomTextUtils.name_prime_strategy[i],
                            CustomTextUtils.introduce_prime_strategy[i]
                    );
                    lists.add(item);
                }

                PrimeStrategyAdapter adapter = new PrimeStrategyAdapter(getContext(),
                        R.layout.worth_build_item, lists);

                lv.setAdapter(adapter);

                return view;


            }


        }



    }


}

