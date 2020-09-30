package com.example.config;

import com.example.utils.ObjectToStrUtils;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.List;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/30 16:03
 */
@Slf4j
public class UserTableAlgoritm  implements PreciseShardingAlgorithm<String> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        log.info("availableTargetNames={},shardingValue={}", ObjectToStrUtils.JSONString(availableTargetNames),ObjectToStrUtils.JSONString(shardingValue));
        String value = shardingValue.getValue();
        List<String> list = Lists.newArrayList(availableTargetNames);
        return list.get(value.hashCode()%list.size());
    }
}
