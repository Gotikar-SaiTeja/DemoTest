package com.example.Login.demo.Login.repository;

import com.example.Login.demo.Login.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {
}
