package com.example.home.moneylover_demo;

import java.util.ArrayList;

/**
 * Created by HOME on 4/6/2018.
 */

public class Nhom {
    private String phanloai;
    private String khoanthukhoanchi;
    private ArrayList<Child> Items;

    public Nhom() {
    }

    public String getPhanloai() {
        return this.phanloai;
    }

    public void setPhanloai(String phanloai) {
        this.phanloai = phanloai;
    }

    public String getKhoanthukhoanchi() {
        return this.khoanthukhoanchi;
    }

    public void setKhoanthukhoanchi(String khoanthukhoanchi) {
        this.khoanthukhoanchi = khoanthukhoanchi;
    }

    public ArrayList<Child> getItems() {
        return this.Items;
    }

    public void setItems(ArrayList<Child> Items) {
        this.Items = Items;
    }


}