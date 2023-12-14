//package com.example.Login.demo.Login.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import org.springframework.lang.NonNull;
//
//@Entity
//public class Login {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String name;
////    @Column(unique = true)
//    private String email;
//
////    @ValidPassword
//    @NonNull
//    @NotBlank(message = "password")
//    private String password;
//
//
//    public Login() {
//    }
//
//    public Login(Long id, String name, String email, @NonNull String password) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @NonNull
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(@NonNull String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "Login{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//}


// Login.java
package com.example.Login.demo.Login.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    @NotBlank(message = "password")
    private String password;

    public Login() {
    }

    public Login(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
