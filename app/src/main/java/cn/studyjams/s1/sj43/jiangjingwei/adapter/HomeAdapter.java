package cn.studyjams.s1.sj43.jiangjingwei.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.askerov.dynamicgrid.BaseDynamicGridAdapter;

import java.util.List;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.bean.HomeItem;

/**
 * Created by David on 2016/4/23.
 */
public class HomeAdapter extends BaseDynamicGridAdapter {


    private static final String TAG = "HomeAdapter";

    public HomeAdapter(Context context, List<?> items, int columnCount) {
        super(context, items, columnCount);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(getContext(), R.layout.item_home_gv, null);

        ImageView icon = (ImageView) view.findViewById(R.id.iv_item_home);
        TextView title = (TextView) view.findViewById(R.id.tv_item_home);

        HomeItem data = (HomeItem) getItem(position);

        Log.d(TAG, "getView: data.getIcon is: " + data.getIcon());
        Log.d(TAG, "getView: data.getTitle() is: " + data.getTitle());

        icon.setImageResource(data.getIcon());
        title.setText(data.getTitle());

        return view;
    }
}
