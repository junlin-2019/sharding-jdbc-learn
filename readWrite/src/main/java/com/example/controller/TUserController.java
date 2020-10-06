package com.example.controller;

import com.example.entity.TUser;
import com.example.service.TUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-10-06 14:17:25
 */
@RestController
@RequestMapping("tUser")
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUser selectOne(Integer id) {
        return this.tUserService.queryById(id);
    }


    @PostMapping("add")
    public TUser add(@RequestBody TUser tUser){
        return tUserService.insert(tUser);
    }
}