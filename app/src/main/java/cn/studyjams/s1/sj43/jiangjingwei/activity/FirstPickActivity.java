package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;
import us.feras.mdv.MarkdownView;

public class FirstPickActivity extends FragmentActivity {

    private static final String TAG = "FirstPick";
    private MarkdownView markdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_pick);

        Log.d(TAG, "onCreate: start on markdownView");
        markdownView = (MarkdownView) findViewById(R.id.mv_first_pick);
//        markdownView.loadMarkdown("## The Title");

        markdownView.loadMarkdownFile("file:///android_asset/first_pick.md",
                CustomTextUtils.css);


    }

//    public void showText(View view) {
//        if (markdownView.getVisibility() == View.VISIBLE) {
//            Log.d(TAG, "showText: the view's visible is: " + markdownView
//                    .getVisibility());
//                    Log.d(TAG, "showText: set invisible");
//            markdownView.setVisibility(View.GONE);
//            Log.d(TAG, "showText: the view's visible is: " + markdownView
//                    .getVisibility());
//        } else {
//            Log.d(TAG, "showText: set visible");
//            markdownView.setVisibility(View.VISIBLE);
//        }
//    }

    public void toRecommendation(View view) {
        Intent intent = new Intent(this, FirstBlackRecommendationActivity.class);
        startActivity(intent);
        finish();
    }
}
