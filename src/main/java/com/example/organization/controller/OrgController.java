package com.example.organization.controller;

import com.example.organization.entity.OrgBusinessEntity;
import com.example.organization.entity.OrgDepartmentEntity;
import com.example.organization.entity.OrgGroupEntity;
import com.example.organization.entity.OrgUserEntity;
import com.example.organization.service.impl.OrgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @description@ // TODO OrgController
 * @create@ create by zhangyuting 2020/11/03
 */
@ResponseBody
@RestController
@RequestMapping(value = "/org")
public class OrgController {
    @Autowired
    private OrgServiceImpl orgService;


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody OrgBusinessEntity entity) {
        return ResponseEntity.ok(orgService.add(entity));
    }

    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return ResponseEntity.ok(orgService.list());
    }

    @PostMapping("/addDepartment")
    public ResponseEntity addDepartment(@RequestBody OrgDepartmentEntity entity) {
        return ResponseEntity.ok(orgService.addDepartment(entity));
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody OrgUserEntity entity) {
        return ResponseEntity.ok(orgService.addUser(entity));
    }

    @PostMapping("/addGroupUser")
    public ResponseEntity addGroupUser(@RequestBody OrgGroupEntity entity) {
        return ResponseEntity.ok(orgService.addGroupUser(entity));
    }

    @DeleteMapping(value = "deleteGroupUser")
    public ResponseEntity deleteGroupUser(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(orgService.deleteGroupUser(id));
    }


}