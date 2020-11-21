package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {KomentarEntity.class}, version = 1)
public abstract class KomentarDatabase extends RoomDatabase {
    private static final String dbName = "komentar";
    private static KomentarDatabase komentarDatabase;

    public static synchronized KomentarDatabase getKomentarDatabase(Context context){
        if(komentarDatabase == null){
            komentarDatabase = Room.databaseBuilder(context, KomentarDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return komentarDatabase;
    }

    public abstract KomentarDAO komentarDAO();
}
