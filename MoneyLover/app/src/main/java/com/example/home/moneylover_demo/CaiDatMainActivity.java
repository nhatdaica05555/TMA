package com.example.home.moneylover_demo;

import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HOME on 4/5/2018.
 */

public class CaiDatMainActivity extends Activity {
    TextView tv;
    TextView tv1;
    Spinner sp;
    Spinner spthuchi;
    ExpandableListView expcaidat;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listdulieucha;
    EditText themthuchi;
    ImageView btnthemchuchi;
    HashMap<String,List<String>> listdulieucon;
    List<String> list;
    List<String> listthuchi;
    List<String> listphanloai;
    List<String> list1;
    List<String> list2;

    private  String tvkhoanthu="Khoản thu";
    private  String tvkhoanchi="Khoản chi";
    DatabaseHandle db;
    private  int pos;
    Toast mToast;

    public CaiDatMainActivity(){

    }

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.setContentView(2130903064);
        this.tv=(TextView)this.findViewById(2131034225);
        this.tv1=(TextView)this.findViewById(2131034226);
        this.db=new DatabaseHandle(this);
        this.db.open();

        this.list=new ArrayList();
        this.list.add("Khoản thu");
        this.list.add("Khoản chi");

        this.listphanloai=new ArrayList();
        this.listphanloai.add("Tất cả");
        this.listphanloai.add("Khoản chi");
        this.listphanloai.add("Khoản thu");

        this.listthuchi=new ArrayList();
        this.listthuchi.add("Khoản chi");
        this.listthuchi.add("Khoản thu");

        this.sp=(Spinner)this.findViewById(2131034172);
        final ArrayAdapter<String> adapter=new ArrayAdapter(this,17367048,this.listphanloai);
        this.sp.setAdapter(adapter);

        this.spthuchi=(Spinner)this.findViewById(2131034175);
        ArrayAdapter<String> adthuchi=new ArrayAdapter<>(this,17367048,this.listthuchi);
        this.spthuchi.setAdapter(adthuchi);

        this.themthuchi=(EditText)this.findViewById(2131034174);
        this.btnthemchuchi=(ImageView)this.findViewById(2131034176);
        this.expListView=(ExpandableListView)this.findViewById(2131034177);
        this.ListData();
        this.listAdapter= new com.example.home.moneylover_demo.ExpandableListAdapter(this, this.listdulieucha, this.listdulieucon) {
        };


