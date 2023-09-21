package com.cloud.awsappservicerunning.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.cloud.awsappservicerunning.constants.Constants;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

  public BasicAWSCredentials basicAWSCredentials() {
    return new BasicAWSCredentials(Constants.accessKey, Constants.secretKey);
  }

  public AmazonSQS amazonSQS() {
    return AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials())).withRegion(
        Constants.region).build();
  }

  public AmazonS3 amazonS3() {
    return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials())).withRegion(Constants.region).build();
  }
}