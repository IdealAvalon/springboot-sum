package com.zhangdq.springbootsum.controller;

import com.zhangdq.springbootsum.pojo.Picture;
import com.zhangdq.springbootsum.utils.FastDFSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 12:31 2018/6/14
 */
@RestController
public class PictureController {
    private static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    /**
     * 首页获取图片
     * @param model
     * @return
     */
    @RequestMapping("/pictures")
    public List<Picture> loadPictures(Model model) {

        List<Picture> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Picture("aa", "zheshi " + i, "/assets/images/" + i + ".jpg"));
        }
        model.addAttribute("data", list);
        return list;
    }

    @GetMapping("/toPictureUpload")
    public String toUpload() {
        return "forward:user-center/publish/upload";
    }

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @PostMapping(value = "/picture", produces= MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    public Map upload(MultipartFile uploadFile) {
        try {
            //接收上传的文件
            byte[] content = uploadFile.getBytes();
            //取文件的扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //把文件内容上传到图片服务器。
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:fast_dfs.conf");
            String url = fastDFSClient.uploadFile(content, ext);
            //从配置文件中取图片服务器的url
            //创建返回结果对象
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", IMAGE_SERVER_URL + url);
            //返回结果
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return result;
        }
    }


}
