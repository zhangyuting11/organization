package com.example.organization.service.impl;

import com.example.organization.entity.OrgBusinessEntity;
import com.example.organization.entity.OrgDepartmentEntity;
import com.example.organization.entity.OrgGroupEntity;
import com.example.organization.entity.OrgUserEntity;
import com.example.organization.entity.res.OrgRes;
import com.example.organization.mapper.OrgMapper;
import com.example.organization.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description@ // TODO OrgServiceImpl
 * @create@ create by zhangyuting 2020/11/03
 */

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgMapper orgMapper;

    @Override
    public int add(OrgBusinessEntity orgBusinessEntity) {
        return orgMapper.add(orgBusinessEntity);
    }

    @Override
    public int addDepartment(OrgDepartmentEntity entity) {
        return orgMapper.addDepartment(entity);
    }

    @Override
    public int addUser(OrgUserEntity entity) {
        return orgMapper.addUser(entity);
    }

    @Override
    public int addGroupUser(OrgGroupEntity entity) {
        List<Integer> userList = new ArrayList<>();
        if (entity.getLb() != null && entity.getLb().size() > 0) {
            for (int i = 0; i < entity.getLb().size(); i++) {
                userList.addAll(orgMapper.listUByB(entity.getLb().get(i)));
            }
        }
        if (entity.getLd() != null && entity.getLd().size() > 0) {
            for (int i = 0; i < entity.getLd().size(); i++) {
                userList.addAll(orgMapper.listUByD(entity.getLd().get(i)));
            }
        }
        userList.addAll(entity.getLu());
        //已经存在的用户
        List<Integer> lg = orgMapper.listUByG();
        if (userList.containsAll(lg)) userList.removeAll(lg);
        //去重
        userList = userList.stream().distinct().collect(Collectors.toList());
        return orgMapper.addGroupUser(userList);
    }

    @Override
    public int deleteGroupUser(Integer id) {
        return orgMapper.deleteGroupUser(id);
    }

    @Override
    public List<OrgRes> list() {
        List<OrgRes> list = new ArrayList<>();
        List<OrgBusinessEntity> listB = orgMapper.listB();
        for (OrgBusinessEntity rb : listB) {
            OrgRes orgRes = new OrgRes();
            orgRes.setId(rb.getId());
            orgRes.setName(rb.getName());
            orgRes.setList(listD(orgRes));
            list.add(orgRes);
        }
        return list;
    }

    @Override
    public List<OrgRes> listD(OrgRes org) {
        List<OrgRes> list = new ArrayList<>();
        List<OrgDepartmentEntity> listD = orgMapper.listD(org.getId());
        int i = listD.size();
        for (OrgDepartmentEntity rd : listD) {
            List<OrgRes> listU = listU(rd.getId());
            OrgRes orgRes = new OrgRes();
            orgRes.setId(rd.getId());
            orgRes.setName(rd.getName());
            orgRes.setList(listU);
            if (listU.size() == orgMapper.cG(rd.getId())) {
                orgRes.setDisabled(true);
                --i;
            }
            if (i == 0) org.setDisabled(true);
            list.add(orgRes);
        }
        return list;
    }

    @Override
    public List<OrgRes> listU(Integer departmentId) {
        List<Integer> listUByG = orgMapper.listUByG();
        List<OrgRes> list = new ArrayList<>();
        List<OrgUserEntity> listU = orgMapper.listU(departmentId);
        int i = listU.size();
        for (OrgUserEntity ru : listU) {
            OrgRes orgRes = new OrgRes();
            orgRes.setId(ru.getId());
            orgRes.setName(ru.getName());
            orgRes.setList(null);
            if (listUByG.contains(ru.getId())) orgRes.setDisabled(true);
            list.add(orgRes);
        }
        return list;
    }
}