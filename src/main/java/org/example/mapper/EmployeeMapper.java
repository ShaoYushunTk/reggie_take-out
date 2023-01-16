package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Employee;

/**
 * @author Yushun Shao
 * @date 2023/1/16 15:06
 * @description: Employee Mapper
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
