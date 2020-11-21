package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.api;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.Hidangan;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.Komentar;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.Pelanggan;

public class Value {
    Boolean success;
    List<Hidangan> hidangan;
    List<Komentar> komentar;
    List<Pelanggan> pelanggan;
    String message;

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
    public List<Hidangan> getHidangan() {
        return hidangan;
    }
    public List<Komentar> getKomentar(){
        return komentar;
    }

    public List<Pelanggan> getPelanggan() {
        return pelanggan;
    }
}
