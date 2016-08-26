package com.sarmag.neobyte.makeup;

/**
 * Created by neobyte on 2/12/2016.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper{
    private static Database sInstance;
    private static final String DB_NAME = "db_makeup";
    private static final String create_warna = "CREATE TABLE IF NOT EXISTS tbl_warna(id INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, kd_kesan TEXT, s_kesan TEXT)";
    private static final String create_b_wajah= "CREATE TABLE IF NOT EXISTS tbl_wajah(id INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, kd_bentuk TEXT, s_bentuk)";
    private static final String create_hidung = "CREATE TABLE IF NOT EXISTS tbl_hidung(id INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, kd_hidung TEXT, s_hidung TEXT)";
    private static final String create_bibir = "CREATE TABLE IF NOT EXISTS tbl_bibir(id INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, kd_bibir TEXT, s_bibir TEXT)";
    private static final String create_mata = "CREATE TABLE IF NOT EXISTS tbl_mata(id INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, kd_mata TEXT, s_mata TEXT)";
    private static final String create_solusi = "CREATE TABLE IF NOT EXISTS tbl_solusi(id INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, kd_solusi TEXT, solusi TEXT)";

    /**public static synchronized Database getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new Database(context.getApplicationContext());
        }
        return sInstance;
    }**/

    public Database(Context context) {
        super(context, DB_NAME, null, 7);
        // dari https://kholisilkom45.wordpress.com/2014/05/04/membuat-aplikasi-kuis-dengan-gambar-dari-database-sqlite/
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_warna);
        db.execSQL(create_b_wajah);
        db.execSQL(create_hidung);
        db.execSQL(create_bibir);
        db.execSQL(create_mata);
        db.execSQL(create_solusi);

        ContentValues values = new ContentValues();

        values.put("kd_kesan", "f1");
        values.put("s_kesan", "Terapkan warna berani, misal biru elektrik");
        db.insert("tbl_warna", "kd_kesan", values);

        values.put("kd_kesan", "f2");
        values.put("s_kesan", "Terapkan warna muda dan pastel, misal pink, coklat, hijau, lime");
        db.insert("tbl_warna", "kd_kesan", values);

        values.put("kd_kesan", "f3");
        values.put("s_kesan", "Terapkan warna terang dan modern, misal shocking pink, ungu muda, maroon");
        db.insert("tbl_warna", "kd_kesan", values);

        values.put("kd_kesan", "g1");
        values.put("s_kesan", "Terapkan warna cerah, misal shocking pink");
        db.insert("tbl_warna", "kd_kesan", values);

        values.put("kd_kesan", "g2");
        values.put("s_kesan", "Terapkan warna perona mata senada dengan kulit, misal orange muda");
        db.insert("tbl_warna", "kd_kesan", values);

        values.put("kd_kesan", "g3");
        values.put("s_kesan", "Terapkan warna modern, misal hijau muda, ungu muda, cokelat muda");
        db.insert("tbl_warna", "kd_kesan", values);

        values.put("kd_kesan", "i1");
        values.put("s_kesan", "Terapkan warna perona mata yang cerah, misal biru atau hijau lime");
        db.insert("tbl_warna", "kd_kesan", values);

        values.put("kd_kesan", "i2");
        values.put("s_kesan", "Terapkan warna perona mata yang tidak mencolok, misal coklat muda, kuning keemasan, atau peach");
        db.insert("tbl_warna", "kd_kesan", values);

        values.put("kd_kesan", "i3");
        values.put("s_kesan", "Terapkan warna modern, misal gold atau tembaga");
        db.insert("tbl_warna", "kd_kesan", values);
        values.clear();
        values.put("kd_bentuk", "j1");
        values.put("s_bentuk", "Untuk memberi kesan wajah lebih lebar, aplikasikan perona pipi secara horizontal di sepanjang pipi sampai telinga");
        db.insert("tbl_wajah", "kd_bentuk", values);

        values.put("kd_bentuk", "j2");
        values.put("s_bentuk", "Fokuskan riasa pada mata");
        db.insert("tbl_wajah", "kd_bentuk", values);

        values.put("kd_bentuk", "j3");
        values.put("s_bentuk", "Agar wajah tidak terkesan terlalu tajam, aplikasikan shading pada dagu");
        db.insert("tbl_wajah", "kd_bentuk", values);
        values.clear();

        values.put("kd_hidung", "k1");
        values.put("s_hidung", "Aplikasikan shading di sepanjang kiri dan kanan batang hidung");
        db.insert("tbl_hidung", "kd_hidung", values);

        values.put("kd_hidung", "k2");
        values.put("s_hidung", "Aplikasikan shading pada tepi luar batang hidung");
        db.insert("tbl_hidung", "kd_hidung", values);

        values.put("kd_hidung", "k3");
        values.put("s_hidung", "Aplikasikan shading pada cuping hidung");
        db.insert("tbl_hidung", "kd_hidung", values);

        values.put("kd_hidung", "k4");
        values.put("s_hidung", "Beri highlight pada bagian hidung yang tidak menonjol");
        db.insert("tbl_hidung", "kd_hidung", values);
        values.clear();

        values.put("kd_bibir", "l1");
        values.put("s_bibir", "Gunakan lipstick berjenis matte");
        db.insert("tbl_bibir", "kd_bibir", values);

        values.put("kd_bibir", "l2");
        values.put("s_bibir", "Hindari penggunaan lipstick berwarna gelap");
        db.insert("tbl_bibir", "kd_bibir", values);

        values.put("kd_bibir", "l3");
        values.put("s_bibir", "Gunakan lip gloss");
        db.insert("tbl_bibir", "kd_bibir", values);

        values.put("kd_bibir", "l4");
        values.put("s_bibir", "Bingkai bibir dengan liptiner yang sudutnya ditarik ke arah atas");
        db.insert("tbl_bibir", "kd_bibir", values);
        values.clear();

        values.put("kd_mata", "n1");
        values.put("s_mata", "Beri penekanan pada bagian sudut luar untuk memberikan kesan mata yang panjang");
        db.insert("tbl_mata", "kd_mata", values);

        values.put("kd_mata", "n2");
        values.put("s_mata","Bubuhkan highlight pada tulang alis, dan ulaskan pada seluruh kelopak mata");
        db.insert("tbl_mata", "kd_mata", values);

        values.put("kd_mata", "n3");
        values.put("s_mata","Bubuhkan highlight pada tulang alis, dari mulai ujung dalam sampai sudut luar mata");
        db.insert("tbl_mata", "kd_mata", values);

        values.put("kd_mata", "n4");
        values.put("s_mata","Aplikasikan eyeliner warna putih pada mata bagian dalam, bingkai mata dengan eyeliner warna gelap");
        db.insert("tbl_mata", "kd_mata", values);

        values.put("kd_mata", "n5");
        values.put("s_mata","Aplikasikan perona mata berwarna terang pada sudut luar kelopak mata");
        db.insert("tbl_mata", "kd_mata", values);

        values.put("kd_mata", "n6");
        values.put("s_mata","Gunakan kuas eyeliner untuk mengaplikasikan perona mata warna coklat muda pada sudut dalam garis bulu mata atas dan bawah");
        db.insert("tbl_mata", "kd_mata", values);

        values.put("kd_mata","n7");
        values.put("s_mata","Agar mata terlihat lebih jauh, aplikasikan perona mata berwarna terang pada sudut dalam kelopak mata");
        db.insert("tbl_mata","kd_mata",values);

    }

    public List<solusi> getSol(String nama_tbl){
        List<solusi> listSolusi = new ArrayList<>();
        String query = "select * from "+nama_tbl;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                solusi s = new solusi();
                s.setkode(cursor.getString(1));
                s.setSaran(cursor.getString(2));
                listSolusi.add(s);
                Log.d("isi tabel getsol", "Kode :" + s.getkode());
                Log.d("isi tabel getsol","Saran :" + s.getSaran());
            }while(cursor.moveToNext());
        }
        cursor.close();
        return listSolusi;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS db_makeup");
        this.onCreate(db);
    }

    public String carisol(String cari, String nama_tbl, String kol_kode, String s_kode) {
        SQLiteDatabase db = this.getReadableDatabase();
        String saran=null;
        String[] kolom = new String[]{kol_kode,s_kode};
        Cursor cursor = db.query(nama_tbl, kolom, kol_kode + "='" + cari + "'", null, null, null, null);
        if (cursor!=null) {
            cursor.moveToFirst();
            saran = cursor.getString(1);
            cursor.close();
        }
        db.close();
        return saran;
    }

    public void hapussol(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("DELETE FROM tbl_solusi");
        db.close();
    }
}
