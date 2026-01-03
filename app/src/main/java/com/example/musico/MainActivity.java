package com.example.musico;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                // Ana sayfaya tıklandığında ne olsun?
                Toast.makeText(this, "Ana Sayfa", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_search) {
                // Arama kısmına tıklandığında ne olsun?
                Toast.makeText(this, "Arama Ekranı", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_library) {
                // Kitaplığa tıklandığında ne olsun?
                Toast.makeText(this, "Kitaplığın", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}