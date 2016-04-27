package cn.studyjams.s1.sj43.jiangjingwei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cn.studyjams.s1.sj43.jiangjingwei.R;
import cn.studyjams.s1.sj43.jiangjingwei.bean.PAC_Group;
import cn.studyjams.s1.sj43.jiangjingwei.bean.PAC_Item;
import cn.studyjams.s1.sj43.jiangjingwei.utils.CustomTextUtils;
import us.feras.mdv.MarkdownView;

/**
 * Created by David on 2016/4/27.
 */
public class PAC_Adapter extends BaseExpandableListAdapter {
    private ArrayList<PAC_Group> gData;
    private PAC_Item iData;
    private Context mContext;

    public PAC_Adapter(ArrayList<PAC_Group> gData, PAC_Item iData,
                       Context mContext) {
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
    public PAC_Group getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public PAC_Item getChild(int groupPosition, int childPosition) {
        return iData;
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
    public View getGroupView(int groupPosition, boolean isExpanded, View
            convertView, ViewGroup parent) {
        ViewHolderGroup gHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.pac_group, parent, false);
            gHolder = new ViewHolderGroup();
            gHolder.title = (TextView) convertView.findViewById(R.id.tv_pac_title);
            convertView.setTag(gHolder);
        } else {
            gHolder = (ViewHolderGroup) convertView.getTag();
        }
        gHolder.title.setText(gData.get(groupPosition).getTitle());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean
            isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem iHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.pac_item, parent, false);
            iHolder = new ViewHolderItem();
            iHolder.mvId = (MarkdownView) convertView.findViewById(R.id.mv_pac);
            convertView.setTag(iHolder);
        } else {
            iHolder = (ViewHolderItem) convertView.getTag();
        }
        iHolder.mvId.loadMarkdownFile(iData.getMv(), CustomTextUtils.css);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private class ViewHolderGroup {
        private TextView title;
    }

    private class ViewHolderItem {
        private MarkdownView mvId;
    }
}
