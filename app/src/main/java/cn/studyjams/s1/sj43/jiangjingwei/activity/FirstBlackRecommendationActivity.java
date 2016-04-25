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

    private int[] pic = {
            R.drawable.nnl, R.drawable.legend, R.drawable.loli_milk,
            R.drawable.black_ice, R.drawable.mkt, R.drawable.harry, R.drawable.dragon,
            R.drawable.pink_bitch, R.drawable.jiegeng, R.drawable.blackblack,
            R.drawable.xibi, R.drawable.bean_sprout, R.drawable.young_sister_shield,
            R.drawable.one_horn, R.drawable.thief, R.drawable.diaomao,
            R.drawable.black_soldier, R.drawable.elder_sisiter_shield, R.drawable.xingcun,
            R.drawable.sow, R.drawable.poi, R.drawable.magic_shield, R.drawable.fatter,
            R.drawable.moon_shadow, R.drawable.fighter_king, R.drawable.nezha,
            R.drawable.devil_god, R.drawable.fox, R.drawable.black_time_witch};

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
        num = 29;
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
