package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface KomentarDAO {
    @Insert
    void registerKomentar(KomentarEntity komentarEntity);

    @Query("SELECT * FROM komentar WHERE idUser=(:idUser)")
    KomentarEntity getAllKomentar(Integer idUser);
}
