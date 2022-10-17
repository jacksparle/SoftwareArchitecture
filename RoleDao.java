package cn.wolfcode.dao;

import cn.wolfcode.entity.T_Role;

import java.util.Map;

public interface RoleDao {

    T_Role selectRole(String str);
    void UpdateRole(T_Role user);

    void insertRole(T_Role user);

    T_Role selectRole1(Map<String,String> paramMap);

}
