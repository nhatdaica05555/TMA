package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HOME on 4/6/2018.
 */

public class ExpandListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private int tongthu;
    private int tongchi;
    private ArrayList<Nhom> groups;


    public ExpandListAdapter(Context context, int tongthu, int tongchi, ArrayList<Nhom> groups) {
        this.context = context;
        this.tongthu = tongthu;
        this.tongchi = tongchi;
        this.groups = groups;
    }

    public ExpandListAdapter(Context applicationContext, ArrayList<Nhom> expListItems, int sotienthu, int sotienchi) {
    }

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        ArrayList<Child> chList=((Nhom)this.groups.get(i)).getItems();
        return chList.size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    /*@Override
    public Object getGroup(int i) {
        return this.groups.get(i);
    }*/

    @Override
    public Object getChild(int i, int i1) {
        ArrayList<Child> chList=((Nhom)this.groups.get(i)).getItems();
        return chList.get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    @SuppressLint("WrongConstant")
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @SuppressLint({"InflateParams", "ResourceType"})
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
       Child child=(Child)this.getChild(i,i1);
       if(view==null){
          @SuppressLint("WrongConstant") LayoutInflater inflater=(LayoutInflater)this.context.getSystemService("layout_inflater");
          view=inflater.inflate(2130903082,(ViewGroup)null);
       }
       TextView tv=(TextView)view.findViewById(2131034255);
        TextView iv=(TextView)view.findViewById(2131034256);
        tv.setText(child.getPhanLoai().toString());
        iv.setText(child.getKhoanThuKhoanChi().toString());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}

