package com.prosayj.springbootstudy.cache.mapper;

import com.prosayj.springbootstudy.cache.bean.Department;
import org.apache.ibatis.annotations.*;


/**
 * 指定这是一个操作数据库的mapper
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
