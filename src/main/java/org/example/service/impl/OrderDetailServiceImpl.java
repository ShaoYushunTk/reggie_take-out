package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.OrderDetail;
import org.example.mapper.OrderDetailMapper;
import org.example.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author Yushun Shao
 * @date 2023/1/29 21:30
 * @description: OrderDetail service impl
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
