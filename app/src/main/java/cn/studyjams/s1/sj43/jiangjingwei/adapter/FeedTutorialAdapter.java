package cn.studyjams.s1.sj43.jiangjingwei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.bean.FeedTutorialItem;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomImageUtils;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;

/**
 * Created by David on 2016/4/27.
 */
public class FeedTutorialAdapter extends ArrayAdapter<FeedTutorialItem> {

    private Context mContext;
    private int resource;
    private ArrayList<FeedTutorialItem> data;

    public FeedTutorialAdapter(Context context, int resource, List<FeedTutorialItem> objects) {
        super(context, resource, objects);
        mContext = context;
        this.resource = resource;
        data = (ArrayList<FeedTutorialItem>) objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.iv_worth_build);
            holder.name = (TextView) convertView.findViewById(R.id.tv_worth_build_name);
            holder.introduce = (TextView) convertView.findViewById(R.id.tv_worth_build_introduce);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setImageResource(CustomImageUtils.image_feed_tutorial[position]);
        holder.name.setText(CustomTextUtils.name_feed_tutorial[position]);
        holder.introduce.setText(CustomTextUtils.introduce_feed_tutorial[position]);

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public FeedTutorialItem getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return 14;
    }

    private class ViewHolder {
        private ImageView icon;
        private TextView name;
        private TextView introduce;
    }
}
