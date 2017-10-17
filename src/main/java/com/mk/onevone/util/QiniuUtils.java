package com.mk.onevone.util;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by 01436296 on 2017/10/12.
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiniuUtils {
    private String AK;
    private String SK;
    private String bucket;

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void setAK(String AK) {
        this.AK = AK;
    }

    public void setSK(String SK) {
        this.SK = SK;
    }

    public String upload(MultipartFile file){
        Auth auth = Auth.create(AK,SK);
        String token = auth.uploadToken(bucket);
        Configuration configuration = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(configuration);
        try {
            Response response = uploadManager.put(file.getBytes(), UUID.randomUUID().toString()
                    + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")),token);
            DefaultPutRet ret = JSON.parseObject(response.bodyString(),DefaultPutRet.class);
            if(ret != null && !StringUtils.isNullOrEmpty(ret.key)){
                return ret.key;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
