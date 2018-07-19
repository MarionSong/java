package com.marion.sys.dao;

import com.marion.sys.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    //public Role findRole(@Param("id")Integer id);
    public int insertRole(Role role);
}
