package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    public MainActivity() {
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903071);
        TabHost tabHost = this.getTabHost();
        TabHost.TabSpec thuchi = tabHost.newTabSpec("Thu Chi");
        thuchi.setIndicator("Thu Chi", this.getResources().getDrawable(2130837606));
        Intent i = new Intent(this, ThuChiMainActivity.class);
        thuchi.setContent(i);
        TabHost.TabSpec thongke = tabHost.newTabSpec("Thống Kê");
        thongke.setIndicator("Thống Kê", this.getResources().getDrawable(2130837606));
        Intent o = new Intent(this, ThongKeMainActivity.class);
        thongke.setContent(o);
        TabHost.TabSpec caidat = tabHost.newTabSpec("Cài Đặt");
        caidat.setIndicator("Cài Đặt", this.getResources().getDrawable(2130837606));
        Intent p = new Intent(this, CaiDatMainActivity.class);
        caidat.setContent(p);
        tabHost.addTab(thuchi);
        tabHost.addTab(thongke);
        tabHost.addTab(caidat);
        tabHost.setCurrentTab(0);
    }

    @SuppressLint("ResourceType")
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(2131492869, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 2131034238:
                this.about();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void about() {
        System.exit(0);
    }
}

