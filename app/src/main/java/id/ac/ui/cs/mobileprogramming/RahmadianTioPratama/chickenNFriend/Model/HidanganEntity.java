package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hidangan")
public class HidanganEntity {
    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "nama_hidangan")
    String nama_hidangan;

    @ColumnInfo(name = "deskripsi_hidangan")
    String deskripsi_hidangan;

    @ColumnInfo(name = "kategori_hidangan")
    String kategori_hidangan;

    @ColumnInfo(name = "foto_hidangan")
    String foto_hidangan;

    @ColumnInfo(name = "harga_hidangan")
    String harga_hidangan;

    public HidanganEntity(String nama_hidangan, String deskripsi_hidangan,
                          String kategori_hidangan, String foto_hidangan, String harga_hidangan) {
        this.nama_hidangan = nama_hidangan;
        this.deskripsi_hidangan = deskripsi_hidangan;
        this.kategori_hidangan = kategori_hidangan;
        this.foto_hidangan = foto_hidangan;
        this.harga_hidangan = harga_hidangan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama_hidangan() {
        return nama_hidangan;
    }

    public void setNama_hidangan(String nama_hidangan) {
        this.nama_hidangan = nama_hidangan;
    }

    public String getDeskripsi_hidangan() {
        return deskripsi_hidangan;
    }

    public void setDeskripsi_hidangan(String deskripsi_hidangan) {
        this.deskripsi_hidangan = deskripsi_hidangan;
    }

    public String getKategori_hidangan() {
        return kategori_hidangan;
    }

    public void setKategori_hidangan(String kategori_hidangan) {
        this.kategori_hidangan = kategori_hidangan;
    }

    public String getFoto_hidangan() {
        return foto_hidangan;
    }

    public void setFoto_hidangan(String foto_hidangan) {
        this.foto_hidangan = foto_hidangan;
    }

    public String getHarga_hidangan() {
        return harga_hidangan;
    }

    public void setHarga_hidangan(String harga_hidangan) {
        this.harga_hidangan = harga_hidangan;
    }
}