package com.example.service.impl;

import com.example.dao.TUserDao;
import com.example.entity.TScore;
import com.example.entity.TUser;
import com.example.service.TScoreService;
import com.example.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * (TUser)表服务实现类
 *
 * @author makejava
 * @since 2020-10-06 14:17:24
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {
    @Resource
    private TUserDao tUserDao;

    @Autowired
    private TScoreService tScoreService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUser queryById(Integer id) {
        return this.tUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TUser> queryAllByLimit(int offset, int limit) {
        return this.tUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TUser insert(TUser tUser) {
        TScore tScore = new TScore();
        tScore.setId(UUID.randomUUID().toString());
        tScore.setScore(12);
        tScoreService.insert(tScore);
        this.tUserDao.insert(tUser);
        return tUser;
    }

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser update(TUser tUser) {
        this.tUserDao.update(tUser);
        return this.queryById(tUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tUserDao.deleteById(id) > 0;
    }
}