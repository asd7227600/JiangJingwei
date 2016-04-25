package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.adapter.FirstBlackAdapter;
import cn.studyjams.s1.sj43.jiangjingwei.bean.FirstBlackText;
import cn.studyjams.s1.sj43.jiangjingwei.bean.Item;
import cn.studyjams.s1.sj43.jiangjingwei.bean.Group;

public class FirstBlackRecommendationActivity extends AppCompatActivity {

    private ArrayList<Group> gData = null;
//    private ArrayList<ArrayList<Item>> iData = null;
    private ArrayList<Item> iData = null;
    private Context mContext;
    private ExpandableListView elv;
    private FirstBlackAdapter mAdapter = null;

    private int[] pic = {R.drawable.nnl_icon_72, R.drawable.mkt_icon_72, R
            .drawable.xibi_icon_72, R.drawable.nobra_icon_72};
    private String[] name;
    private String[] aka;
    private String[] advantage;
    private String[] disadvantage;
    private String[] evaluate;
    private String[] remark;


    private FirstBlackText fbt;

    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_black_recommendation);

        mContext = FirstBlackRecommendationActivity.this;
        elv = (ExpandableListView) findViewById(R.id.elv_first_black);

        initNum();
        initData();
        elv.setAdapter(new FirstBlackAdapter(gData, iData, mContext));
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(FirstBlackRecommendationActivity.this, "You " +
                        "click the " + gData.get(groupPosition).getName(), Toast
                        .LENGTH_SHORT)
                        .show();
                return true;
            }
        });
    }

    private void initNum() {
        num = 4;
    }

    private void initData() {
        fbt = new FirstBlackText();

        name = fbt.getName();
        aka = fbt.getAka();
        advantage = fbt.getAdvantage();
        disadvantage = fbt.getDisadvantage();
        evaluate = fbt.getEvaluate();
        remark = fbt.getRemark();

        gData = new ArrayList<>();
        iData = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            gData.add(new Group(pic[i], name[i], aka[i]));
            iData.add(new Item(pic[i], advantage[i], disadvantage[i],
                    evaluate[i], remark[i]));
        }

//        mAdapter = new FirstBlackAdapter(gData, iData, mContext);
//        elv.setAdapter(mAdapter);
    }
}
