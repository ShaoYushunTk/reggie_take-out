package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.ShoppingCart;
import org.example.mapper.ShoppingCartMapper;
import org.example.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @author Yushun Shao
 * @date 2023/1/29 16:10
 * @description: ShoppingCart service impl
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
