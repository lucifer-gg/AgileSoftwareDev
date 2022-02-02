package com.example.AgileBackEnd.controller;


import com.example.AgileBackEnd.entity.vo.Response;
import com.example.AgileBackEnd.utils.OSSUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private OSSUtils OSSUtils;
    @PostMapping
    public Response upload(@RequestParam("image")MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename,".");
        boolean upload = OSSUtils.upload(file, fileName);
        if (upload){
            return Response.success(OSSUtils.url + fileName);
        }
        return Response.fail(20001,"上传失败");

    }

}
