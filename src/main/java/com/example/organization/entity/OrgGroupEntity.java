package com.example.organization.entity;

import java.util.List;

/**
 * @description@ // TODO OrgGroupEntity
 * @create@ create by zhangyuting 2020/11/04
 */
public class OrgGroupEntity {
    private Integer id;
    private Integer userId;
    private List<Integer> lb;
    private List<Integer> ld;
    private List<Integer> lu;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getLb() {
        return lb;
    }

    public void setLb(List<Integer> lb) {
        this.lb = lb;
    }

    public List<Integer> getLd() {
        return ld;
    }

    public void setLd(List<Integer> ld) {
        this.ld = ld;
    }

    public List<Integer> getLu() {
        return lu;
    }

    public void setLu(List<Integer> lu) {
        this.lu = lu;
    }
}