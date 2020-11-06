package com.example.organization.entity;

/**
 * @description@ // TODO OrgUserEntity
 * @create@ create by zhangyuting 2020/11/04
 */
public class OrgUserEntity extends BaseEntity {
    private Integer departmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}