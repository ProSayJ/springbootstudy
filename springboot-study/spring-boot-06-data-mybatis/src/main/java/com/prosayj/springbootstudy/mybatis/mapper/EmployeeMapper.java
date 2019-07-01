package com.prosayj.springbootstudy.mybatis.mapper;

import com.prosayj.springbootstudy.mybatis.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
