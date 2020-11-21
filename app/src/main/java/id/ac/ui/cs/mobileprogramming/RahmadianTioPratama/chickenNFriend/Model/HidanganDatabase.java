package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {HidanganEntity.class}, version = 1)
public abstract class HidanganDatabase extends RoomDatabase {
    private static final String dbName = "hidangan";
    private static HidanganDatabase hidanganDatabase;

    public static synchronized HidanganDatabase getHidanganDatabase(Context context){
        if(hidanganDatabase == null){
            hidanganDatabase = Room.databaseBuilder(context, HidanganDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return hidanganDatabase;
    }

    public abstract HidanganDAO hidanganDAO();
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(hidanganDatabase);
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private HidanganDAO hidanganDAO;
        private PopulateDbAsyncTask(HidanganDatabase database){
            hidanganDAO = database.hidanganDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            hidanganDAO.registerHidangan(new HidanganEntity("Ayam Saus Yakult",
                    "Ayam yang dilengkapi saus yakult", "Makanan",
                    "ada", "Rp 20.000,-"));
            hidanganDAO.registerHidangan(new HidanganEntity("Ayam Saus Asam Manis",
                    "Ayam yang dilengkapi saus asam manis", "Makanan",
                    "ada", "Rp 20.000,-"));
            hidanganDAO.registerHidangan(new HidanganEntity("Es Teh Manis",
                    "Teh dengan daun teh alami", "Minuman",
                    "ada", "Rp 20.000,-"));
            hidanganDAO.registerHidangan(new HidanganEntity("Es Blewah",
                    "Minuman dengan campuran buah-buahan", "Minuman",
                    "ada", "Rp 20.000,-"));
            return null;
        }
    }
}
