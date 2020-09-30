package com.example.controller;

import com.example.entity.TUser;
import com.example.service.TUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-09-30 16:15:59
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
    public TUser selectOne(String id) {
        return this.tUserService.queryById(id);
    }


    @PostMapping("add")
    public TUser add(@RequestBody TUser tUser) {
        return this.tUserService.insert(tUser);
    }

}