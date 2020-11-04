package com.example.organization.mapper;

import com.example.organization.entity.OrgBusinessEntity;
import com.example.organization.entity.OrgDepartmentEntity;
import com.example.organization.entity.OrgUserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrgMapper {
    @Insert("insert into org_business(name,description) values(#{name},#{description})")
    int add(OrgBusinessEntity entity);

    @Insert("insert into org_department(business_id,name,description)values(#{businessId},#{name},#{description})")
    int addDepartment(OrgDepartmentEntity entity);

    @Insert("insert into org_user(department_id,name)values(#{departmentId},#{name})")
    int addUser(OrgUserEntity entity);

    @Insert({
            "<script>",
            "insert into org_group(user_id) values ",
            "<foreach collection='userList' item='item' index='index' separator=','>",
            "(#{item})",
            "</foreach>",
            "</script>"
    })
    int addGroupUser(@Param("userList") List<Integer> userList);

    @Delete("delete from org_group where id = #{id}")
    int deleteGroupUser(@Param("id") Integer id);

    @Results({
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "modifyTime", column = "modify_time")
    })
    @Select("select * from org_business")
    List<OrgBusinessEntity> listB();

    @Select("select * from org_department where business_id = #{businessId}")
    List<OrgDepartmentEntity> listD(@Param("businessId") Integer businessId);

    @Select("select * from org_user where department_id = #{departmentId}")
    List<OrgUserEntity> listU(@Param("departmentId") Integer departmentId);

    @Select("select u.id from org_user u\n" +
            "LEFT JOIN org_department d on d.id = u.department_id\n" +
            "LEFT JOIN org_business b on b.id = d.business_id\n" +
            "where b.id = #{businessId} GROUP BY d.id,u.id")
    List<Integer> listUByB(@Param("businessId") Integer businessId);

    @Select("select u.id as userId from org_user u\n" +
            "LEFT JOIN org_department d on u.department_id = d.id\n" +
            "where d.id = #{departmentId}")
    List<Integer> listUByD(@Param("departmentId") Integer departmentId);

    @Select("select user_id as userId from org_group group by user_id")
    List<Integer> listUByG();

    @Select("select count(g.id) from org_group  g\n" +
            "LEFT JOIN org_user u on u.id = g.user_id\n" +
            "where u.department_id = #{departmentId}")
    int cG(@Param("departmentId") Integer departmentId);


}
