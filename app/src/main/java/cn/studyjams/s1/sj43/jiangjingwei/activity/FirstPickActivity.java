package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import us.feras.mdv.MarkdownView;

public class FirstPickActivity extends AppCompatActivity {

    private static final String TAG = "FirstPick";
    private MarkdownView markdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_pick);

        Log.d(TAG, "onCreate: start on markdownView");
        this.getAssets();
        markdownView = (MarkdownView) findViewById(R.id.mv_first_pick);
//        markdownView.loadMarkdown("## The Title");


//        Uri uri;
//        uri = Uri.parse("android.resource://your.app.package/" + R.raw.test);
//
//        markdownView.loadMarkdownFile(uri.getPath());

        markdownView.loadMarkdownFile("file:///android_asset/test.md");
        Log.d(TAG, "onCreate: end of markdownView");

    }
}
