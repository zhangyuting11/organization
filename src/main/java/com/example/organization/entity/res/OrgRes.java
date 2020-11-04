package com.example.organization.entity.res;

import java.util.List;

/**
 * @description@ // TODO OrgRes
 * @create@ create by zhangyuting 2020/11/04
 */
public class OrgRes {
    private Integer id;
    private String name;
    private Boolean disabled;
    private List<OrgRes> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public List<OrgRes> getList() {
        return list;
    }

    public void setList(List<OrgRes> list) {
        this.list = list;
    }
}