package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Dish;
import org.example.mapper.DishMapper;
import org.example.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @author Yushun Shao
 * @date 2023/1/18 19:13
 * @description: Dish Service Impl
 */
@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
