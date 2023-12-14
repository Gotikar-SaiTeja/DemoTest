package com.example.Login.demo.Login.repository;

import com.example.Login.demo.Login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {
    Login findByEmail(String email);
}
