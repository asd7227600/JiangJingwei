package cn.studyjams.s1.sj43.jiangjingwei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.bean.WorthBuildItem;

/**
 * Created by David on 2016/4/26.
 */
public class WorthBuildAdapter extends ArrayAdapter<WorthBuildItem> {
    private ArrayList<WorthBuildItem> data;
    private Context mContext;

    public WorthBuildAdapter(Context context, int resource,
                             List<WorthBuildItem> objects) {
        super(context, resource, objects);
        mContext = context;
        data = (ArrayList<WorthBuildItem>) objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.worth_build_item, parent, false);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.iv_worth_build);
            holder.name = (TextView) convertView.findViewById(R.id.tv_worth_build_name);
            holder.introduce = (TextView) convertView.findViewById(
                    R.id.tv_worth_build_introduce);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.icon.setImageResource(data.get(position).getImageId());
        holder.name.setText(data.get(position).getName());
        holder.introduce.setText(data.get(position).getIntroduce());
        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public WorthBuildItem getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private class ViewHolder {
        private ImageView icon;
        private TextView name;
        private TextView introduce;
    }
}
