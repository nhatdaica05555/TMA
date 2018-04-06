package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by HOME on 4/6/2018.
 */

public class ThuChiMainActivity extends Activity {
    Button themGD;
    Button homnay;
    Button thangnay;
    Button namnay;
    Button gt;
    Button ls;
    TextView sodu;
    TextView tindung;
    TextView tietkiem;
    TextView tienmat;
    DatabaseHandle db;
    int sodutienmat;
    int sodutindung;
    int sodutietkiem;

    public ThuChiMainActivity() {
    }

    @SuppressLint({"NewApi", "ResourceType"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.db = new DatabaseHandle(this);
        this.db.open();
        this.setContentView(2130903076);
        this.themGD = (Button)this.findViewById(2131034212);
        this.homnay = (Button)this.findViewById(2131034213);
        this.thangnay = (Button)this.findViewById(2131034214);
        this.namnay = (Button)this.findViewById(2131034215);
        this.gt = (Button)this.findViewById(2131034217);
        this.ls = (Button)this.findViewById(2131034216);
        this.sodu = (TextView)this.findViewById(2131034211);
        this.tietkiem = (TextView)this.findViewById(2131034209);
        this.tindung = (TextView)this.findViewById(2131034210);
        this.tienmat = (TextView)this.findViewById(2131034208);
        if(this.db.taikhoan("Tín Dụng").get(0) == null) {
            this.sodutindung = 0;
        } else {
            this.sodutindung = Integer.parseInt((String)this.db.taikhoan("Tín Dụng").get(0));
        }

        if(this.db.taikhoan("Tiền Mặt").get(0) == null) {
            this.sodutienmat = 0;
        } else {
            this.sodutienmat = Integer.parseInt((String)this.db.taikhoan("Tiền Mặt").get(0));
        }

        if(this.db.taikhoan("Tiết Kiệm").get(0) == null) {
            this.sodutietkiem = 0;
        } else {
            this.sodutietkiem = Integer.parseInt((String)this.db.taikhoan("Tiết Kiệm").get(0));
        }

        this.tietkiem.setText(String.valueOf(this.sodutietkiem));
        this.tindung.setText(String.valueOf(this.sodutindung));
        this.tienmat.setText(String.valueOf(this.sodutienmat));
        this.sodu.setText(String.valueOf(this.sodutienmat + this.sodutindung + this.sodutietkiem));
        this.themGD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(ThuChiMainActivity.this, ThemgiaodichActivity.class);
                ThuChiMainActivity.this.startActivity(i);
            }
        });
        this.homnay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(ThuChiMainActivity.this, HomNayMainActivity.class);
                ThuChiMainActivity.this.startActivity(i);
            }
        });
        this.thangnay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(ThuChiMainActivity.this, ThangMainActivity.class);
                ThuChiMainActivity.this.startActivity(i);
            }
        });
        this.ls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(ThuChiMainActivity.this, ListGiaoDichMainActivity.class);
                ThuChiMainActivity.this.startActivity(i);
            }
        });
        this.gt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(ThuChiMainActivity.this, GioithieuActivity.class);
                ThuChiMainActivity.this.startActivity(i);
            }
        });
        this.namnay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(ThuChiMainActivity.this, NamMainActivity.class);
                ThuChiMainActivity.this.startActivity(i);
            }
        });
    }
}

