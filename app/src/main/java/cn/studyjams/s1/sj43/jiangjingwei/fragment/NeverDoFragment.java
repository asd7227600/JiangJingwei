package cn.studyjams.s1.sj43.jiangjingwei.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import us.feras.mdv.MarkdownView;

/**
 * Created by David on 2016/4/24.
 */
public class NeverDoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_never_do, container, false);

        MarkdownView markdownView = (MarkdownView) view.findViewById(R.id
                .mv_never_do_fragment);
        markdownView.loadMarkdownFile("file:///android_asset/never_do.md");

        return view;
    }


}
