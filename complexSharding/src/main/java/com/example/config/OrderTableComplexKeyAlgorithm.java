package com.example.config;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/29 18:26
 */
@Slf4j
public class OrderTableComplexKeyAlgorithm implements ComplexKeysShardingAlgorithm<String> {
    public Collection<String> doSharding(Collection<String> availableTargetNames, ComplexKeysShardingValue<String> shardingValue) {
        List<String> list = new ArrayList<>();
        log.info("availableTargetNames={},shardingValue={}",availableTargetNames,shardingValue);
        Map<String, Collection<String>> columnNameAndShardingValuesMap = shardingValue.getColumnNameAndShardingValuesMap();
        if(columnNameAndShardingValuesMap.containsKey("order_year")){
            Collection<String> orderYear = columnNameAndShardingValuesMap.get("order_year");
            String address = orderYear.iterator().next();
            list = availableTargetNames.stream().filter(t -> t.contains(address)).collect(Collectors.toList());
        }
        if(columnNameAndShardingValuesMap.containsKey("user_id")){
            Collection<String> userId = columnNameAndShardingValuesMap.get("user_id");
            String stringUserId = userId.iterator().next();
            String index = String.valueOf(stringUserId.hashCode()%list.size());
            list = list.stream().filter(t -> t.endsWith(index)).collect(Collectors.toList());
        }
        log.info("actual table :{}",list);
        return list;
    }
}
