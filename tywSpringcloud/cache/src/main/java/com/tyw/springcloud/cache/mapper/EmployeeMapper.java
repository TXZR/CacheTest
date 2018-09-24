package com.tyw.springcloud.cache.mapper;

import com.tyw.springcloud.cache.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Update("UPDATE employee SET  lastName=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId} where id=#{id}")
    void updateEmp(Employee employee);

    @Delete("DELETE FROM employee where id=#{id}")
    void deleteEmpById(Integer id);

    @Insert("INSERT INTO  employee VALUES (#{lastName}, #{email}, #{gender}, #{dId})")
    void insertEmployee(Employee employee);

}
