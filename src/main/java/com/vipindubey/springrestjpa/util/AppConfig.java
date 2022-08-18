package com.vipindubey.springrestjpa.util;

import javax.sql.DataSource;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.google.gson.Gson;
import org.springframework.retry.annotation.EnableRetry;

@Configuration
@EnableRetry
public class AppConfig {
    private Gson gson = new Gson();

    @Bean
    public DataSource dataSource() {
        SecretValue secretValue = getSecretValue();
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .password(secretValue.getPassword())
                .username(secretValue.getUsername())
                .url("jdbc:" + secretValue.getEngine() + "://" + secretValue.getHost() + ":" + secretValue.getPort()
                        + "/" + secretValue.getDbname())
                .build();
    }

    private SecretValue getSecretValue() {

        String secretName = "arn:aws:secretsmanager:eu-central-1:980357194454:secret:test/springrestjpa/mysql-Zw6ekU";
        String region = "eu-central-1";

        // Create a Secrets Manager client
        AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard()
                .withRegion(region)
                .build();

        String secret;
        GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest()
                .withSecretId(secretName);
        GetSecretValueResult getSecretValueResult = null;

        try {
            getSecretValueResult = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            throw e;
        }

        if (getSecretValueResult.getSecretString() != null) {
            secret = getSecretValueResult.getSecretString();
            return gson.fromJson(secret, SecretValue.class);
        }
        return null;
    }
}