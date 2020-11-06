package com.example.organization.service;

import java.util.List;

public interface BaseServive<T> {
    /**
     * @return : int
     * @params : [t]
     * @Description : //TODO 添加
     * @Create : create by yuting 2020/11/6
     **/
    default void add(T t) {
    }

    /*
     * @params : [id]
     * @Description : //TODO 根据主键删除
     * @return : void
     * @Create : create by yuting 2020/11/6
     **/
    default void delete(Integer id) {
    }

    /**
     * @return : int
     * @params : [t]
     * @Description : //TODO 根据参数删除
     * @Create : create by yuting 2020/11/6
     **/
    default void delete(T t) {
    }


    /**
     * @return : void
     * @params : [t]
     * @Description : //TODO 修改
     * @Create : create by yuting 2020/11/6
     **/
    default void update(T t) {
    }


    /**
     * @return : T
     * @params : [id]
     * @Description : //TODO 根据主键查找
     * @Create : create by yuting 2020/11/6
     **/
    default T select(Integer id) {
        return null;
    }

    /**
     * @return : T // TODO 返回一个对象
     * @params : [t]
     * @Description : //TODO 根据参数查询
     * @Create : create by yuting 2020/11/6
     **/
    default T select(T t) {
        return null;
    }


    /**
     * @return : java.util.List<T>
     * @params : [t]
     * @Description : //TODO 根据参数查找
     * @Create : create by yuting 2020/11/6
     **/
    default List<T> list(T t) {
        return null;
    }

    /**
     * @return : java.util.List<T>
     * @params : []
     * @Description : //TODO 查找全部
     * @Create : create by yuting 2020/11/6
     **/
    default List<T> listAll() {
        return null;
    }

}
