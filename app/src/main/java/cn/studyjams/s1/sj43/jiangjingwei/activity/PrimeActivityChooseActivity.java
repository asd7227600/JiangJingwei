package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.adapter.PAC_Adapter;
import cn.studyjams.s1.sj43.jiangjingwei.bean.PAC_Group;
import cn.studyjams.s1.sj43.jiangjingwei.bean.PAC_Item;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomImageUtils;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;

public class PrimeActivityChooseActivity extends AppCompatActivity implements
        ExpandableListView.OnGroupClickListener, ExpandableListView
        .OnChildClickListener {


    private ExpandableListView elv;
    private int listNum;
    private ArrayList<PAC_Group> gData;
    private ArrayList<PAC_Item> iData;
    private int mLastOpenGroupPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_activity_choose);

        elv = (ExpandableListView) findViewById(R.id.elv_prime_activity_choose);

        initListNum();
        initData();
        initListener();

        elv.setAdapter(new PAC_Adapter(gData, iData, this));
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition,
                                        long id) {
                Toast.makeText(PrimeActivityChooseActivity.this, "You click the "
                        + gData.get(groupPosition).getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });




    }

    private void initListener() {
        elv.setOnGroupClickListener(this);
        elv.setOnChildClickListener(this);
    }

    private void initData() {
        gData = new ArrayList<>();
        iData = new ArrayList<>();

        for (int i = 0; i < listNum; i++) {
            gData.add(new PAC_Group(CustomTextUtils.title_pac[i]));
            iData.add(new PAC_Item(CustomTextUtils.file_pac[i]));
        }
    }

    private void initListNum() {
        listNum = 8;
    }


    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int
            groupPosition, long id) {
        if (groupPosition != mLastOpenGroupPosition) {
            elv.collapseGroup(mLastOpenGroupPosition);
        }

        if (elv.isGroupExpanded(groupPosition)) {
            elv.collapseGroup(groupPosition);
        } else {
            elv.expandGroup(groupPosition);
            elv.setSelectedGroup(groupPosition);
            mLastOpenGroupPosition = groupPosition;
        }

        return true;    // true表示自己消费了时间,不交给基类处理
                        // false表示自己没有处理,交给基类
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int
            groupPosition, int childPosition, long id) {
        return false;
    }
}
