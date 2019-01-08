package com.ycj.reservation.service;

import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.ycj.reservation.pojo.Image;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ImageService {
    private static Logger log = LogManager.getLogger(ImageService.class);
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Value("${dataServer.basePath}")
    private static String bathPath ;

    @Autowired
    private FastFileStorageClient storageClient;

    /*
    * @Description 批量上传图片
    * */
    public List<Image> uploadImages(MultipartFile[] files, String author, int range , String actID){
        Set<MetaData> metaData = new HashSet<MetaData>();
        List<Image> images =  new ArrayList<Image>();
        String filename;
        metaData.add(new MetaData("Author",author));
        metaData.add(new MetaData("CreateDate",DATE_FORMAT.format(new Date())));
        for (MultipartFile file:files){
            filename = file.getOriginalFilename();
            try {
                StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(),filename.substring(filename.lastIndexOf(".")+1),metaData);
                images.add(new Image(range,actID,bathPath+storePath.getFullPath(),storePath.getGroup(),storePath.getPath()));
            }
            catch (Exception e){
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return images;
    }
    /*
    *  @Description 单个图片上传
    * */
    public Image uploadImage(MultipartFile file, String author, int range , String actID){
        Set<MetaData> metaData = new HashSet<MetaData>();
        Image image = null;
        String filename;
        metaData.add(new MetaData("Author",author));
        metaData.add(new MetaData("CreateDate",DATE_FORMAT.format(new Date())));
        filename = file.getOriginalFilename();
        try {
            StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(),filename.substring(filename.lastIndexOf(".")+1),metaData);
            image = new Image(range,actID,bathPath+storePath.getFullPath(),storePath.getGroup(),storePath.getPath());
        }
        catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return image;
    }

    /*
    * @Description 一般不调用 即使放弃操作也可以保留
    * */
    public void deleteImage(String group,String path){
        storageClient.deleteFile(group,path);
    }
}
