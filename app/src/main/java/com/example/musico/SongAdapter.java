package com.example.musico;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> songList;

    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item_song.xml dosyasını şişirip her bir satırı oluşturur
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        // Listedeki veriyi alıp XML'deki TextView'lara yazar
        Song song = songList.get(position);
        holder.textTitle.setText(song.getTitle());
        holder.textArtist.setText(song.getArtist());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textArtist;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            // item_song.xml içindeki ID'ler ile eşleştiriyoruz
            textTitle = itemView.findViewById(R.id.textSongTitle);
            textArtist = itemView.findViewById(R.id.textArtistName);
        }
    }
}