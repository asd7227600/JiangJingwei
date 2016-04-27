package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import org.askerov.dynamicgrid.DynamicGridView;

import java.util.ArrayList;
import java.util.List;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.adapter.HomeAdapter;
import cn.studyjams.s1.sj43.jiangjingwei.bean.HomeItem;

public class HomeActivity extends FragmentActivity implements AdapterView
        .OnItemClickListener {

    private static final String TAG = "HomeActivity";
    private List<HomeItem> data;
    private final String[] TITLE = {"关于首抽", "开局注意", "组建队伍", "初期套路",
            "初期活动", "狗粮基础"};
    private final int[] ICON = {R.drawable.xibi_icon_72, R.drawable.dk_icon_72,
                                R.drawable.mkt_icon_72, R.drawable.nnl_icon_72,
                                R.drawable.longji_icon_72, R.drawable.nobra_icon_72};
    private DynamicGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initValue();
        initView();
    }

    private void initValue() {
        data = new ArrayList<>();
        HomeItem item;
        for (int i = 0; i < TITLE.length; i++) {
            item = new HomeItem();
            item.setIcon(ICON[i]);
            item.setTitle(TITLE[i]);

            data.add(item);
        }
    }

    private void initView() {
        setContentView(R.layout.activity_home);

        gridView = (org.askerov.dynamicgrid.DynamicGridView) findViewById(R
                .id.gv_home);
        initGridView();
    }

    private void initGridView() {
        Log.d(TAG, "initGridView: in");
        gridView.setAdapter(new HomeAdapter(HomeActivity.this, data, 2));
        Log.d(TAG, "initGridView: setAdapter finished");

        gridView.setOnDragListener(new DynamicGridView.OnDragListener() {
            @Override
            public void onDragStarted(int position) {
                Log.d(TAG, "onDragStarted: the position is: " + position);
            }

            @Override
            public void onDragPositionsChanged(int oldPosition, int newPosition) {
                Log.d(TAG, "onDragPositionsChanged: the oldPosition is: " +
                        oldPosition + ", and the newPosition is: " + newPosition);
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                gridView.startEditMode();
                return true;
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gridView.setOnItemClickListener(HomeActivity.this);
            }
        });



    }

    @Override
    public void onBackPressed() {
        if (gridView.isEditMode()) {
            gridView.stopEditMode();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HomeItem item = (HomeItem) parent.getAdapter().getItem(position);
        Log.d(TAG, "onItemClick: the position is: " + position + ", and the " +
                "id is: " + id);

        Intent intent;
        switch ((int) id) {
            case 0:
                intent = new Intent(this, FirstPickActivity.class);
                break;
            case 1:
                intent = new Intent(this, AttentionActivity.class);
                break;
            case 2:
                intent = new Intent(this, BuildTeamActivity.class);
                break;
            case 3:
                intent = new Intent(this, PrimeStrategyActivity.class);
                break;
            case 4:
                intent = new Intent(this, PrimeActivityChooseActivity.class);
                break;
            case 5:
                intent = new Intent(this, FeedTutorialsActivity.class);
                break;
            default:
                intent = new Intent(this, HomeActivity.class);
        }
        startActivity(intent);


    }

    public void toThanks(View view) {
        Intent intent = new Intent(this, ThanksActivity.class);
        startActivity(intent);
    }
}
