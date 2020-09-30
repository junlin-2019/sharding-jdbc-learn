package com.example.config;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/29 18:26
 */
@Slf4j
public class OrderDataSourcePreciseShardingAlgorithm  implements PreciseShardingAlgorithm<String> {

    public String doSharding(Collection<String> availableDataSourceNames, PreciseShardingValue<String> shardingValue) {
        log.info("availableDataSourceNames={},shardingValue={}",availableDataSourceNames,shardingValue);
        String value = shardingValue.getValue();
        Iterator<String> iterator = availableDataSourceNames.iterator();
        List<String> list = Lists.newArrayList(availableDataSourceNames);
        int index = value.hashCode()%list.size();
        return list.get(index);
    }
}
