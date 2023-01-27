package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.dto.DishDto;
import org.example.entity.Dish;

import java.util.List;

/**
 * @author Yushun Shao
 * @date 2023/1/18 19:12
 * @description: Dish Service
 */
public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品，同时更新菜品对应的口味数据
    public void updateWithFlavor(DishDto dishDto);

    public void removeWithFlavor(String ids);
}
