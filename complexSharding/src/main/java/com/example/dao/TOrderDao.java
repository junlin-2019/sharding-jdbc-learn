package com.example.dao;

import com.example.entity.TOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-30 14:32:26
 */
public interface TOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    TOrder queryById(Long orderId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tOrder 实例对象
     * @return 对象列表
     */
    List<TOrder> queryAll(TOrder tOrder);

    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     * @return 影响行数
     */
    int insert(TOrder tOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TOrder> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TOrder> entities);

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 影响行数
     */
    int update(TOrder tOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 影响行数
     */
    int deleteById(Long orderId);

    List<TOrder> selectByCondition(@Param("order") TOrder tOrder);
}