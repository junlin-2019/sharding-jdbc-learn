package com.example.service.impl;

import com.example.dao.TOrderDao;
import com.example.entity.TOrder;
import com.example.service.TOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-09-30 14:32:27
 */
@Service("tOrderService")
public class TOrderServiceImpl implements TOrderService {
    @Resource
    private TOrderDao tOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    @Override
    public TOrder queryById(Long orderId) {
        return this.tOrderDao.queryById(orderId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TOrder> queryAllByLimit(int offset, int limit) {
        return this.tOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TOrder insert(TOrder tOrder) {
        this.tOrderDao.insert(tOrder);
        return tOrder;
    }

    /**
     * 修改数据
     *
     * @param tOrder 实例对象
     * @return 实例对象
     */
    @Override
    public TOrder update(TOrder tOrder) {
        this.tOrderDao.update(tOrder);
        return this.queryById(tOrder.getOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long orderId) {
        return this.tOrderDao.deleteById(orderId) > 0;
    }

    @Override
    public List<TOrder> queryByCondition(TOrder tOrder) {
        return tOrderDao.selectByCondition(tOrder);
    }
}