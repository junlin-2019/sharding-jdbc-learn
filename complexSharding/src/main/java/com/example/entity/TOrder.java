package com.example.entity;

import java.io.Serializable;

/**
 * (TOrder)实体类
 *
 * @author makejava
 * @since 2020-09-30 14:32:26
 */
public class TOrder implements Serializable {
    private static final long serialVersionUID = -43186147453010461L;

    private Long orderId;

    private String userId;

    private String addr;

    private String orderYear;

    private String goodsName;

    private Integer goddsNum;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getOrderYear() {
        return orderYear;
    }

    public void setOrderYear(String orderYear) {
        this.orderYear = orderYear;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoddsNum() {
        return goddsNum;
    }

    public void setGoddsNum(Integer goddsNum) {
        this.goddsNum = goddsNum;
    }

}