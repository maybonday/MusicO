package com.example.musico; // Buradaki paket isminin kendi projenle aynı olduğundan emin ol

public class Song {
    private String title;
    private String artist;

    // Yapıcı metod (Constructor)
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Verileri çekmek için Getter metodları
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
}