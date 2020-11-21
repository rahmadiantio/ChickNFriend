package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.HidanganEntity;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Storage.HidanganRepository;


public class HidanganViewModel extends AndroidViewModel {
    private HidanganRepository hidanganRepository;
    private LiveData<List<HidanganEntity>> listHidangan;

    public HidanganViewModel(@NonNull Application application) {
        super(application);
        hidanganRepository = new HidanganRepository(application);
        listHidangan = hidanganRepository.getAllHidangan();
    }

    public void insert(HidanganEntity hidanganEntity){
        hidanganRepository.registerHidangan(hidanganEntity);
    }

    public void update(HidanganEntity hidanganEntity){
        hidanganRepository.updateHidangan(hidanganEntity);
    }

    public void delete(HidanganEntity hidanganEntity){
        hidanganRepository.hapusHidangan(hidanganEntity);
    }

    public void deleteAllHidangan(){
        hidanganRepository.hapusAllHidangan();
    }

    public LiveData<List<HidanganEntity>> getAllHidangan(){
        return listHidangan;
    }
}
