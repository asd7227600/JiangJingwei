package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.os.Bundle;
import android.os.Vibrator;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by David on 2016/4/28.
 */
public abstract class BaseActivity extends SwipeBackActivity {
    public static final int VIBRATE_DURATION = 27;
    private String mKeyTrackingMode;
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initValue();
        initView();

        mKeyTrackingMode = "fffuck";
        mSwipeBackLayout = getSwipeBackLayout();

        mSwipeBackLayout.setEdgeSize(100);
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);

        mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onScrollStateChange(int state, float scrollPercent) {

            }

            @Override
            public void onEdgeTouch(int edgeFlag) {

            }

            @Override
            public void onScrollOverThreshold() {
                vibrate(VIBRATE_DURATION);
            }
        });
    }

    private void vibrate(long duration) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long[] pattern = {20, duration};
        vibrator.vibrate(pattern, -1);
    }


    protected abstract void initView();

    protected abstract void initValue();
}
