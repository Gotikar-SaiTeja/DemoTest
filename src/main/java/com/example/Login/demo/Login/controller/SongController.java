package com.example.Login.demo.Login.controller;

import com.example.Login.demo.Login.repository.SongRepository;
import com.example.Login.demo.Login.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/songupload")
public class SongController {


    @Autowired
    private SongService songService;

    @PostMapping("/song")
    public ResponseEntity<String> uploadfile(@RequestParam("file")MultipartFile file,@RequestParam("fileName")String fileName){

        try{
            InputStream inputStream = file.getInputStream();
            songService.uploadFile(file.getOriginalFilename(),inputStream,fileName);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded succwsfully");
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed to upload file");

        }
    }

}
