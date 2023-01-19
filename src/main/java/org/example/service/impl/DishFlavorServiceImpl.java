package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.DishFlavor;
import org.example.mapper.DishFlavorMapper;
import org.example.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @author Yushun Shao
 * @date 2023/1/19 14:58
 * @description: Dish Flavor Service Impl
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
