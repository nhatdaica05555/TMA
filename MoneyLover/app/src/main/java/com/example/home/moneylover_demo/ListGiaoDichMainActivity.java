package com.example.home.moneylover_demo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HOME on 4/6/2018.
 */

@SuppressLint({"NewApi"})
public class ListGiaoDichMainActivity extends Activity {
    static final int DATE_DIALOG_ID = 0;
    private ListView mListView;
    private CustomAdapter mCustomAdapter;
    Toast mToast;
    private ArrayList<Lichsu> _Contacts = new ArrayList();
    DatabaseHandle db;
    Lichsu contacts;

    public ListGiaoDichMainActivity() {
    }

    @SuppressLint({"NewApi", "ResourceType"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903069);
        ActionBar actionBar = this.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.db = new DatabaseHandle(this);
        this.db.open();

        for(int i = 0; i < this.db.lichsugiaodich().size(); ++i) {
            this.contacts = new Lichsu();
            this.contacts.setTime(((Lichsu)this.db.lichsugiaodich().get(i)).getTime());
            this.contacts.setPhanloai(((Lichsu)this.db.lichsugiaodich().get(i)).getPhanloai());
            this.contacts.setSotien(((Lichsu)this.db.lichsugiaodich().get(i)).getSotien());
            this.contacts.setTaikhoan(((Lichsu)this.db.lichsugiaodich().get(i)).getTaikhoan());
            this._Contacts.add(this.contacts);
        }

        this.mListView = (ListView)this.findViewById(2131034189);
        this.mCustomAdapter = new CustomAdapter(this, this._Contacts);
        this.mListView.setAdapter(this.mCustomAdapter);
        this.mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListGiaoDichMainActivity.this.delcaidat(position);
                return false;
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 16908332:
                Intent i = new Intent(this.getApplicationContext(), MainActivity.class);
                this.startActivity(i);
                this.finish();
                return true;
            case 2131034237:
                Intent i1 = new Intent(this.getApplicationContext(), ThemgiaodichActivity.class);
                this.startActivity(i1);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("ResourceType")
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(2131492868, menu);
        return true;
    }

    public void delcaidat(final int position) {
        (new Uri.Builder()).setTitle("Chú ý").setMessage("Bạn có chắc xóa không").setIcon(2130837633).setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @TargetApi(11)
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                LayoutInflater inflater = ListGiaoDichMainActivity.this.getLayoutInflater();
                @SuppressLint("ResourceType") View mToastView = inflater.inflate(2130903090, (ViewGroup)null);
                ListGiaoDichMainActivity.this.mToast = new Toast(ListGiaoDichMainActivity.this);
                ListGiaoDichMainActivity.this.mToast.setView(mToastView);
                ListGiaoDichMainActivity.this.mToast.show();
                ListGiaoDichMainActivity.this.db.Deletels(((Lichsu)ListGiaoDichMainActivity.this.db.lichsugiaodich().get(position)).getTime(), ((Lichsu)ListGiaoDichMainActivity.this.db.lichsugiaodich().get(position)).getPhanloai(), ((Lichsu)ListGiaoDichMainActivity.this.db.lichsugiaodich().get(position)).getSotien(), ((Lichsu)ListGiaoDichMainActivity.this.db.lichsugiaodich().get(position)).getTaikhoan());
                Intent intent = new Intent(ListGiaoDichMainActivity.this.getApplicationContext(), ListGiaoDichMainActivity.class);
                ListGiaoDichMainActivity.this.finish();
                ListGiaoDichMainActivity.this.startActivity(intent);
            }
        }).setNegativeButton("Không", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

            @TargetApi(11)
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }
}

