package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.Hidangan;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.Komentar;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "restoran.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Hidangan.CREATE_TABLE);
        db.execSQL(Komentar.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Hidangan.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Komentar.TABLE_NAME);
        onCreate(db);
    }

    public long insertHidangan(String nama, String deskripsi, String kategori, String harga, String foto) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Hidangan.COLUMN_NAMA, nama);
        values.put(Hidangan.COLUMN_DESKRIPSI, deskripsi);
        values.put(Hidangan.COLUMN_KATEGORI, kategori);
        values.put(Hidangan.COLUMN_HARGA, harga);
        values.put(Hidangan.COLUMN_FOTO, foto);

        long id = db.insert(Hidangan.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public List<Hidangan> getHidanganperKategori(String kategori){
        List<Hidangan> hidanganList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(Hidangan.TABLE_NAME,
                new String[]{Hidangan.COLUMN_ID, Hidangan.COLUMN_NAMA, Hidangan.COLUMN_DESKRIPSI, Hidangan.COLUMN_HARGA, Hidangan.COLUMN_KATEGORI},
                Hidangan.COLUMN_KATEGORI + "=?",
                new String[]{kategori}, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Hidangan hidangan = new Hidangan();
                hidangan.setNama_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_NAMA)));
                hidangan.setDeskripsi_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_DESKRIPSI)));
                hidangan.setHarga_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_HARGA)));
                hidangan.setKategori_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_KATEGORI)));
                hidanganList.add(hidangan);
            } while (cursor.moveToNext());
        }
        db.close();
        return hidanganList;
    }

    public List<Hidangan> getAllHidangan() {
        List<Hidangan> hidanganList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + Hidangan.TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Hidangan hidangan = new Hidangan();
                hidangan.setNama_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_NAMA)));
                hidangan.setDeskripsi_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_DESKRIPSI)));
                hidangan.setHarga_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_HARGA)));
                hidangan.setKategori_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_KATEGORI)));
                hidangan.setFoto_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_FOTO)));
                hidanganList.add(hidangan);
            } while (cursor.moveToNext());
        }
        db.close();
        return hidanganList;
    }

    public List<Hidangan> getHidanganLimit() {
        List<Hidangan> hidanganList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + Hidangan.TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            int i = 0;
            do {
                Hidangan hidangan = new Hidangan();
                hidangan.setNama_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_NAMA)));
                hidangan.setDeskripsi_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_DESKRIPSI)));
                hidangan.setHarga_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_HARGA)));
                hidangan.setKategori_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_KATEGORI)));
                hidangan.setFoto_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_FOTO)));
                hidanganList.add(hidangan);
                i++;
            } while (cursor.moveToNext() && i<5);
        }
        db.close();
        return hidanganList;
    }

    public int getHidanganCount() {
        List<Hidangan> hidanganList = new ArrayList<>();
        String countQuery = "SELECT  * FROM " + Hidangan.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Hidangan hidangan = new Hidangan();
                hidangan.setNama_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_NAMA)));
                hidangan.setDeskripsi_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_DESKRIPSI)));
                hidangan.setHarga_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_HARGA)));
                hidangan.setKategori_hidangan(cursor.getString(cursor.getColumnIndex(Hidangan.COLUMN_KATEGORI)));
                hidanganList.add(hidangan);
            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        int count = hidanganList.size();
        return count;
    }

    public long insertKomentar(String id, String komentar, String tanggal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Komentar.COLUMN_ID, id);
        values.put(Komentar.COLUMN_KOMENTAR, komentar);
        values.put(Komentar.COLUMN_TANGGAL_KOMENTAR, tanggal);

        long ids = db.insert(Komentar.TABLE_NAME, null, values);
        db.close();
        return ids;
    }

    public List<Komentar> getAllKomentar(){
        List<Komentar> komentarList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + Komentar.TABLE_NAME ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Komentar komentar = new Komentar();
                komentar.setIsi_komentar(cursor.getString(cursor.getColumnIndex(Komentar.COLUMN_KOMENTAR)));
                komentarList.add(komentar);
            } while (cursor.moveToNext());
        }
        db.close();
        return komentarList;
    }

    public int getKomentarCount() {
        List<Komentar> komentarList = new ArrayList<>();
        String countQuery = "SELECT  * FROM " + Komentar.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Komentar komentar = new Komentar();
                komentar.setIsi_komentar(cursor.getString(cursor.getColumnIndex(Komentar.COLUMN_KOMENTAR)));
                komentarList.add(komentar);
            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        int count = komentarList.size();
        return count;
    }
}
