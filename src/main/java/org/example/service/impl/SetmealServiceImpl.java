package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.common.CustomException;
import org.example.dto.SetmealDto;
import org.example.entity.Setmeal;
import org.example.entity.SetmealDish;
import org.example.mapper.SetmealMapper;
import org.example.service.SetmealDishService;
import org.example.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yushun Shao
 * @date 2023/1/18 19:14
 * @description: Setmeal Service Impl
 */
@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐基本信息 setmeal表
        this.save(setmealDto);

        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());

        //保存套餐和菜品的关联关系 setmealDish表
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 根据id获取套餐基本信息，同时获取dish
     * @param id
     */
    @Override
    public SetmealDto getWithDish(Long id) {
        //根据id获取套餐基本信息
        Setmeal setmeal = this.getById(id);

        //对象拷贝
        SetmealDto setmealDto = new SetmealDto();
        BeanUtils.copyProperties(setmeal,setmealDto);

        //根据SetmealId查询SetmealDish表 获取dish
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SetmealDish::getSetmealId, setmeal.getId());
        List<SetmealDish> list = setmealDishService.list(lambdaQueryWrapper);

        setmealDto.setSetmealDishes(list);

        return setmealDto;
    }

    /**
     * 根据id同时删除套餐和套餐与菜品的关联 同时操作setmeal和setmealDish表
     * @param ids
     */
    @Transactional
    public void removeWithDish(List<Long> ids) {
        //查询套餐状态 确定是否可用删除
        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(Setmeal::getId, ids);
        lambdaQueryWrapper.eq(Setmeal::getStatus, 1);

        long count = this.count(lambdaQueryWrapper);
        if (count > 0){
            //如果不能删除 抛出一个业务异常
            throw new CustomException("套装正在售卖，不能删除");
        }
        //如果可以删除 删除setmeal表的数据
        this.removeByIds(ids);

        //删除setmealDish表的数据
        LambdaQueryWrapper<SetmealDish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(dishLambdaQueryWrapper);
    }
}
