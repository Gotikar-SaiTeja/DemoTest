package com.example.Login.demo.Login.configuration;

import org.apache.tomcat.util.descriptor.web.MultipartDef;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class AmazonS3Config {

    @Value("${AWS_ACCESS_KEY_ID}")
    private String accessKeyId;

    @Value("${AWS_SECRET_ACCESS_KEY}")
    private String secretAccessKey;

    @Value("${AWS_REGION}")
    private String region;

    @Value("${AWS_BUCKET_NAME}")
    private String bucketName;

    @Bean
    public S3Client s3Client() {

        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        return S3Client.builder()
                .region(Region.of(region))
                .endpointOverride(URI.create(("https://" + bucketName + ".s3." + region + ".amazonaws.com/")))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }
}
