package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.TextView;

import org.askerov.dynamicgrid.DynamicGridView;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.adapter.HomeAdapter;
import cn.studyjams.s1.sj43.jiangjingwei.bean.HomeItem;
import cn.studyjams.s1.sj43.jiangjingwei.view.TextViewVertical;

public class HomeActivity extends BaseActivity implements AdapterView
        .OnItemClickListener {

    private static final String TAG = "HomeActivity";
    private List<HomeItem> data;
    private final String[] TITLE = {"关于首抽", "开局注意", "组建队伍", "初期套路",
            "初期活动", "狗粮基础"};
    private final int[] ICON = {R.drawable.xibi_icon_72, R.drawable.dk_icon_72,
                                R.drawable.mkt_icon_72, R.drawable.nnl_icon_72,
                                R.drawable.longji_icon_72, R.drawable.nobra_icon_72};
    private DynamicGridView gridView;

    // 判定GV是否显示的flag
    private boolean flag = true;
    private boolean flag_miss_all = false;

    TextView tv_only_pic;
    TextView tv_qq_club;

    protected void initValue() {
        data = new ArrayList<>();
        HomeItem item;
        for (int i = 0; i < TITLE.length; i++) {
            item = new HomeItem();
            item.setIcon(ICON[i]);
            item.setTitle(TITLE[i]);

            data.add(item);
        }
    }

    protected void initView() {
        setContentView(R.layout.activity_home);

        tv_only_pic = (TextView) findViewById(R.id.tv_only_pic);
        tv_qq_club = (TextView) findViewById(R.id.tv_qq_club);

        gridView = (org.askerov.dynamicgrid.DynamicGridView) findViewById(R
                .id.gv_home);
        initGridView();
    }

    private void initGridView() {
        gridView.setAdapter(new HomeAdapter(HomeActivity.this, data, 2));

        // 设置GV动画
        LayoutAnimationController lac = new LayoutAnimationController(
                AnimationUtils.loadAnimation(this, R.anim.home_item_anim)
        );
        lac.setOrder(LayoutAnimationController.ORDER_RANDOM);
        gridView.setLayoutAnimation(lac);
        gridView.startLayoutAnimation();
        flag = true;



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
        } else if (flag_miss_all) {
            tv_only_pic.setVisibility(View.VISIBLE);
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

    public void onlySeePic(View view) {
        LayoutAnimationController lac;
        if (flag) {
            System.out.println("--------------------flag = true");
            lac = new LayoutAnimationController(
                    AnimationUtils.loadAnimation(this, R.anim.home_item_disappear)
            );
            lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
            gridView.setLayoutAnimation(lac);
            gridView.startLayoutAnimation();



            for (int i = 0; i < 6; i++) {

                final int finalI = i;
                new Thread() {
                    public void run() {
                        SystemClock.sleep(400);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                View childView = gridView.getChildAt(finalI);
                                childView.setVisibility(View.INVISIBLE);
                            }

                        });
                    }
                }.start();

            }

            new Thread() {
                @Override
                public void run() {
                    SystemClock.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            gridView.setVisibility(View.INVISIBLE);

                            for (int i = 0; i < 6; i++) {
                                View cView = gridView.getChildAt(i);
                                cView.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    SystemClock.sleep(1300);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_qq_club.setVisibility(View.INVISIBLE);
                            tv_only_pic.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }.start();


            flag_miss_all = true;
            flag = false;
        } else {
            System.out.println("--------------------flag = false");
            lac = new LayoutAnimationController(
                    AnimationUtils.loadAnimation(this, R.anim.home_item_appear)
            );
            lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
            gridView.setLayoutAnimation(lac);
            gridView.setVisibility(View.VISIBLE);
            gridView.startLayoutAnimation();

            tv_qq_club.setVisibility(View.VISIBLE);

            flag_miss_all = false;
            flag = true;
        }
    }
}
