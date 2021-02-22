package com.yang.springboot.mapper;

import com.yang.springboot.bean.Employee;

/**
 * @author yangdongyi
 * @create 2020-12-23 20:13
 */
//

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void  insertEmp(Employee employee);
}
