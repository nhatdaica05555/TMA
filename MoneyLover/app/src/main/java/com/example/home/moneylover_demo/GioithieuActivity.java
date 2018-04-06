package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by HOME on 4/5/2018.
 */

public class GioithieuActivity extends ActionBarActivity{
    TextView tv;


    public GioithieuActivity(){}

    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        this.setContentView(2130903067);

        ActionBar actionBar=this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.tv=(TextView)this.findViewById(2131034185);
        String a="+ Các chức năng chính của phần mềm: \n-Có 3 Tab chức năng chính: Thu Chi, Thống Kê, Cài Đặt\n-Thống kê: Tiền mặt, tiền tiết kiệm,thẻ tín dụng và số dư\n-Thống kê chi tiết\n-Hôm nay\n-Tháng\n-Năm\n-Xem lịch sử giao dịch...";
        this.tv.setText(a);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(2131492866,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        return id==2131034235?true:super.onOptionsItemSeclected(item);
    }
}
