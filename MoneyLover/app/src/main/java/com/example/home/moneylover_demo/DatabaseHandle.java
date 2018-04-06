package com.example.home.moneylover_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HOME on 4/5/2018.
 */

class DatabaseHandle {

    private static final String DATABASE_NAME="quanlychitieu";
    private static final int DATABASE_ver=1;
    static final String TABLE_NAME="giaodich";
    static final String TABLE_NAME2="thuchi";
    static final String COLUMN_ID="id";
    static final String COLUMN_KHOANTHUKHOANCHI="khoanthukhoanchi";
    static final String COLUMN_PHANLOAI="phanloai";
    static final String CLOUMN_LOAIGIAODICH="loaigiaodich";
    static final String COLUMN_TAIKHOAN="taikhoan";
    static final String COLUMN_SOTIEN="sotien";
    static final String COLUMN_LYDO="lydo";
    static final String COLUMN_PHANNHOM="phannhom";
    static final String COLUMN_NGAYGIAODICH="ngaygiaodich";
    static final String COLUMN_NGAY="ngay";
    static final String COLUMN_THANG="thang";
    static final String COLUMN_NAM="nam";

    private Context _context;
    private static Context context;
    static SQLiteDatabase db;
    SQLiteDatabase db1;
    static DatabaseHandle.OpenHelper openHelper;


