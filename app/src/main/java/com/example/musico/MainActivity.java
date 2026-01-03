package com.example.musico;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Alt Menü (Bottom Navigation) Kurulumu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Toast.makeText(this, "Ana Sayfa", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_search) {
                Toast.makeText(this, "Arama Ekranı", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_library) {
                Toast.makeText(this, "Kitaplığın", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        // 2. Şarkı Listesi (RecyclerView) Kurulumu
        RecyclerView recyclerView = findViewById(R.id.recyclerViewSongs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sahte Şarkı Verilerimizi Ekleyelim
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("Blinding Lights", "The Weeknd"));
        songList.add(new Song("Starboy", "The Weeknd"));
        songList.add(new Song("Mockingbird", "Eminem"));
        songList.add(new Song("Lose Yourself", "Eminem"));
        songList.add(new Song("Godzilla", "Eminem"));
        songList.add(new Song("The Hills", "The Weeknd"));

        // Adapter'ı Bağlayalım (Terzimiz iş başında!)
        SongAdapter adapter = new SongAdapter(songList);
        recyclerView.setAdapter(adapter);

        // 3. Ekran Kenar Boşlukları (Sistem çubukları için)
        // Eğer activity_main.xml'de en üstteki layout ID'si "main" ise burası çalışır.
        // Eğer hata verirse R.id.main kısmını kontrol et.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bottom_navigation), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}