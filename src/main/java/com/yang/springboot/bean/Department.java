package com.yang.springboot.bean;

/**
 * @author yangdongyi
 * @create 2020-12-23 19:18
 */
public class Department {

    private Integer id;
    private  String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
