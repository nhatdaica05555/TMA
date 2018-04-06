package lop_dangky;

/**
 * Created by HOME on 4/6/2018.
 */

public class DangKy {
    String tenDangnhap;
    String matKhau;
    String reMatkhau;

    public DangKy() {
    }

    public DangKy(String tenDangnhap, String matKhau, String reMatkhau) {
        this.tenDangnhap = tenDangnhap;
        this.matKhau = matKhau;
        this.reMatkhau = reMatkhau;
    }

    public String getTenDangnhap() {
        return this.tenDangnhap;
    }

    public void setTenDangnhap(String tenDangnhap) {
        this.tenDangnhap = tenDangnhap;
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getReMatkhau() {
        return this.reMatkhau;
    }

    public void setReMatkhau(String reMatkhau) {
        this.reMatkhau = reMatkhau;
    }

    public String toString() {
        return "DangKy [ tenDangnhap=" + this.tenDangnhap + ", matKhau=" + this.matKhau + ", reMatkhau=" + this.reMatkhau + "]";
    }
}
