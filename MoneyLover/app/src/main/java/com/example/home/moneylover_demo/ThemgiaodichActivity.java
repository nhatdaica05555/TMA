package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by HOME on 4/6/2018.
 */

public class ThemgiaodichActivity extends Activity implements AdapterView.OnItemSelectedListener {
    Spinner sptk;
    Spinner sploaigd;
    Spinner spinphannhom;
    Spinner spintrangthai;
    Button luu;
    Button lichsu;
    EditText ngaythang;
    EditText sotien;
    EditText lydo;
    Button pickerthemgd;
    static final int DATE_DIALOG_ID = 0;
    private int mYear;
    private int mMonth;
    private int mDay;
    DatabaseHandle db;
    String spinkhoanthu = "Khoản Thu";
    String spinkhoanchi = "Khoản Chi";
    String ngay;
    String thang;
    Toast mToast;
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            ThemgiaodichActivity.this.mYear = year;
            ThemgiaodichActivity.this.mMonth = monthOfYear;
            ThemgiaodichActivity.this.mDay = dayOfMonth;
            ThemgiaodichActivity.this.ngaythang.setText((new StringBuilder()).append(ThemgiaodichActivity.this.mDay).append("/").append(ThemgiaodichActivity.this.mMonth + 1).append("/").append(ThemgiaodichActivity.this.mYear));
        }
    };

    public ThemgiaodichActivity() {
    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903074);
        this.db = new DatabaseHandle(this);
        this.db.open();
        this.sptk = (Spinner)this.findViewById(2131034191);
        this.luu = (Button)this.findViewById(2131034205);
        this.lichsu = (Button)this.findViewById(2131034206);
        this.ngaythang = (EditText)this.findViewById(2131034203);
        this.sotien = (EditText)this.findViewById(2131034195);
        this.lydo = (EditText)this.findViewById(2131034197);
        this.pickerthemgd = (Button)this.findViewById(2131034204);
        this.ngaythang.setEnabled(false);
        this.ngaythang.setFocusable(false);
        Calendar c = Calendar.getInstance();
        this.mYear = c.get(1);
        this.mMonth = c.get(2);
        this.mDay = c.get(5);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.ngaythang.setText(sdf.format(c.getTime()));
        this.pickerthemgd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ThemgiaodichActivity.this.showDialog(0);
            }
        });
        this.luu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ThemgiaodichActivity.this.ngaythang.getText().length() >= 1 && ThemgiaodichActivity.this.sotien.getText().length() >= 1 && ThemgiaodichActivity.this.lydo.getText().length() >= 1) {
                    if(ThemgiaodichActivity.this.mDay < 10) {
                        ThemgiaodichActivity.this.ngay = "0" + ThemgiaodichActivity.this.mDay;
                    } else {
                        ThemgiaodichActivity.this.ngay = String.valueOf(ThemgiaodichActivity.this.mDay);
                    }

                    if(ThemgiaodichActivity.this.mMonth + 1 < 10) {
                        ThemgiaodichActivity.this.thang = "0" + (ThemgiaodichActivity.this.mMonth + 1);
                    } else {
                        ThemgiaodichActivity.this.thang = String.valueOf(ThemgiaodichActivity.this.mMonth + 1);
                    }

                    if(ThemgiaodichActivity.this.sploaigd.getSelectedItem().equals("Khoản Chi")) {
                        ThemgiaodichActivity.this.db.themgiaodich(ThemgiaodichActivity.this.sptk.getSelectedItem().toString(), ThemgiaodichActivity.this.sploaigd.getSelectedItem().toString(), "-" + ThemgiaodichActivity.this.sotien.getText().toString(), ThemgiaodichActivity.this.lydo.getText().toString(), ThemgiaodichActivity.this.spinphannhom.getSelectedItem().toString(), ThemgiaodichActivity.this.ngaythang.getText().toString(), ThemgiaodichActivity.this.ngay, ThemgiaodichActivity.this.thang, String.valueOf(ThemgiaodichActivity.this.mYear));
                        ThemgiaodichActivity.this.db.close();
                    } else {
                        ThemgiaodichActivity.this.db.themgiaodich(ThemgiaodichActivity.this.sptk.getSelectedItem().toString(), ThemgiaodichActivity.this.sploaigd.getSelectedItem().toString(), ThemgiaodichActivity.this.sotien.getText().toString(), ThemgiaodichActivity.this.lydo.getText().toString(), ThemgiaodichActivity.this.spinphannhom.getSelectedItem().toString(), ThemgiaodichActivity.this.ngaythang.getText().toString(), ThemgiaodichActivity.this.ngay, ThemgiaodichActivity.this.thang, String.valueOf(ThemgiaodichActivity.this.mYear));
                        ThemgiaodichActivity.this.db.close();
                    }

                    LayoutInflater inflater = ThemgiaodichActivity.this.getLayoutInflater();
                    View mToastView = inflater.inflate(2130903083, (ViewGroup)null);
                    ThemgiaodichActivity.this.mToast = new Toast(ThemgiaodichActivity.this);
                    ThemgiaodichActivity.this.mToast.setView(mToastView);
                    ThemgiaodichActivity.this.mToast.show();
                    Intent intent = new Intent(ThemgiaodichActivity.this.getApplicationContext(), ThemgiaodichActivity.class);
                    ThemgiaodichActivity.this.startActivityForResult(intent, 8);
                    ThemgiaodichActivity.this.finish();
                } else {
                    Toast.makeText(ThemgiaodichActivity.this.getApplicationContext(), "Bạn cần nhập đầy đủ thông tin.", 0).show();
                    ThemgiaodichActivity.this.sotien.requestFocus();
                }

            }
        });
        this.lichsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ThemgiaodichActivity.this.ngaythang.getText().length() >= 1 && ThemgiaodichActivity.this.sotien.getText().length() >= 1 && ThemgiaodichActivity.this.lydo.getText().length() >= 1) {
                    if(ThemgiaodichActivity.this.mDay < 10) {
                        ThemgiaodichActivity.this.ngay = "0" + ThemgiaodichActivity.this.mDay;
                    } else {
                        ThemgiaodichActivity.this.ngay = String.valueOf(ThemgiaodichActivity.this.mDay);
                    }

                    if(ThemgiaodichActivity.this.mMonth + 1 < 10) {
                        ThemgiaodichActivity.this.thang = "0" + (ThemgiaodichActivity.this.mMonth + 1);
                    } else {
                        ThemgiaodichActivity.this.thang = String.valueOf(ThemgiaodichActivity.this.mMonth + 1);
                    }

                    if(ThemgiaodichActivity.this.sploaigd.getSelectedItem().equals("Khoản Chi")) {
                        ThemgiaodichActivity.this.db.themgiaodich(ThemgiaodichActivity.this.sptk.getSelectedItem().toString(), ThemgiaodichActivity.this.sploaigd.getSelectedItem().toString(), "-" + ThemgiaodichActivity.this.sotien.getText().toString(), ThemgiaodichActivity.this.lydo.getText().toString(), ThemgiaodichActivity.this.spinphannhom.getSelectedItem().toString(), ThemgiaodichActivity.this.ngaythang.getText().toString(), ThemgiaodichActivity.this.ngay, ThemgiaodichActivity.this.thang, String.valueOf(ThemgiaodichActivity.this.mYear));
                        ThemgiaodichActivity.this.db.close();
                    } else {
                        ThemgiaodichActivity.this.db.themgiaodich(ThemgiaodichActivity.this.sptk.getSelectedItem().toString(), ThemgiaodichActivity.this.sploaigd.getSelectedItem().toString(), ThemgiaodichActivity.this.sotien.getText().toString(), ThemgiaodichActivity.this.lydo.getText().toString(), ThemgiaodichActivity.this.spinphannhom.getSelectedItem().toString(), ThemgiaodichActivity.this.ngaythang.getText().toString(), ThemgiaodichActivity.this.ngay, ThemgiaodichActivity.this.thang, String.valueOf(ThemgiaodichActivity.this.mYear));
                        ThemgiaodichActivity.this.db.close();
                    }

                    LayoutInflater inflater = ThemgiaodichActivity.this.getLayoutInflater();
                    View mToastView = inflater.inflate(2130903083, (ViewGroup)null);
                    ThemgiaodichActivity.this.mToast = new Toast(ThemgiaodichActivity.this);
                    ThemgiaodichActivity.this.mToast.setView(mToastView);
                    ThemgiaodichActivity.this.mToast.show();
                    Intent intent = new Intent(ThemgiaodichActivity.this.getApplicationContext(), ListGiaoDichMainActivity.class);
                    ThemgiaodichActivity.this.startActivityForResult(intent, 8);
                    ThemgiaodichActivity.this.finish();
                } else {
                    Toast.makeText(ThemgiaodichActivity.this.getApplicationContext(), "Bạn cần nhập đầy đủ thông tin.", 0).show();
                    ThemgiaodichActivity.this.sotien.requestFocus();
                }

            }
        });
        List<String> taikhoan = new ArrayList();
        taikhoan.add("Tiền Mặt");
        taikhoan.add("Tiết Kiệm");
        taikhoan.add("Tín Dụng");
        ArrayAdapter<String> adapter = new ArrayAdapter(this, 17367043, taikhoan);
        this.sptk.setAdapter(adapter);
        this.sploaigd = (Spinner)this.findViewById(2131034193);
        List<String> loaigd = new ArrayList();
        loaigd.add("Khoản Thu");
        loaigd.add("Khoản Chi");
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this, 17367043, loaigd);
        this.sploaigd.setAdapter(adapter1);
        this.spinphannhom = (Spinner)this.findViewById(2131034199);
        this.sploaigd.setOnItemSelectedListener(this);
        this.spintrangthai = (Spinner)this.findViewById(2131034201);
        List<String> trangthai = new ArrayList();
        trangthai.add("Đã Trã");
        trangthai.add("Chưa Trả");
        ArrayAdapter<String> adap = new ArrayAdapter(this, 17367043, trangthai);
        this.spintrangthai.setAdapter(adap);
    }

    protected Dialog onCreateDialog(int id) {
        switch(id) {
            case 0:
                return new DatePickerDialog(this, this.mDateSetListener, this.mYear, this.mMonth, this.mDay);
            default:
                return null;
        }
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

    @SuppressLint("ResourceType")
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sp1 = this.sploaigd.getSelectedItem().toString();
        ArrayList list;
        int i;
        ArrayAdapter dataAdapter;
        if(sp1.contentEquals("Khoản Chi")) {
            list = new ArrayList();

            for(i = 0; i < this.db.getAllNames(this.spinkhoanchi).size(); ++i) {
                list.add((String)this.db.getAllNames(this.spinkhoanchi).get(i));
            }

            dataAdapter = new ArrayAdapter(this, 17367043, list);
            dataAdapter.notifyDataSetChanged();
            this.spinphannhom.setAdapter(dataAdapter);
        }

        if(sp1.contentEquals("Khoản Thu")) {
            list = new ArrayList();

            for(i = 0; i < this.db.getAllNames(this.spinkhoanthu).size(); ++i) {
                list.add((String)this.db.getAllNames(this.spinkhoanthu).get(i));
            }

            dataAdapter = new ArrayAdapter(this, 17367043, list);
            dataAdapter.notifyDataSetChanged();
            this.spinphannhom.setAdapter(dataAdapter);
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
}

