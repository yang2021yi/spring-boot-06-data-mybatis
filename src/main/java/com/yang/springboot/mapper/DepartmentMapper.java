package com.yang.springboot.mapper;

import com.yang.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author yangdongyi
 * @create 2020-12-23 19:21
 */
// 指定这是操作一个数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public  int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);
}
