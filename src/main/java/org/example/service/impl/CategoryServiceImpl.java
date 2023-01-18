package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.common.CustomException;
import org.example.entity.Category;
import org.example.entity.Dish;
import org.example.entity.Setmeal;
import org.example.mapper.CategoryMapper;
import org.example.service.CategoryService;
import org.example.service.DishService;
import org.example.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yushun Shao
 * @date 2023/1/18 15:19
 * @description: Category Service Impl
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类
     * @param id
     */
    @Override
    public void remove(Long id) {
        //判断分类是否关联菜品，若关联则无法删除，抛出业务异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        long count1 = dishService.count(dishLambdaQueryWrapper);
        if (count1 > 0){
            throw new CustomException("当前分类关联菜品，不能删除");
        }
        //判断分类是否关联套餐，若关联则无法删除，抛出业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        long count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2 > 0){
            throw new CustomException("当前分类关联套餐，不能删除");
        }

        //正常删除
        super.removeById(id);

    }
}
