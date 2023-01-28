package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.SetmealDish;
import org.example.mapper.SetmealDishMapper;
import org.example.service.SetmealDishService;
import org.springframework.stereotype.Service;

/**
 * @author Yushun Shao
 * @date 2023/1/28 10:02
 * @description: SetmealDish Service impl
 */
@Service
@Slf4j
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
