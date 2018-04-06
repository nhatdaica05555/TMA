package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HOME on 4/5/2018.
 */

public class CustomAdapter extends BaseAdapter {
    private ArrayList<Lichsu> _Contacts;
    private Activity context;
    private LayoutInflater inflater;

    @SuppressLint("WrongConstant")
    public CustomAdapter(Activity context, ArrayList<Lichsu> _Contacts) {
        this._Contacts = _Contacts;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService("layout_inflater");

    }

    @Override
    public int getCount() {
        return this._Contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return ((Lichsu) this._Contacts.get(i)).getTime();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        CustomAdapter.ViewHolder holder;
        if (view == null) {
            holder = new CustomAdapter.ViewHolder();
            view = this.inflater.inflate(2130903079, (ViewGroup) null);
            holder.tvtime = (TextView) view.findViewById(213104219);
            holder.tvphanloai = (TextView) view.findViewById(2131034220);
            holder.tvsotien = (TextView) view.findViewById(2131034221);
            holder.tvtaikhoan = (TextView) view.findViewById(2131034222);
            view.setTag(holder);
        } else {
            holder = (CustomAdapter.ViewHolder) view.getTag();
        }
        holder.tvtime.setText(((Lichsu) this._Contacts.get(i)).getTime());
        holder.tvphanloai.setText(((Lichsu) this._Contacts.get(i)).getPhanloai());
        holder.tvsotien.setText(((Lichsu) this._Contacts.get(i)).getSotien());
        holder.tvtaikhoan.setText(((Lichsu) this._Contacts.get(i)).getTaikhoan());
        return view;
    }

    public class ViewHolder {
        TextView tvtime;
        TextView tvphanloai;
        TextView tvsotien;
        TextView tvtaikhoan;

        public ViewHolder() {
        }
    }
}
