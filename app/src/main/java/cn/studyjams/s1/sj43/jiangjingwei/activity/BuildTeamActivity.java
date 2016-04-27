package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.content.Intent;
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
import android.widget.Button;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;
import us.feras.mdv.MarkdownView;

public class BuildTeamActivity extends AppCompatActivity implements ActionBar
        .TabListener {

    AppSectionsPagerAdapter mPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_team);

        mPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager
                ());
        final ActionBar actionBar = getSupportActionBar();

        actionBar.setHomeButtonEnabled(false);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) findViewById(R.id.pager_build_team);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager
                .SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        for (int i = 0; i < mPagerAdapter.getCount(); i++) {
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mPagerAdapter.getPageTitle(i))
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

    private static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new TextOnlyFragment(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "基础队伍";
                case 1:
                    return "优先培养";
                case 2:
                    return "值得培养";
                default:
                    return null;
            }
        }
    }

    public static class TextOnlyFragment extends Fragment {

        private int position;
        private String[] file = {"file:///android_asset/base_team.md",
                "file:///android_asset/first_build.md",
                "file:///android_asset/worth_build.md"};

        public TextOnlyFragment(int position) {
            this.position = position;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            if (position != 2) {
                View view = inflater.inflate(R.layout.fragment_build_team_text,
                        container, false);
                MarkdownView mv_text = (MarkdownView) view.findViewById(R.id
                        .mv_build_team_text);

//            Bundle args = getArguments();

                mv_text.loadMarkdownFile(file[position], CustomTextUtils.css);
                return view;

            } else {
                View view = inflater.inflate(R.layout.fragment_build_team_btn,
                        container, false);
                MarkdownView mv_text = (MarkdownView) view.findViewById(R.id
                        .mv_build_team_btn);

//            Bundle args = getArguments();

                mv_text.loadMarkdownFile(file[position], CustomTextUtils.css);

                Button btn = (Button) view.findViewById(R.id.btn_worth_build);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(),
                                WorthBuildCollectionActivity
                                .class);
                        startActivity(intent);
                    }
                });
                return view;
            }
        }
    }
}
