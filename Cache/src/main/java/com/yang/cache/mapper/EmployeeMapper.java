package com.yang.cache.mapper;

import com.yang.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set lastname=#{lastName},email = #{email},gender=#{gender},dId=#{dId} where id=#{id}")
    public void update(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee(lastname,email,gender,dId) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);
}
