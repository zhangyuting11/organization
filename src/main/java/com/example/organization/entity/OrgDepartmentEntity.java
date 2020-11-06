package com.example.organization.entity;

/**
 * @description@ // TODO OrgDepartmentEntity
 * @create@ create by zhangyuting 2020/11/04
 */
public class OrgDepartmentEntity extends BaseEntity {
    private Integer businessId;
    private String description;

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}