package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by HOME on 4/6/2018.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> listDataCha1;
    private HashMap<String, List<String>> listDataCon1;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData) {
        this._context = context;
        this.listDataCha1 = listDataHeader;
        this.listDataCon1 = listChildData;
    }

    public void onGroupCollapsed(int groupPosition) {
        this.notifyDataSetInvalidated();
    }

    public Object getChild(int groupPosition, int childPosititon) {
        return ((List)this.listDataCon1.get(this.listDataCha1.get(groupPosition))).get(childPosititon);
    }

    public long getChildId(int groupPosition, int childPosition) {
        return (long)childPosition;
    }

    @SuppressLint({"InflateParams"})
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String)this.getChild(groupPosition, childPosition);
        if(convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater)this._context.getSystemService("layout_inflater");
            convertView = infalInflater.inflate(2130903082, (ViewGroup)null);
        }

        TextView txtListChild = (TextView)convertView.findViewById(2131034225);
        txtListChild.setText(childText);
        TextView txtListChild1 = (TextView)convertView.findViewById(2131034226);
        if(groupPosition == 0) {
            txtListChild1.setText("Khoản Thu");
        }

        if(groupPosition == 1) {
            txtListChild1.setText("Khoản Chi");
        }

        return convertView;
    }

    public int getChildrenCount(int groupPosition) {
        return ((List)this.listDataCon1.get(this.listDataCha1.get(groupPosition))).size();
    }

    public Object getGroup(int groupPosition) {
        return this.listDataCha1.get(groupPosition);
    }

    public int getGroupCount() {
        return this.listDataCha1.size();
    }

    public long getGroupId(int groupPosition) {
        return (long)groupPosition;
    }

    @SuppressLint({"InflateParams"})
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String)this.getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater)this._context.getSystemService("layout_inflater");
            convertView = infalInflater.inflate(2130903080, (ViewGroup)null);
        }

        TextView lblListHeader = (TextView)convertView.findViewById(2131034223);
        lblListHeader.setTypeface((Typeface)null, 1);
        lblListHeader.setText(headerTitle);
        return convertView;
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
