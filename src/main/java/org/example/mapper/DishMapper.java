package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Dish;

/**
 * @author Yushun Shao
 * @date 2023/1/18 19:11
 * @description: Dish Mapper
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
