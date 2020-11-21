package id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Fragment.CommentFragment;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Fragment.HomeFragment;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.Fragment.UserFragment;
import id.ac.ui.cs.mobileprogramming.RahmadianTioPratama.chickenNFriend.R;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://10.10.22.128:8000/";


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_user:
                    selectedFragment = new UserFragment();
                    break;
                case R.id.navigation_comment:
                    selectedFragment = new CommentFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }
}