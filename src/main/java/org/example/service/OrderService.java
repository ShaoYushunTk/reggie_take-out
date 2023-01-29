package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.OrderDetail;
import org.example.entity.Orders;

/**
 * @author Yushun Shao
 * @date 2023/1/29 21:27
 * @description: Order service
 */
public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);
}
