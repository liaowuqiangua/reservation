package dfsdemo;

import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
* TrackerClient - TrackerServer接口
* GenerateStorageClient - 一般文件存储接口 (StorageServer接口)
* FastFileStorageClient - 为方便项目开发集成的简单接口(StorageServer接口)
* AppendFileStorageClient - 支持文件续传操作的接口 (StorageServer接口)
* */
@Component
public class fastdfsHelloWorld {
    @Autowired
    private FastFileStorageClient storageClient;

    public void uploadImage(){

    }
}
