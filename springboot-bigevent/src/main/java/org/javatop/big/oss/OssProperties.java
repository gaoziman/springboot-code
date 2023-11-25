package org.javatop.big.oss;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-26 0:52
 * @description : OSS属性
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OssProperties {


        private String endPoint;
        private String keyId;
        private String keySecret;
        private String bucketName;


        public OssProperties() {
        }

        public OssProperties(String endPoint, String keyId, String keySecret, String bucketName) {
            this.endPoint = endPoint;
            this.keyId = keyId;
            this.keySecret = keySecret;
            this.bucketName = bucketName;
        }

        public String getEndPoint() {
            return endPoint;
        }

        public void setEndPoint(String endPoint) {
            this.endPoint = endPoint;
        }

        public String getKeyId() {
            return keyId;
        }

        public void setKeyId(String keyId) {
            this.keyId = keyId;
        }

        public String getKeySecret() {
            return keySecret;
        }

        public void setKeySecret(String keySecret) {
            this.keySecret = keySecret;
        }

        public String getBucketName() {
            return bucketName;
        }

        public void setBucketName(String bucketName) {
            this.bucketName = bucketName;
        }

        @Override
        public String toString() {
            return "OssProperties{" +
                    "endPoint='" + endPoint + '\'' +
                    ", keyId='" + keyId + '\'' +
                    ", keySecret='" + keySecret + '\'' +
                    ", bucketName='" + bucketName + '\'' +
                    '}';
        }

}
