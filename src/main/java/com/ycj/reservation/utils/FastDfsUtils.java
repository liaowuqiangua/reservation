package com.ycj.reservation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class FastDfsUtils {
    public InputStream getFileInputStream(String path) throws FileNotFoundException {
        return new FileInputStream(getFile(path));
    }
    private File getFile(String path){
        URL url = FastDfsUtils.class.getResource(path);
        return new File(url.getFile());
    }
}
