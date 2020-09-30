package com.example.config;

import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.ComplexShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.NoneShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.core.constant.properties.ShardingPropertiesConstant;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Description:
 * @Author: admin
 * @Date: 2020/9/29 18:28
 */
@Component
public class CustomerDataSourceFactory {



    public DataSource createDataSource(List<DataSource> dataSourceList) throws SQLException {

        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();

        /**user表分表配置**/
        TableRuleConfiguration userTableRuleConfig = new TableRuleConfiguration("t_user","db0.t_user_0,db0.t_user_1");
        userTableRuleConfig.setKeyGeneratorConfig(new KeyGeneratorConfiguration("CUSTOM","user_id"));
        userTableRuleConfig.setDatabaseShardingStrategyConfig(new NoneShardingStrategyConfiguration());
        userTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id",new UserTableAlgoritm()));
        shardingRuleConfig.getTableRuleConfigs().add(userTableRuleConfig);



        /**order表分库分表配置**/
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration(
                "t_order", "db0.t_order_2020_0,db0.t_order_2020_1,db0.t_order_2019_0,db0.t_order_2019_1,db1.t_order_2019_0,db1.t_order_2019_1,db1.t_order_2020_0,db1.t_order_2020_1");
        orderTableRuleConfig.setKeyGeneratorConfig(new KeyGeneratorConfiguration("SNOWFLAKE","order_id"));
        // 数据库分片配置
        StandardShardingStrategyConfiguration dataSourceStrategyConfiguration = new StandardShardingStrategyConfiguration(
                "addr", new OrderDataSourcePreciseShardingAlgorithm());
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(dataSourceStrategyConfiguration);
        orderTableRuleConfig.setTableShardingStrategyConfig(new ComplexShardingStrategyConfiguration(
                "order_year,user_id", new OrderTableComplexKeyAlgorithm()));
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);



        Properties properties = new Properties();
        properties.setProperty(ShardingPropertiesConstant.SQL_SHOW.getKey(),
                String.valueOf(true));
        properties.setProperty(ShardingPropertiesConstant.MAX_CONNECTIONS_SIZE_PER_QUERY.getKey(),
                String.valueOf(200));

        Map<String, DataSource> dataSourceMap = new HashMap<>();
        for (int i = 0; i < dataSourceList.size(); i++) {
            dataSourceMap.put("db" + String.valueOf(i), dataSourceList.get(i));
        }
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig,
                properties);
    }
}
