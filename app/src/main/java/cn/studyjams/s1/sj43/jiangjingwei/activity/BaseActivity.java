package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.os.Bundle;

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
        initData();
    }

    protected abstract void initData();

    protected abstract void initValue();
}
