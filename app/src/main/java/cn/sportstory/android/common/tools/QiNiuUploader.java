package cn.sportstory.android.common.tools;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UpProgressHandler;
import com.qiniu.android.storage.UploadManager;

import org.json.JSONObject;

/**
 * Created by aaron on 2017/6/6.
 * 七牛云存储上传服务组件
 */

public class QiNiuUploader {
    private static QiNiuUploader instance = null;
    private String token;
    private UploadManager manager;
    public static QiNiuUploader getInstance(){
        if (instance == null)
            instance = new QiNiuUploader();
        return instance;
    }


   public void init(String token){
       this.token = token;
       Configuration config = new Configuration.Builder()
               .connectTimeout(5)   //连接超时 默认10秒
               .responseTimeout(15) // 服务器响应超时 默认60秒
               .build();
       manager = new UploadManager(config);
   }

    /**
     * 上传文件
     * @param filePath 文件路径
     * @param key   七牛服务器上的文件名
     */
   public void upload(String filePath, String key){
       manager.put(filePath, key, token, new UpCompletionHandler() {
           @Override
           public void complete(String key, ResponseInfo info, JSONObject response) {
                if (info.isOK()){
                    // TODO: 2017/6/6 上传成功 
                }else {
                    // TODO: 2017/6/6 上传失败
                }
           }
       }, null);
   }

}