        this.expListView.setAdapter(this.listAdapter);
        this.btnthemchuchi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (CaiDatMainActivity.this.themthuchi.getText().toString().length() > 0) {
                    String spinthuchi = CaiDatMainActivity.this.spthuchi.getSelectedItem().toString();
                    if (CaiDatMainActivity.this.db.kiemtra(spinthuchi, CaiDatMainActivity.this.themthuchi.getText().toString())) {
                        CaiDatMainActivity.this.db.themkhoanthuchi(CaiDatMainActivity.this.spthuchi.getSelectedItem().toString(), CaiDatMainActivity.this.themthuchi.getText().toString());
                        LayoutInflater inflaterx = CaiDatMainActivity.this.getLayoutInflater();
                        @SuppressLint("ResourceType") View mToastViewx = inflaterx.inflate(2130903089, (ViewGroup) null);
                        CaiDatMainActivity.this.mToast = new Toast(CaiDatMainActivity.this);
                        CaiDatMainActivity.this.mToast.setView(mToastViewx);
                        CaiDatMainActivity.this.mToast.show();

                        Intent intent = new Intent(CaiDatMainActivity.this, MainActivity.class);
                        CaiDatMainActivity.this.startActivity(intent);
                        CaiDatMainActivity.this.themthuchi.setText("");
                        CaiDatMainActivity.this.db.close();
                    } else {
                        Toast.makeText(CaiDatMainActivity.this.getApplicationContext(), "Bạn đã nhập giá trị này rồi", 0).show();
                    }

                } else {
                    LayoutInflater inflater = CaiDatMainActivity.this.getLayoutInflater();
                    @SuppressLint("ResourceType") View mToastView = inflater.inflate(2130903077, (ViewGroup) null);
                    CaiDatMainActivity.this.mToast = new Toast(CaiDatMainActivity.this);
                    CaiDatMainActivity.this.mToast.setView(mToastView);
                    CaiDatMainActivity.this.mToast.show();
                    CaiDatMainActivity.this.themthuchi.requestFocus();
                }
            }
        });
        this.sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).toString().equals(((String)CaiDatMainActivity.this.listphanloai.get(0)).toString())){
                    CaiDatMainActivity.this.expListView.expandGroup(0);
                    CaiDatMainActivity.this.expListView.expandGroup(1);
                }
                if(adapterView.getItemAtPosition(i).toString().equals(((String)CaiDatMainActivity.this.listphanloai.get(1)).toString())){
                    CaiDatMainActivity.this.expListView.expandGroup(1);
                    CaiDatMainActivity.this.expListView.collapseGroup(0);
                }

                if(adapterView.getItemAtPosition(i).toString().equals(((String)CaiDatMainActivity.this.listphanloai.get(2)).toString())){
                    CaiDatMainActivity.this.expListView.expandGroup(0);
                    CaiDatMainActivity.this.expListView.collapseGroup(1);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        this.expListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                CaiDatMainActivity.this.pos=i;
                if(!adapterView.getItemAtPosition(i).equals(CaiDatMainActivity.this.list.get(0)) && !adapterView.getItemAtPosition(i).equals(CaiDatMainActivity.this.list.get(1))){
                    if(ExpandableListView.getPackedPositionGroup(l)==0){
                        CaiDatMainActivity.this.xoa(i,CaiDatMainActivity.this.tvkhoanthu);
                    }
                    else if(ExpandableListView.getPackedPositionGroup(l)==1){
                        CaiDatMainActivity.this.xoa(i,CaiDatMainActivity.this.tvkhoanchi);
                    }
                }else {
                    Toast.makeText(CaiDatMainActivity.this, "Không thấy", 1).show();
                }

                return false;
            }
        });


    }
    private void ListData() {
        this.listdulieucha=new ArrayList();
        this.listdulieucon=new HashMap();

        int j;
        for(j=0;j<this.list.size();j++){
            this.listdulieucha.add((String)this.listdulieucha.get(j));
        }

        this.list1=new ArrayList();
        for(j=0;j<this.db.getphanloai(this.tvkhoanthu).size();j++){
            this.list1.add((String)this.db.getphanloai(this.tvkhoanthu).get(j));
        }

        this.list2=new ArrayList();
        for (j=0;j<this.db.getphanloai(this.tvkhoanchi).size();j++){
            this.list2.add((String)this.db.getphanloai(this.tvkhoanchi).get(j));
        }
        this.listdulieucon.put((String) this.listdulieucha.get(0),this.list1);
        this.listdulieucon.put((String) this.listdulieucha.get(1),this.list2);
    }
    @SuppressLint("ResourceType")
    public void xoa(final int location, final String thuchi){
        (new AlertDialog.Builder(this)).setTitle("Chú ý?").setMessage("Bạn có muốn xóa không?").setIcon(2130837633).setPositiveButton("Có",new android.content.DialogInterface.OnClickListener(){
            @TargetApi(11)
            public void onClick(DialogInterface dialog,int id){
                dialog.cancel();
                CaiDatMainActivity.this.db.Delete(CaiDatMainActivity.this.expListView.getItemAtPosition(location).toString(),thuchi);
                LayoutInflater inflater=CaiDatMainActivity.this.getLayoutInflater();
                @SuppressLint("ResourceType")
                View mToastView=inflater.inflate(2130903090,(ViewGroup)null);

                CaiDatMainActivity.this.mToast=new Toast(CaiDatMainActivity.this);
                CaiDatMainActivity.this.mToast.setView(mToastView);
                CaiDatMainActivity.this.mToast.show();
                CaiDatMainActivity.this.db.close();
                Intent intent=new Intent(CaiDatMainActivity.this.getApplicationContext(),MainActivity.class);
                CaiDatMainActivity.this.startActivityForResult(intent,8);
                CaiDatMainActivity.this.finish();
            }


        }).setNegativeButton("Không",new android.content.DialogInterface.OnClickListener(){
            @TargetApi(11)
            public void onClick(DialogInterface dialog, int id){
                dialog.cancel();
            }
        }).show();
    }

}
