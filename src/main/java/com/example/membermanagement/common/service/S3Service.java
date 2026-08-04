package com.example.membermanagement.common.service;

import com.example.membermanagement.common.exception.InvalidRequestException;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofDays(7);

    private final S3Template s3Template;
    private final S3Properties s3Properties;

    public String upload(String prefix, MultipartFile file) {
        try {
            validateImage(file);
            String key = prefix + "/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
            s3Template.upload(s3Properties.getBucketName(), key, file.getInputStream());
            return key;
        } catch (IOException e) {
            // 적절한 커스텀 예외로 바꾸고, GlobalExceptionHandler로 핸들링 필요
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }

    public void delete(String url) {
        if (url == null) return;
        String key = extractKeyFromUrl(url);
        s3Template.deleteObject(s3Properties.getBucketName(), key);
    }

    private String extractKeyFromUrl(String imageUrl) {
        return imageUrl.substring(imageUrl.indexOf(".com/") + 5);
    }

    public URL getDownloadUrl(String key) {
        return s3Template.createSignedGetURL(s3Properties.getBucketName(), key, PRESIGNED_URL_EXPIRATION);
    }


    // Image file
    private static final List<String> ALLOWED_TYPES =
            List.of("image/jpeg", "image/png", "image/webp");

    public String uploadProfile(MultipartFile file) {
        validateImage(file);
        return upload("profile", file);
    }

    private void validateImage(MultipartFile file) {
        if (file.isEmpty()
                || !ALLOWED_TYPES.contains(file.getContentType())
                || file.getSize() > 5 * 1024 * 1024
        ) {
            throw new InvalidRequestException("유효하지 않은 프로필 이미지 형식 입니다.");
        }
    }
}