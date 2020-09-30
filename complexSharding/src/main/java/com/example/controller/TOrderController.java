package com.example.controller;

import com.example.entity.TOrder;
import com.example.service.TOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2020-09-30 14:32:27
 */
@RestController
@RequestMapping("tOrder")
public class TOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TOrder selectOne(Long id) {
        return this.tOrderService.queryById(id);
    }


    @PostMapping("selectByCondition")
    public List<TOrder> selectByCondition(@RequestBody TOrder tOrder){
        return this.tOrderService.queryByCondition(tOrder);
    }

    @PostMapping("add")
    public TOrder add(@RequestBody TOrder tOrder){
        return this.tOrderService.insert(tOrder);
    }

}