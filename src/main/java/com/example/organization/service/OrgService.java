package com.example.organization.service;

import com.example.organization.entity.OrgBusinessEntity;
import com.example.organization.entity.OrgDepartmentEntity;
import com.example.organization.entity.OrgGroupEntity;
import com.example.organization.entity.OrgUserEntity;
import com.example.organization.entity.res.OrgRes;

import java.util.List;


public interface OrgService {
    int add(OrgBusinessEntity orgBusinessEntity);

    int addDepartment(OrgDepartmentEntity entity);

    int addUser(OrgUserEntity entity);

    int addGroupUser(OrgGroupEntity entity);

    int deleteGroupUser(Integer id);

    List<OrgRes> list();

    List<OrgRes> listD(OrgRes org);

    List<OrgRes> listU(Integer departmentId);
}
