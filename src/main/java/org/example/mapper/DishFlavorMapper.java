package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.DishFlavor;

/**
 * @author Yushun Shao
 * @date 2023/1/19 14:57
 * @description: Dish Flavor Mapper
 */
@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {
}
