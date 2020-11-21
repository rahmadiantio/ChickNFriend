package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.R;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.api.RegisterAPI;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.api.Value;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    protected EditText etNama, etEmail, etUsernameR, etPasswordR;
    protected TextView tvRegister, tvLogin;
    SharedPreferences sharedPreferences;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        etNama = findViewById(R.id.et_nama);
        etEmail = findViewById(R.id.et_email);
        etUsernameR = findViewById(R.id.et_username_r);
        etPasswordR = findViewById(R.id.et_password_r);
        tvLogin = findViewById(R.id.tv_login_r);
        tvRegister = findViewById(R.id.tv_register_r);

        tvLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //pas tombol register di klik
            case R.id.tv_register_r:
                final String inputNama = etNama.getText().toString();
                final String inputEmail = etEmail.getText().toString();
                final String inputUsername = etUsernameR.getText().toString();
                final String inputPassword = etPasswordR.getText().toString();
                //manggil api
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(MainActivity.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RegisterAPI api = retrofit.create(RegisterAPI.class);
                Call<Value> call = api.register(inputNama, inputEmail, inputUsername, inputPassword);
                call.enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        Boolean success = response.body().getSuccess();
                        if (success){
                            Toast.makeText(RegisterActivity.this, "Akun " + inputNama + " berhasil dibuat!", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Gagal membuat akun", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {

                    }
                });
                break;
            case R.id.tv_login_r:
                Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                break;
        }
    }
}