package com.example.home.demobancotuong;

/**
 * Created by HOME on 3/28/2018.
 */

public class QuanCo {
    public int Hang;
    public int Cot;
    public String Ten;
    public int Phe;
    public String ThuTu;
    public int TrangThai;
    //chứa hình ảnh Quân cờ
    //public PictureBox picQuanCo = new PictureBox();
    //Thuộc tính khóa không cho người dùng tương tác vào quân cờ để di chuyển
    public boolean Khoa;
    private int i;


    public QuanCo() {

    }

    public QuanCo(int hang, int cot, String ten, int phe, String thuTu, int trangThai, boolean khoa) {
        Hang = hang;
        Cot = cot;
        Ten = ten;
        Phe = phe;
        ThuTu = thuTu;
        TrangThai = trangThai;
        Khoa = khoa;
    }

    public void KhoiTao(int phe, String name, String thutu,int stt,boolean khoa,int x,int y){}

    public void draw(){}

    public void KiemTra(int i, int j){

    }

    public void TuongAnToan(int i, int j){}

    private void picQuanCo_MouseClick(Object sender, MouseEvenArgs e) {

    }
}