    public DatabaseHandle(Context context) {
        this.context = context;
    }
    public DatabaseHandle open()throws SQLException{
        openHelper=new DatabaseHandle.OpenHelper(context);
        db=openHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        openHelper.close();
    }
    public long themkhoanthuchi(String khoanthukhoanchi,String phanloai){
        ContentValues cv=new ContentValues();
        cv.put("khoanthukhoanchi",khoanthukhoanchi);
        cv.put("phanloai",phanloai);
        return db.insert("thuchi",(String)null,cv);
    }
    public void Delete(String phanloai,String khoanthukhoanchi){
        db.execSQL("DELETE FROM thuchi WHERE phanloai='"+phanloai+"'"+ "AND" +"khoanthukhoanchi" + "='"+khoanthukhoanchi+"'");
        db.close();
    }
    public void Deletels(String ngaygiaodich,String lydo,String sotien,String taikhoan){
        db.execSQL("DELETE FROM giaodich WHERE ngaygiaodich='" + ngaygiaodich +"'" + "AND"+"lydo" + "='"
        +lydo+"'"+"AND"+"sotien"+"='" +sotien +"'" + "AND"+"taikhoan"+"='"+taikhoan+"'");
        db.close();

    }
    public long themgiaodich(String taikhoan, String loaigiaodich,String sotien, String lydo,String phannhom,String ngaygiaodich,String ngay, String thang, String nam){
        ContentValues cvl=new ContentValues();
        cvl.put("taikhoan",taikhoan);
        cvl.put("loaigiaodich",loaigiaodich);
        cvl.put("sotien",sotien);
        cvl.put("lydo",lydo);
        cvl.put("phannhom",phannhom);
        cvl.put("ngaygiaodich",ngaygiaodich);
        cvl.put("ngay",ngay);
        cvl.put("thang",thang);
        cvl.put("nam",nam);

        return db.insert("giaodich",(String)null,cvl);

    }
    public List<String> getAllNames(String thuchi){
        List<String> names=new ArrayList();
        String selectQuery="SELECT phanloai FROM thuchi WHERE khoanthukhoanchi ='"+thuchi+"'";
        Cursor cursor =db.rawQuery(selectQuery,(String[])null);
        if(cursor.moveToFirst()){
            do{
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    public List<String>getloggiaodich(String phanloai){
        List<String> names=new ArrayList();
        String selectQuery="SELECT distinct phannhom FROM giaodich WHERE loaigiaodich= '"+phanloai+"'";
        Cursor cursor=db.rawQuery(selectQuery,(String[])null);
        if(cursor.moveToFirst()){
            do{
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    public List<String> getloggiaodichhomnay(String phanloai){
        List<String> names=new ArrayList();
        String selectQuery="SELECT distinct phannhom FROM giaodich WHERE loaigiaodich='"+phanloai+"'and ngay=strftime('%d,'now') and thang = strftime('%m','now') and nam=strftime('%Y','now')";
        Cursor cursor= db.rawQuery(selectQuery,(String[])null);
        if(cursor.moveToFirst()){
            do {
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    public List<String> getloggiaodichthangnay(String phanloai){
        List<String> names=new ArrayList();
        String selectQuery="SELECT distinct phannhom FROM giaodich WHERE loaigiaodich='"+phanloai+"'thang = strftime('%m','now') and nam=strftime('%Y','now')";
        Cursor cursor= db.rawQuery(selectQuery,(String[])null);
        if(cursor.moveToFirst()){
            do {
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    public List<String> getloggiaodichnamnay(String phanloai){
        List<String> names=new ArrayList();
        String selectQuery="SELECT distinct phannhom FROM giaodich WHERE loaigiaodich='"+phanloai+"'nam=strftime('%Y','now')";
        Cursor cursor= db.rawQuery(selectQuery,(String[])null);
        if(cursor.moveToFirst()){
            do {
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    public List<String> getloggiaodichnamnay1(String phanloai){
        List<String> names=new ArrayList();
        String selectQuery="SELECT distinct phannhom FROM giaodich WHERE loaigiaodich='"+phanloai+"'nam=strftime('%Y','now')";
        Cursor cursor= db.rawQuery(selectQuery,(String[])null);
        if(cursor.moveToFirst()){
            do {
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    public List<String> getloggiaodichthangnay1(String phanloai){
        List<String> names=new ArrayList();
        String selectQuery="SELECT distinct phannhom FROM giaodich WHERE loaigiaodich='"+phanloai+"'thang = strftime('%m','now') and nam=strftime('%Y','now')";
        Cursor cursor= db.rawQuery(selectQuery,(String[])null);
        if(cursor.moveToFirst()){
            do {
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    public List<String> getloggiaodichhomnay1(String phanloai){
        List<String> names=new ArrayList();
        String selectQuery="SELECT distinct phannhom FROM giaodich WHERE loaigiaodich='"+phanloai+"'and ngay=strftime('%d,'now') and thang = strftime('%m','now') and nam=strftime('%Y','now')";
        Cursor cursor= db.rawQuery(selectQuery,(String[])null);
        if(cursor.moveToFirst()){
            do {
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }
    public List<String> getlognam(String phanloai){
        List<String> names=new ArrayList();
        String selectQuery="SELECT phannhom FROM giaodich WHERE nam='2015'";
        Cursor cursor=db.rawQuery(selectQuery,(String[])null);
        if (cursor.moveToFirst()){
            do{
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }

    public List<String> getloggiaodich1(String phanloai){
        List<String> names= new ArrayList();
        String selectQuery="SELECT distinct phannhom FROM giaodich WHERE loaigiaodich='"+phanloai+"'";
        Cursor cursor=db.rawQuery(selectQuery,(String[])null);
        if (cursor.moveToFirst()){
            do {
                names.add(cursor.getString(0));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }


    public List<String> getsotien(String phannhom, String loaigiaodich) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT sum(sotien) FROM giaodich where phanhom = '" + phannhom + "' AND " + "loaigiaodich" + " = '" + loaigiaodich + "'";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<String> getsotienhomnay(String phannhom, String loaigiaodich) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT  sum(sotien) FROM giaodich where phanhom = '" + phannhom + "' and " + "loaigiaodich" + " = '" + loaigiaodich + "' and ngay = strftime('%d','now') and  thang = strftime('%m','now') and nam =strftime('%Y','now');";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<String> getsotienthangnay(String phannhom, String loaigiaodich) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT  sum(sotien) FROM giaodich where phanhom = '" + phannhom + "' and " + "loaigiaodich" + " = '" + loaigiaodich + "'  and  thang = strftime('%m','now') and nam =strftime('%Y','now');";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<String> getsotiennamnay(String phannhom, String loaigiaodich) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT  sum(sotien) FROM giaodich where phanhom = '" + phannhom + "' and " + "loaigiaodich" + " = '" + loaigiaodich + "'  and nam =strftime('%Y','now');";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<Lichsu> lichsugiaodich() {
        ArrayList<Lichsu> lichsugiaodich = new ArrayList();
        String selectQuery = "SELECT ngaygiaodich,lydo,sotien,taikhoan FROM giaodich";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                Lichsu contacts = new Lichsu();
                contacts.setTime(cursor.getString(0));
                contacts.setPhanloai(cursor.getString(1));
                contacts.setSotien(cursor.getString(2));
                contacts.setTaikhoan(cursor.getString(3));
                lichsugiaodich.add(contacts);
            } while(cursor.moveToNext());
        }

        cursor.close();
        return lichsugiaodich;
    }

    public List<String> getphanloai(String khoanthuchi) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT phanloai FROM  thuchi where khoanthukhoanchi = '" + khoanthuchi + "'";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<String> tongtien(String thuchi) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT sum ( sotien ) FROM giaodich where loaigiaodich= '" + thuchi + "'";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<String> tongtienhomnay(String thuchi) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT sum ( sotien ) FROM giaodich where loaigiaodich= '" + thuchi + "' and ngay = strftime('%d','now') and  thang = strftime('%m','now') and nam =strftime('%Y','now');";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<String> tongtienthangnay(String thuchi) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT sum ( sotien ) FROM giaodich where loaigiaodich= '" + thuchi + "' and  thang = strftime('%m','now') and nam =strftime('%Y','now');";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<String> tongtiennamnay(String thuchi) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT sum ( sotien ) FROM giaodich where loaigiaodich= '" + thuchi + "' and nam =strftime('%Y','now');";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        return names;
    }

    public List<String> taikhoan(String thuchi) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT sum ( sotien ) FROM giaodich where taikhoan= '" + thuchi + "'";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.getCount() > 0) {
            if(cursor != null & cursor.moveToFirst()) {
                do {
                    names.add(cursor.getString(0));
                } while(cursor.moveToNext());
            }

            cursor.close();
        }

        return names;
    }

    public boolean kiemtra(String spinthuchi, String kiemtra) {
        List<String> names = new ArrayList();
        String selectQuery = "SELECT  COUNT(*) from thuchi where phanloai='" + kiemtra + "'" + " AND " + "khoanthukhoanchi" + "=" + "'" + spinthuchi + "'";
        Cursor cursor = db.rawQuery(selectQuery, (String[])null);
        if(cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        int so = Integer.parseInt((String)names.get(0));
        return so == 0;
    }

    static class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, "quanlychitieu", (SQLiteDatabase.CursorFactory)null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table giaodich ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,taikhoan text,loaigiaodich text,sotien text,lydo text,phanhom text,ngaygiaodich text,ngay text,thang text,nam text);");
            db.execSQL("create table thuchi ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,khoanthukhoanchi text,phanloai text);");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS giaodich");
            this.onCreate(db);
        }
    }

}
