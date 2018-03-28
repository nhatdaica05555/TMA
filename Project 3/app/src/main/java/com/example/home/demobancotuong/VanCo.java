package com.example.home.demobancotuong;

/**
 * Created by HOME on 3/28/2018.
 */

public class VanCo {
    public static NguoiChoi[] NguoiChoi = new NguoiChoi[2];
    public static String TenNguoiChoi1;
    public static String TenNguoiChoi2;
    public static boolean DangChoi;
    //public static PictureBox ThongBaoChieuTuong;
    public static Panel ChieuBi = new Panel();
    public static Panel KetQua = new Panel();
    public static Panel ChapCo = new Panel();

    //xác định đã có quân cờ nào được chọn để click
    public static boolean Marked;
    public static QuanCo DanhDau;
    public static int LuotDi;
    public static int winner;
    public static NuocDi[] GameLog;
    public static QuanBiAn[] QuanDoBiAn;
    public static QuanBiAn[] QuanDenBiAN;
    public static boolean Chap;
    public static boolean AmThanh;
    public static boolean NhacNen;
    public static boolean TinhThoiGian;


    public VanCo() {

    }
    public static void NewGame(){}
    public static void DoiLuotDi(){}
    public static void Undo(){
    }
    public static void Save(){}

    public static void Open(){

    }
    public static void oCoTrong(int i, int j){}

    public static void DatQuanCo(Object sender, QuanCo q, int i, int j) {

    }
    public static void ChieuTuong(QuanCo tuong){}
    public static void KiemTraChieuTuong(){}
    public static void AnQuanCo(QuanCo q){}
    public static void KiemTraChieuBi(){}
    public static void ClickSound(String s){}
    public static void PlayNhacNen(boolean nhacNen){}
}
