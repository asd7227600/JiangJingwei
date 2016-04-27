package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.adapter.WorthBuildAdapter;
import cn.studyjams.s1.sj43.jiangjingwei.bean.WorthBuildContent;
import cn.studyjams.s1.sj43.jiangjingwei.bean.WorthBuildItem;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;
import us.feras.mdv.MarkdownView;

/**
 * Created by David on 2016/4/26.
 */
public class WorthBuildCollectionActivity extends AppCompatActivity {

    ViewPager mViewPager;
    WorthBuildCollectionPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worth_build);

        mAdapter = new WorthBuildCollectionPagerAdapter(getSupportFragmentManager());
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.pager_worth_build);
        mViewPager.setAdapter(mAdapter);


    }

    public static class WorthBuildCollectionPagerAdapter extends FragmentStatePagerAdapter {


        private int[] listNum = {3, 3, 3, 2, 2, 5, 3, 6, 3, 2, 2, 5};
        private String[] career = {
                "弓箭手", "魔女", "治愈师", "重装",
                "士兵", "魔法师", "女武神", "盗贼",
                "山贼", "吸血鬼猎人", "海贼", "必须了解的其他"};
        private String[] aka = {
                "弓", "冰", "奶", "盾",
                "兵", "火球", "骑", "贼",
                "山贼", "弩", "海贼", "王国正规军"};

        public WorthBuildCollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new WorthBuildCollectionFragment(position, listNum[position]);
            Bundle args = new Bundle();
            args.putInt(WorthBuildCollectionFragment.ARG_OBJECT, position + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 12;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return career[position] + "系列" + "(" + aka[position] + ")";
        }
    }

    public static class WorthBuildCollectionFragment extends Fragment {

        private WorthBuildItem item;
        private List<WorthBuildItem> lists = new ArrayList<>();
        public static final String ARG_OBJECT = "object";
        private int position;
        private int listNum;


        public WorthBuildCollectionFragment(int position, int listNum) {
            this.position = position;
            this.listNum = listNum;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup
                container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_collection_worth_build,
                    container, false);
//            Bundle args = getArguments();

            Button btn = (Button) view.findViewById(R.id.btn_worth_build_collapse);
            final MarkdownView mv = (MarkdownView) view.findViewById(R.id.mv_worth_build);
            final ListView lv = (ListView) view.findViewById(R.id.lv_worth_build);


            mv.loadMarkdownFile(WorthBuildContent.file[position], CustomTextUtils.css);

            initData();

            WorthBuildAdapter adapter = new WorthBuildAdapter(getContext(), R.layout.worth_build_item, lists);
            lv.setAdapter(adapter);

            mv.setVisibility(View.VISIBLE);
            lv.setVisibility(View.INVISIBLE);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mv.getVisibility() == View.VISIBLE) {
                        mv.setVisibility(View.GONE);
                        lv.setVisibility(View.VISIBLE);
                    } else {
                        mv.setVisibility(View.VISIBLE);
                        lv.setVisibility(View.INVISIBLE);
                    }
                }
            });

            return view;
        }

        private void initData() {
            for (int i = 0; i < listNum; i++) {
                item = new WorthBuildItem(
                        WorthBuildContent.image[position][i],
                        WorthBuildContent.name[position][i],
                        WorthBuildContent.introduce[position][i]
                );
                lists.add(item);
            }
        }
    }
}
