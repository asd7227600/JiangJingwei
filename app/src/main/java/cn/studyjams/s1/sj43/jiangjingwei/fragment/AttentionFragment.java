package cn.studyjams.s1.sj43.jiangjingwei.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
public class AttentionFragment extends Fragment {

    private MarkdownView markdownView;
    private int position;
    private static int[] mv = {R.id.mv_never_do_fragment, R.id
            .mv_right_attitude_fragment, R.id.mv_gogogo_fragment};
    private static int[] layout = {R.layout.fragment_never_do, R.layout
            .fragment_right_attitude, R.layout.fragment_gogogo};
    private static String[] file = {"file:///android_asset/never_do.md",
            "file:///android_asset/right_attitude.md",
            "file:///android_asset/gogogo.md"};
    private static String css = "file:///android_asset/foghorn.css";

    public AttentionFragment() {
    }


    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        switch (position) {
//            case 0:
//                return getView(inflater, container, position);
//            case 1:
//                return getView(inflater, container, position);
//            case 2:
//                return getView(inflater, container, position);
//        }
        position = getArguments().getInt("test");

        return getView(inflater, container, position);
    }

    @NonNull
    private View getView(LayoutInflater inflater, @Nullable ViewGroup
            container, int position) {
        View view = inflater.inflate(layout[position],
                container, false);

        markdownView = (MarkdownView) view.findViewById(mv[position]);
        markdownView.loadMarkdownFile(file[position],css);
        return view;
    }
}
