package com.example.AgileBackEnd.utils;

import com.alibaba.fastjson.JSON;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class OSSUtils {

    public static  final String url = "http://r6nov3m76.hn-bkt.clouddn.com/";



    public  boolean upload(MultipartFile file, String fileName){

        Configuration cfg = new Configuration(Region.huanan());
        UploadManager uploadManager = new UploadManager(cfg);
        String bucket = "blog-cmw";
        try {
            byte[] uploadBytes = file.getBytes();
            Auth auth = Auth.create("OgEmtWpdI4KQlECODC1brRceWDVy1rXKjA-c4Pq9", "kY-l0xpepD8FrDtZaH52lG5nZKsHcfJ1LBdPm8YH");
            String upToken = auth.uploadToken(bucket);
                Response response = uploadManager.put(uploadBytes, fileName, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        return false;
    }
}
