package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Model.Hidangan;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.R;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Storage.DatabaseHelper;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.adapter.RecyclerViewHidanganHorizontal;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.api.RegisterAPI;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.api.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuPerKategoriActivity extends AppCompatActivity {

    private List<Hidangan> hidangans = new ArrayList<>();
    private RecyclerViewHidanganHorizontal viewAdapter;

    TextView tvNamaKategori;
    ImageView ivIconKategori, ivBackHome;


    private DatabaseHelper db;
    RelativeLayout rlNavBar;


    @BindView(R.id.rv_mhs)
    RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidangan_per_kategori);

        tvNamaKategori = findViewById(R.id.tv_nama_kategori);
        ivIconKategori = findViewById(R.id.iv_icon_kategori);
        ivBackHome = findViewById(R.id.iv_back_home);
        rlNavBar = findViewById(R.id.rl_navbar);

        ButterKnife.bind(this);
        viewAdapter = new RecyclerViewHidanganHorizontal(this, hidangans);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        Intent intent = getIntent();
        String kategoriHidangan = intent.getExtras().getString("kategori_hidangan");

        db = new DatabaseHelper(this);
        ivBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        loadMenuKategori(kategoriHidangan);
    }

    private void loadMenuKategori(final String kategori) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final RegisterAPI api = retrofit.create(RegisterAPI.class);

        Call<Value> call = null;
        switch (kategori){
            case "Burger":
                call = api.hidanganKategoriLimit(kategori);
                tvNamaKategori.setText(kategori);
                ivIconKategori.setImageResource(R.drawable.kategori_burger);
                rlNavBar.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case "Ayam":
                call = api.hidanganKategoriLimit(kategori);
                tvNamaKategori.setText(kategori);
                ivIconKategori.setImageResource(R.drawable.kategori_ayam);
                rlNavBar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                break;
            case "Minuman":
                call = api.hidanganKategoriLimit(kategori);
                tvNamaKategori.setText(kategori);
                ivIconKategori.setImageResource(R.drawable.kategori_minuman);
                rlNavBar.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                break;
            case "Dessert":
                call = api.hidanganKategoriLimit(kategori);
                tvNamaKategori.setText(kategori);
                ivIconKategori.setImageResource(R.drawable.kategori_dessert);
                rlNavBar.setBackgroundColor(getResources().getColor(R.color.colorPurple));
                break;
            case "Breakfast":
                call = api.hidanganKategoriLimit(kategori);
                tvNamaKategori.setText(kategori);
                ivIconKategori.setImageResource(R.drawable.kategori_breakfast);
                rlNavBar.setBackgroundColor(getResources().getColor(R.color.colorRed));
        }

        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                hidangans = response.body().getHidangan();
                viewAdapter = new RecyclerViewHidanganHorizontal(MenuPerKategoriActivity.this, hidangans);
                recyclerView.setAdapter(viewAdapter);
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                hidangans = db.getHidanganperKategori(kategori);
                viewAdapter = new RecyclerViewHidanganHorizontal(MenuPerKategoriActivity.this, hidangans);
                recyclerView.setAdapter(viewAdapter);
            }
        });
    }
}