package com.sahitya.banksampahsahitya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sahitya.banksampahsahitya.ui.InfoSampahFragment;
import com.sahitya.banksampahsahitya.ui.LaporanFragment;
import com.sahitya.banksampahsahitya.ui.PeringkatFragment;
import com.sahitya.banksampahsahitya.ui.ProfileFragment;
import com.sahitya.banksampahsahitya.ui.TabunganFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new TabunganFragment());

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation_view);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_tabungan :
                        loadFragment(new TabunganFragment());
                        return true;

                    case R.id.navigation_info_sampah :
                        loadFragment(new InfoSampahFragment());
                        return true;

                    case R.id.navigation_peringkat :
                        loadFragment(new PeringkatFragment());
                        return true;

                    case R.id.navigation_laporan :
                        loadFragment(new LaporanFragment());
                        return true;

                    case R.id.navigation_profil :
                        loadFragment(new ProfileFragment());
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void loadFragment (Fragment fragment){
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_container, fragment);
        fragmentTransaction.commit();
    }
}
