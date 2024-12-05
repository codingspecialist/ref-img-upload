package com.metacoding.upload;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UploadService {

    private final UploadRepository uploadRepository;

    @Transactional
    public void v1사진저장(UploadRequest.V1DTO v1DTO){
        String dbUrl = MyFileUtil.fileSave(v1DTO.getImg());
        uploadRepository.save(v1DTO.toEntity(dbUrl));
    }

    public Upload v1사진보기() {
        return uploadRepository.findById(1);
    }
}
