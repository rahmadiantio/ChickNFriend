package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDAO {
    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * FROM users WHERE username=(:username) AND password=(:password)")
    UserEntity login(String username, String password);
}
