package com.example.home.moneylover_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by HOME on 4/5/2018.
 */

public class ChoActivity extends ActionBarActivity {
    public ChoActivity(){}

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(2130903065);
        (new Timer()).schedule(new TimerTask() {
            @Override
            public void run() {
                ChoActivity.this.startActivity(new Intent(ChoActivity.this,DangkyActivity.class));
                }
            },2000L);
        }
        public boolean onCreateOptionMenu(Menu menu){
            this.getMenuInflater().inflate(2131492864,menu);
            return true;
        }
        public boolean onOptionsItemSelected(MenuItem item){
            int id=item.getItemId();
            return id==2131034235?true:super.onOptionsItemSelected(item);
        }

}
