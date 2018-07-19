package com.marion.sys;

import com.marion.sys.pojo.Role;
import com.marion.sys.service.RoleListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
        RoleListService roleListService=ctx.getBean(RoleListService.class);
        List<Role> roleList=new ArrayList<Role>();
        for(int i=0;i<=2;i++){
            Role role=new Role();
            role.setName("wangwang"+i);
            role.setGender("男");
            role.setSalary(1000+i);
        }
        int count=roleListService.insertRoleList(roleList);
        System.out.println(count);
    }
}
