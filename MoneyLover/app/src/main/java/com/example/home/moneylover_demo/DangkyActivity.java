package com.example.home.moneylover_demo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HOME on 4/5/2018.
 */

public class DangkyActivity extends BaseAdapter{

    DatabaseHandle db=new DatabaseHandle(this);
    EditText ed1;
    EditText ed2;
    EditText ed3;
    Button bt;
    DatabaseHandle helper=new DatabaseHandle(this);
    ArrayList<DangKy> arrayDangKy;
    EditText ed;
    EditText ed4;
    Button bton;
    public static final String name="pre";
    final Context context=this;
    ArrayList<DangKy> arrayList=new ArrayList();
    public DangkyActivity(){};


    protected void onCreate(Bundle savedsIntanceState){
        super.onCreate(savedsIntanceState);
        this.setConvertView(2130903066);
        this.ed1=(EditText)this.findViewbyId(2131034231);
        this.ed2=(EditText)this.findViewbyId(2131034232);
        this.ed3=(EditText)this.findViewbyId(2131034233);
        this.ed=(EditText)this.findViewbyId(2131034228);
        this.ed4=(EditText)this.findViewbyId(2131034229);
        this.bt=(Button)this.findViewById(2131034234);
        this.bton=(Button)this.findViewById(2131034230);
        this.arrayDangKy=this.db.getAllDangKy();
        TabHost tab = (TabHost)this.findViewById(16908306);
        tab.setup();
        TabHost.TabSpec spec=tab.newTabSpec("t1");
        spec.setContent(2131034182);
        spec.setIndicator("Đăng nhập");
        tab.addTab(spec);
        spec=tab.newTabSpec("t2");
        spec.setContent(2131034183);
        spec.setIndicator("Đăng ký");
        tab.addTab(spec);

        tab.setCurrentTab(0);
        tab.setCurrentTab(0);

        this.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangKy dk=new DangKy(DangkyActivity.this.ed1.getText().toString(),DangkyActivity.this.ed2.getText().toString(),DangkyActivity.this.ed3.getText().toString());
                if(!DangkyActivity.this.ed1.getText().toString().equals("") && !DangkyActivity.this.ed2.getText().toString().equals("") && !DangkyActivity.this.ed3.getText().toString().equals("")){
                    DangkyActivity.this.arrayDangKy.add(dk);
                    DangkyActivity.this.db.addData_DangKy(dk);
                    Toast.makeText(DangkyActivity.this.getApplicationContext(),"Đăng nhập thành công",0).show();
                    DangkyActivity.this.ed1.setText("");
                    DangkyActivity.this.ed2.setText("");
                    DangkyActivity.this.ed3.setText("");
                }else {
                    Toast.makeText(DangkyActivity.this.getApplicationContext(),"Dữ liệu các ô không được để trống",0).show();
                }
            }
        });

        this.bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandle database= new DatabaseHandle((CaiDatMainActivity) DangkyActivity.this.context);
                DangkyActivity.this.arrayList=database.getAllDangKy();
                if(DangkyActivity.this.ed.getText().toString().equals("")||DangkyActivity.this.ed4.getText().toString().equals("")){
                    Toast.makeText(DangkyActivity.this.getApplicationContext(),"Tên đăng nhập và mật khẩu không được để trống",0).show();
                }

                for(int i = 0; i < DangkyActivity.this.arrayList.size(); ++i) {
                    DangKy in = (DangKy)DangkyActivity.this.arrayList.get(i);
                    String u = in.getTenDangnhap();
                    String p = in.getMatKhau();
                    if(DangkyActivity.this.ed.getText().toString().equals(u) && DangkyActivity.this.ed4.getText().toString().equals(p)) {
                        Toast.makeText(DangkyActivity.this.context, "Đăng nhập thành công", 0).show();
                        Intent intt = new Intent(DangkyActivity.this, MainActivity.class);
                        DangkyActivity.this.startActivity(intt);
                        DangkyActivity.this.savePreferences(u, p);
                        DangkyActivity.this.ed.setText(u);
                        DangkyActivity.this.ed4.setText(p);
                    } else {
                        Toast.makeText(DangkyActivity.this.context, "Đăng nhập không thành công", 0).show();
                        DangkyActivity.this.ed.setText("");
                        DangkyActivity.this.ed4.setText("");
                    }
                }

            }
        });
    }

    protected void savePreferences(String uSname,String pass){
        SharedPreferences share = this.getSharePreferences("pre",0);
        SharedPreferences.Editor editor=share.edit();
        editor.putString("a",uSname);
        editor.putString("b",pass);
        editor.commit();

    }
    public boolean onCreateOptionsMenu(Menu menu){
        this.getMenuInflater().inflate(2131492865,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        return id==2131034235?true:super.onOptionsItemSelected(item);
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
