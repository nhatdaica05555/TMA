package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOME on 4/6/2018.
 */

public class ThangMainActivity extends Activity {
    private ExpandListAdapter ExpAdapter;
    private ArrayList<Nhom> ExpListItems;
    private ExpandableListView ExpandList;
    Spinner sp;
    private String tvkhoanthu = "Khoản Thu";
    private String tvkhoanchi = "Khoản Chi";
    List<String> list;
    DatabaseHandle db;
    int sotienthu;
    int sotienchi;

    public ThangMainActivity() {
    }

    @SuppressLint({"NewApi", "ResourceType"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903073);
        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.db = new DatabaseHandle(this);
        this.db.open();
        if(this.db.tongtienthangnay(this.tvkhoanthu).get(0) != null) {
            this.sotienthu = Integer.parseInt(((String)this.db.tongtienthangnay(this.tvkhoanthu).get(0)).toString());
        } else {
            this.sotienthu = 0;
        }

        if(this.db.tongtienthangnay(this.tvkhoanchi).get(0) != null) {
            this.sotienchi = Integer.parseInt(((String)this.db.tongtienthangnay(this.tvkhoanchi).get(0)).toString());
        } else {
            this.sotienchi = 0;
        }

        final List<String> list = new ArrayList();
        list.add("Tất Cả");
        list.add("Hôm Nay");
        list.add("Tháng Này");
        list.add("Năm Này");
        this.sp = (Spinner)this.findViewById(2131034187);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, 17367043, list);
        this.sp.setAdapter(adapter);
        this.sp.setSelection(2);
        this.ExpandList = (ExpandableListView)this.findViewById(2131034188);
        this.sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                if(parent.getItemAtPosition(position).toString().equals(((String)list.get(0)).toString())) {
                    i = new Intent(ThangMainActivity.this.getApplicationContext(), MainActivity.class);
                    ThangMainActivity.this.startActivityForResult(i, 10);
                    ThangMainActivity.this.finish();
                }

                if(parent.getItemAtPosition(position).toString().equals(((String)list.get(1)).toString())) {
                    i = new Intent(ThangMainActivity.this.getApplicationContext(), HomNayMainActivity.class);
                    ThangMainActivity.this.startActivityForResult(i, 10);
                    ThangMainActivity.this.finish();
                }

                parent.getItemAtPosition(position).toString().equals(((String)list.get(2)).toString());
                if(parent.getItemAtPosition(position).toString().equals(((String)list.get(3)).toString())) {
                    i = new Intent(ThangMainActivity.this.getApplicationContext(), NamMainActivity.class);
                    ThangMainActivity.this.startActivityForResult(i, 10);
                    ThangMainActivity.this.finish();
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        try {
            this.ExpListItems = this.SetStandardGroups();
            this.ExpAdapter = new ExpandListAdapter(this.getApplicationContext(), this.ExpListItems, this.sotienthu, this.sotienchi);
            this.ExpandList.setAdapter(this.ExpAdapter);
            this.ExpandList.expandGroup(0);
            this.ExpandList.expandGroup(1);
        } catch (NullPointerException var6) {
            Toast.makeText(this.getApplicationContext(), "Chưa có dữ liệu", 1).show();
        }

    }

    public ArrayList<Nhom> SetStandardGroups() {
        ArrayList<Nhom> list = new ArrayList();
        List<String> sotien = this.db.getloggiaodichthangnay1(this.tvkhoanthu);
        List<String> sotien1 = this.db.getloggiaodichthangnay(this.tvkhoanchi);
        Nhom gru = new Nhom();
        gru.setPhanloai("Khoản Thu");
        ArrayList<Child> ch_list = new ArrayList();

        int j;
        Child ch;
        for(j = 0; j < this.db.getloggiaodichthangnay(this.tvkhoanthu).size(); ++j) {
            ch = new Child();
            ch.setPhanLoai((String)this.db.getloggiaodichthangnay(this.tvkhoanthu).get(j));
            ch.setKhoanThuKhoanChi((String)this.db.getsotienthangnay((String)sotien.get(j), "Khoản Thu").get(0));
            ch_list.add(ch);
        }

        gru.setItems(ch_list);
        list.add(gru);
        gru = new Nhom();
        gru.setPhanloai("Khoản Chi");
        ch_list = new ArrayList();

        for(j = 0; j < this.db.getloggiaodichthangnay(this.tvkhoanchi).size(); ++j) {
            ch = new Child();
            ch.setPhanLoai((String)this.db.getloggiaodichthangnay(this.tvkhoanchi).get(j));
            ch.setKhoanThuKhoanChi((String)this.db.getsotienthangnay((String)sotien1.get(j), "Khoản Chi").get(0));
            ch_list.add(ch);
        }

        gru.setItems(ch_list);
        list.add(gru);
        return list;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 16908332:
                Intent i = new Intent(this.getApplicationContext(), MainActivity.class);
                this.startActivity(i);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

