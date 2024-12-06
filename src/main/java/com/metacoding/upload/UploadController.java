package com.metacoding.upload;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
public class UploadController {

    private final UploadService uploadService;

    // form 태그 이용
    @GetMapping("/file1")
    public String file1() {
        return "file1";
    }



    @PostMapping("/v1/upload")
    public String v1Upload(UploadRequest.V1DTO v1DTO) {
        System.out.println(v1DTO.getUsername());
        System.out.println(v1DTO.getImg().getOriginalFilename());
        System.out.println(v1DTO.getImg().getContentType());

        uploadService.v1사진저장(v1DTO);
        return "index";
    }

    // ajax 이용 - page 줘
    @GetMapping("/file2")
    public String file2() {
        return "file2";
    }

    // action
    @PostMapping("/v2/upload")
    public ResponseEntity<?> v2Upload(@RequestBody UploadRequest.V2DTO v2DTO) {
        uploadService.v2사진저장(v2DTO);
        Resp resp = new Resp(true, "성공", null);
        return ResponseEntity.ok(resp);
    }

    // form 태그 이용
    @GetMapping("/file1-check")
    public String file1Check(Model model) {
        Upload upload = uploadService.사진보기();
        model.addAttribute("model", upload);
        return "file1-check";
    }

    // form 태그 이용
    @GetMapping("/file2-check")
    public String file2Check(Model model) {
        Upload upload = uploadService.사진보기();
        model.addAttribute("model", upload);
        return "file2-check";
    }
}












