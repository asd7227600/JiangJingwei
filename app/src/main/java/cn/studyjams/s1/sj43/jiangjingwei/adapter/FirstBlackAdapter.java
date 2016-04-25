package cn.studyjams.s1.sj43.jiangjingwei.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.bean.Group;
import cn.studyjams.s1.sj43.jiangjingwei.bean.Item;

/**
 * Created by David on 2016/4/25.
 */
public class FirstBlackAdapter extends BaseExpandableListAdapter {

    private ArrayList<Group> gData;
//    private ArrayList<ArrayList<Item>> iData;
    private ArrayList<Item> iData;
    private Context mContext;

    public FirstBlackAdapter(ArrayList<Group> gData,
                             ArrayList<Item> iData, Context mContext) {
        this.gData = gData;
        this.iData = iData;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Group getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public Item getChild(int groupPosition, int childPosition) {
        return iData.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup groupHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout
                    .first_black_group, parent, false);
            groupHolder = new ViewHolderGroup();
            groupHolder.icon = (ImageView) convertView.findViewById(R.id.iv_group_fb);
            groupHolder.name = (TextView) convertView.findViewById(R.id.tv_group_name);
            groupHolder.aka = (TextView) convertView.findViewById(R.id
                    .tv_group_aka);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (ViewHolderGroup) convertView.getTag();
        }
        groupHolder.icon.setImageResource(gData.get(groupPosition).getImageId
                ());
        groupHolder.name.setText(gData.get(groupPosition).getName());
        groupHolder.aka.setText(gData.get(groupPosition).getAka());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem itemHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout
                    .first_black_item, parent, false);
            itemHolder = new ViewHolderItem();
            itemHolder.icon_item = (ImageView) convertView.findViewById(R.id.iv_item);
            itemHolder.advantage = (TextView) convertView.findViewById(R.id
                    .tv_item_advantage);
            itemHolder.disadvantage = (TextView) convertView.findViewById(R
                    .id.tv_item_disadvantage);
            itemHolder.evaluate = (TextView) convertView.findViewById(R.id
                    .tv_item_evaluate);
            itemHolder.remark = (TextView) convertView.findViewById(R.id
                    .tv_item_remark);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (ViewHolderItem) convertView.getTag();
        }
        itemHolder.icon_item.setImageResource(iData.get(groupPosition).getIconId());
        itemHolder.advantage.setText(iData.get(groupPosition).getAdvantage());
        itemHolder.disadvantage.setText(iData.get(groupPosition).getDisadvantage());
        itemHolder.evaluate.setText(iData.get(groupPosition).getEvaluate());
        itemHolder.remark.setText(iData.get(groupPosition).getRemark());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolderGroup{
        private ImageView icon;
        private TextView name;
        private TextView aka;
    }

    private static class ViewHolderItem{
        private ImageView icon_item;
        private TextView advantage;
        private TextView disadvantage;
        private TextView evaluate;
        private TextView remark;
    }
}
