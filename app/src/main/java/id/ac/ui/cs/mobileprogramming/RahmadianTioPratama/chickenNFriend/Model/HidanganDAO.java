package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HidanganDAO {
    @Insert
    void registerHidangan (HidanganEntity hidanganEntity);

    @Query("SELECT * FROM hidangan")
    LiveData<List<HidanganEntity>> getAllHidangan();

    @Query("SELECT * FROM hidangan WHERE kategori_hidangan=(:kategori)")
    LiveData<List<HidanganEntity>> getHidanganByKategori(String kategori);

    @Query("DELETE FROM hidangan")
    void hapusAllHidangan();

    @Delete
    void hapusHidangan(HidanganEntity hidanganEntity);

    @Update
    void updateHidangan(HidanganEntity hidanganEntity);
}
