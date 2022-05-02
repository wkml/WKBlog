package com.wikim.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.wikim.domain.ResponseResult;
import com.wikim.enums.AppHttpCodeEnum;
import com.wikim.exception.SystemException;
import com.wikim.service.UploadService;
import com.wikim.utils.PathUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wikim
 */
@Service
@Data
@Component
@ConfigurationProperties(prefix = "oss")
public class OssUploadServiceImpl implements UploadService {
    @Override
    public ResponseResult uploadImg(MultipartFile img) {
        //判断文件类型
        //获取原始文件名
        String originalFilename = img.getOriginalFilename();
        //对原始文件名进行判断
        assert originalFilename != null;
        if (!originalFilename.endsWith(".png")) {
            throw new SystemException(AppHttpCodeEnum.FILE_TYPE_ERROR);
        }

        //如果判断通过上传文件到OSS
        String filePath = PathUtils.generateFilePath(originalFilename);
        //  2099/2/3/wqeqeqe.png
        String url = uploadOss(img, filePath);
        return ResponseResult.okResult(url);
    }

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    private String uploadOss(MultipartFile imgFile, String filePath) {

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            InputStream inputStream = imgFile.getInputStream();
            try {
                ossClient.putObject(bucketName, filePath, inputStream);
                return "https://aliyun-wkk.oss-cn-beijing.aliyuncs.com/" + filePath;
            } catch (OSSException oe) {
                System.out.println("Caught an OSSException, which means your request made it to OSS, " + "but was rejected with an error response for some reason.");
                System.out.println("Error Message:" + oe.getErrorMessage());
                System.out.println("Error Code:" + oe.getErrorCode());
                System.out.println("Request ID:" + oe.getRequestId());
                System.out.println("Host ID:" + oe.getHostId());

            } catch (ClientException ce) {
                System.out.println("Caught an ClientException, which means the client encountered " + "a serious internal problem while trying to communicate with OSS, " + "such as not being able to access the network.");
                System.out.println("Error Message:" + ce.getMessage());
            } finally {
                if (ossClient != null) {
                    ossClient.shutdown();
                }
            }
        } catch (IOException e) {
            //
        }
        return "";
    }
}
