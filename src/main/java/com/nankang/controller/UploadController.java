package com.nankang.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController {

    @Value("${savePath}")
    private String savePath;

    @RequestMapping(value="/uploadFile",method= RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String testUpload(MultipartFile file) throws IOException {
        File file1=new File(savePath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        byte []buffer =new byte[1024];
        String newFileName = UUID.randomUUID().toString();
        String originalName=file.getOriginalFilename();
        String suffix = originalName.substring(originalName.lastIndexOf("."));
        OutputStream os=new FileOutputStream(savePath+newFileName+suffix);
        InputStream inputStream = file.getInputStream();
        int len=0;
        while ((len=inputStream.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        Map<String,Object> result=new HashMap<String,Object>(){{
            put("code",200);
            put("message","上传成功");
        }};
        return JSONObject.toJSONString(result);
    }

}
