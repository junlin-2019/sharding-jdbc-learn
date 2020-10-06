package com.example.service;

import com.example.entity.TScore;

import java.util.List;

/**
 * (TScore)表服务接口
 *
 * @author makejava
 * @since 2020-10-06 14:45:29
 */
public interface TScoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TScore queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TScore> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tScore 实例对象
     * @return 实例对象
     */
    TScore insert(TScore tScore);

    /**
     * 修改数据
     *
     * @param tScore 实例对象
     * @return 实例对象
     */
    TScore update(TScore tScore);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}