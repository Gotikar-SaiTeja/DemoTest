package com.example.Login.demo.Login.service;

import com.example.Login.demo.Login.entity.Song;
import com.example.Login.demo.Login.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private S3Client s3Client;


    @Value("${AWS_ACCESS_KEY_ID}")
    private String accessKeyId;

    @Value("${AWS_SECRET_ACCESS_KEY}")
    private String secretAccessKey;

    @Value("${AWS_REGION}")
    private String region;

    @Value("${AWS_BUCKET_NAME}")
    private String bucketName;

    @Value("${AWS_BUCKET_FOLDER_NAME}")
    private String bucketFolderName;


    public void uploadFile(String Key, InputStream inputStream, String fileName) {
        try {
            String songKey = UUID.randomUUID().toString();
            System.out.println(songKey);

            String Keys = bucketFolderName + "/" + songKey;
            System.out.println(Keys);

            s3Client.putObject(PutObjectRequest.builder()
                    .bucket("SpringBootSR_AWS")
                    .key(Key)
                    .build(), RequestBody.fromInputStream(inputStream, inputStream.available()));

            storeFileNameInDatabase(Key, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

//    private void storeFileNameInDatabase(String key, String fileName) {
//        Song songEntity = new Song();
//        songEntity.setSongLocation(getSongUrl(key));
//        System.out.println("Song URL: " + getSongUrl(key));
//        songRepository.save(songEntity);
//    }


    private void storeFileNameInDatabase(String key, String fileName) {
        try {
            String songKey = UUID.randomUUID().toString();
            String songUrl = getSongUrl(songKey);

            // Create a new Song entity and set its properties
            Song songEntity = new Song();
            songEntity.setSongKey(songKey);
            songEntity.setSongLocation(songUrl);

            // Save the entity to the database
            songRepository.save(songEntity);

            System.out.println("Song URL: " + songUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String getSongUrl(String songKey) {
        // Assuming you have a method to generate the song URL based on the key
        return "https://" + bucketName + ".s3." + region + ".amazonaws.com/SpringBootSR_AWS" + songKey;
    }
}








//    public void uploadFile(String key, InputStream inputStream, String fileName) {
//        try {
//            String songKey = UUID.randomUUID().toString();
//            System.out.println("Generated Song Key: " + songKey);
//
//            String s3Key = bucketFolderName + "/" + songKey;
//            System.out.println("S3 Key: " + s3Key);
//
//            s3Client.putObject(PutObjectRequest.builder()
//                    .bucket(bucketName)
//                    .key(s3Key)
//                    .build(), RequestBody.fromInputStream(inputStream, inputStream.available()));
//
//            storeFileNameInDatabase(s3Key, fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void storeFileNameInDatabase(String key, String fileName) {
//        try {
//            String songKey = UUID.randomUUID().toString();
//            String songUrl = getSongUrl(key);
//
//            // Create a new Song entity and set its properties
//            Song songEntity = new Song();
//            songEntity.setSongKey(songKey);
//            songEntity.setSongLocation(songUrl);
//
//            // Save the entity to the database
//            songRepository.save(songEntity);
//
//            System.out.println("Song URL: " + songUrl);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String getSongUrl(String key) {
//        return "https://" + bucketName + ".s3." + region + ".amazonaws.com/" + key;
//    }
//}
