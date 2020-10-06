package com.example.service.impl;

import com.example.dao.TScoreDao;
import com.example.entity.TScore;
import com.example.service.TScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TScore)表服务实现类
 *
 * @author makejava
 * @since 2020-10-06 14:45:29
 */
@Service("tScoreService")
public class TScoreServiceImpl implements TScoreService {
    @Resource
    private TScoreDao tScoreDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TScore queryById(String id) {
        return this.tScoreDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TScore> queryAllByLimit(int offset, int limit) {
        return this.tScoreDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tScore 实例对象
     * @return 实例对象
     */
    @Override
    public TScore insert(TScore tScore) {
        this.tScoreDao.insert(tScore);
        return tScore;
    }

    /**
     * 修改数据
     *
     * @param tScore 实例对象
     * @return 实例对象
     */
    @Override
    public TScore update(TScore tScore) {
        this.tScoreDao.update(tScore);
        return this.queryById(tScore.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tScoreDao.deleteById(id) > 0;
    }
}