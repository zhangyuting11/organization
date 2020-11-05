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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean disabled) {
        this.isDisabled = disabled;
    }

    public List<OrgRes> getChildren() {
        return children;
    }

    public void setChildren(List<OrgRes> children) {
        this.children = children;
    }
}