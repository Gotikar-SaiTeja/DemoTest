package com.example.Login.demo.Login.entity;

import jakarta.persistence.*;

@Entity
@Table(name="SongTable")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String songKey;
    private String songLocation;

    public Song() {
    }

    public Song(Long id, String songKey, String songLocation) {
        this.id = id;
        this.songKey = songKey;
        this.songLocation = songLocation;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongKey() {
        return songKey;
    }

    public void setSongKey(String songKey) {
        this.songKey = songKey;
    }

    public String getSongLocation() {
        return songLocation;
    }

    public void setSongLocation(String songLocation) {
        this.songLocation = songLocation;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songKey='" + songKey + '\'' +
                ", songLocation='" + songLocation + '\'' +
                '}';
    }
}