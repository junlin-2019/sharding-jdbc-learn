package com.example.config;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;
import java.util.UUID;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/30 15:28
 */
public class CustomIdGenerator implements ShardingKeyGenerator {
    @Override
    public Comparable<?> generateKey() {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Override
    public String getType() {
        return "CUSTOM";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
