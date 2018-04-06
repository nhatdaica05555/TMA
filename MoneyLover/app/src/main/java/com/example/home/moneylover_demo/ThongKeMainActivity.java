package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class ThongKeMainActivity extends Activity {
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

    public ThongKeMainActivity() {
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903075);
        this.db = new DatabaseHandle(this);
        this.db.open();
        if(this.db.tongtien(this.tvkhoanthu).get(0) != null) {
            this.sotienthu = Integer.parseInt(((String)this.db.tongtien(this.tvkhoanthu).get(0)).toString());
        } else {
            this.sotienthu = 0;
        }

        if(this.db.tongtien(this.tvkhoanchi).get(0) != null) {
            this.sotienchi = Integer.parseInt(((String)this.db.tongtien(this.tvkhoanchi).get(0)).toString());
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
        this.sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position).toString().equals(((String)list.get(0)).toString());
                Intent i;
                if(parent.getItemAtPosition(position).toString().equals(((String)list.get(1)).toString())) {
                    i = new Intent(ThongKeMainActivity.this.getApplicationContext(), HomNayMainActivity.class);
                    ThongKeMainActivity.this.startActivityForResult(i, 10);
                    ThongKeMainActivity.this.finish();
                }

                if(parent.getItemAtPosition(position).toString().equals(((String)list.get(2)).toString())) {
                    i = new Intent(ThongKeMainActivity.this.getApplicationContext(), ThangMainActivity.class);
                    ThongKeMainActivity.this.startActivityForResult(i, 10);
                    ThongKeMainActivity.this.finish();
                }

                if(parent.getItemAtPosition(position).toString().equals(((String)list.get(3)).toString())) {
                    i = new Intent(ThongKeMainActivity.this.getApplicationContext(), NamMainActivity.class);
                    ThongKeMainActivity.this.startActivityForResult(i, 10);
                    ThongKeMainActivity.this.finish();
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        this.ExpandList = (ExpandableListView)this.findViewById(2131034188);

        try {
            this.ExpListItems = this.SetStandardGroups();
            this.ExpAdapter = new ExpandListAdapter(this.getApplicationContext(), this.ExpListItems, this.sotienthu, this.sotienchi);
            this.ExpandList.setAdapter(this.ExpAdapter);
            this.ExpandList.expandGroup(0);
            this.ExpandList.expandGroup(1);
        } catch (NullPointerException var5) {
            Toast.makeText(this.getApplicationContext(), "Chưa có dữ liệu", 1).show();
        }

    }

    public ArrayList<Nhom> SetStandardGroups() {
        ArrayList<Nhom> list = new ArrayList();
        List<String> sotien = this.db.getloggiaodich1(this.tvkhoanthu);
        List<String> sotien1 = this.db.getloggiaodich1(this.tvkhoanchi);
        Nhom gru = new Nhom();
        gru.setPhanloai("Khoản Thu");
        ArrayList<Child> ch_list = new ArrayList();

        int j;
        Child ch;
        for(j = 0; j < this.db.getloggiaodich(this.tvkhoanthu).size(); ++j) {
            ch = new Child();
            ch.setPhanLoai((String)this.db.getloggiaodich(this.tvkhoanthu).get(j));
            ch.setKhoanThuKhoanChi((String)this.db.getsotien((String)sotien.get(j), this.tvkhoanthu).get(0));
            ch_list.add(ch);
        }

        gru.setItems(ch_list);
        list.add(gru);
        gru = new Nhom();
        gru.setPhanloai("Khoản Chi");
        ch_list = new ArrayList();

        for(j = 0; j < this.db.getloggiaodich(this.tvkhoanchi).size(); ++j) {
            ch = new Child();
            ch.setPhanLoai((String)this.db.getloggiaodich(this.tvkhoanchi).get(j));
            ch.setKhoanThuKhoanChi((String)this.db.getsotien((String)sotien1.get(j), this.tvkhoanchi).get(0));
            ch_list.add(ch);
        }

        gru.setItems(ch_list);
        list.add(gru);
        return list;
    }
}

