package cn.studyjams.s1.sj43.jiangjingwei.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import us.feras.mdv.MarkdownView;

public class FirstPickActivity extends AppCompatActivity {

    private MarkdownView markdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_pick);

        markdownView = (MarkdownView) findViewById(R.id.mv_first_pick);
//        markdownView.loadMarkdown("## The Title");
            markdownView.loadMarkdownFile("file:///android_raw/test.md");


    }
}
