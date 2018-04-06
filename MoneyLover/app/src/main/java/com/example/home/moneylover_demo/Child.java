package com.example.home.moneylover_demo;

/**
 * Created by HOME on 4/5/2018.
 */

public class Child {
    private String PhanLoai;
    private String KhoanThuKhoanChi;

    public Child(){}

    public Child(String phanLoai, String khoanThuKhoanChi) {
        PhanLoai = phanLoai;
        KhoanThuKhoanChi = khoanThuKhoanChi;
    }

    public String getPhanLoai() {
        return PhanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        PhanLoai = phanLoai;
    }

    public String getKhoanThuKhoanChi() {
        return KhoanThuKhoanChi;
    }

    public void setKhoanThuKhoanChi(String khoanThuKhoanChi) {
        KhoanThuKhoanChi = khoanThuKhoanChi;
    }
}
