package com.example.organization.entity.res;

import java.util.List;

/**
 * @description@ // TODO OrgRes
 * @create@ create by zhangyuting 2020/11/04
 */
public class OrgRes {
    private Integer id;
    private String label;
    private Boolean isDisabled;
    private List<OrgRes> children;

    public Integer getId() {
        return id;
    }

    public OrgRes setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public OrgRes setLabel(String label) {
        this.label = label;
        return this;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public OrgRes setIsDisabled(Boolean disabled) {
        this.isDisabled = disabled;
        return this;
    }

    public List<OrgRes> getChildren() {
        return children;
    }

    public OrgRes setChildren(List<OrgRes> children) {
        this.children = children;
        return this;
    }
}