package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Storage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.HidanganDAO;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.HidanganDatabase;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.HidanganEntity;

public class HidanganRepository {
    private HidanganDAO hidanganDAO;
    private LiveData<List<HidanganEntity>> listHidangan;

    public HidanganRepository(Application application){
        HidanganDatabase database = HidanganDatabase.getHidanganDatabase(application);
        hidanganDAO = database.hidanganDAO();
        listHidangan = hidanganDAO.getAllHidangan();
    }

    public void registerHidangan(HidanganEntity hidanganEntity){
        new InsertHidanganAsyncTask(hidanganDAO).execute(hidanganEntity);
    }

    public void updateHidangan(HidanganEntity hidanganEntity){
        new updateHidanganAsyncTask(hidanganDAO).execute(hidanganEntity);
    }

    public void hapusHidangan(HidanganEntity hidanganEntity){
        new deleteHidanganAsyncTask(hidanganDAO).execute(hidanganEntity);
    }


    public void hapusAllHidangan(){
        new deleteAllHidanganAsyncTask(hidanganDAO).execute();
    }

    public LiveData<List<HidanganEntity>> getAllHidangan(){
        return listHidangan;
    }

    private static class InsertHidanganAsyncTask extends AsyncTask<HidanganEntity, Void, Void>{
        private HidanganDAO hidanganDAO;
        private InsertHidanganAsyncTask(HidanganDAO hidanganDAO){
            this.hidanganDAO = hidanganDAO;
        }
        @Override
        protected Void doInBackground(HidanganEntity... hidanganEntities) {
            hidanganDAO.registerHidangan(hidanganEntities[0]);
            return null;
        }
    }

    private static class updateHidanganAsyncTask extends AsyncTask<HidanganEntity, Void, Void>{
        private HidanganDAO hidanganDAO;
        private updateHidanganAsyncTask(HidanganDAO hidanganDAO){
            this.hidanganDAO = hidanganDAO;
        }
        @Override
        protected Void doInBackground(HidanganEntity... hidanganEntities) {
            hidanganDAO.updateHidangan(hidanganEntities[0]);
            return null;
        }
    }

    private static class deleteHidanganAsyncTask extends AsyncTask<HidanganEntity, Void, Void>{
        private HidanganDAO hidanganDAO;
        private deleteHidanganAsyncTask(HidanganDAO hidanganDAO){
            this.hidanganDAO = hidanganDAO;
        }
        @Override
        protected Void doInBackground(HidanganEntity... hidanganEntities) {
            hidanganDAO.hapusHidangan(hidanganEntities[0]);
            return null;
        }
    }

    private static class deleteAllHidanganAsyncTask extends AsyncTask<Void, Void, Void>{
        private HidanganDAO hidanganDAO;
        private deleteAllHidanganAsyncTask(HidanganDAO hidanganDAO){
            this.hidanganDAO = hidanganDAO;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            hidanganDAO.hapusAllHidangan();
            return null;
        }
    }
}
