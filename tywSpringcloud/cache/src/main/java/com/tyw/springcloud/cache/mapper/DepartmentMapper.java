package com.tyw.springcloud.cache.mapper;

import com.tyw.springcloud.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department getDepById(Integer id);
}
