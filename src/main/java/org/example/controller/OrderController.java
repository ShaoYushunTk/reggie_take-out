package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.example.common.BaseContext;
import org.example.common.R;
import org.example.dto.OrdersDto;
import org.example.entity.OrderDetail;
import org.example.entity.Orders;
import org.example.service.OrderDetailService;
import org.example.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yushun Shao
 * @date 2023/1/29 21:28
 * @description: Order controller
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 用户下单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        log.info("订单数据: {}",orders);
        orderService.submit(orders);
        return R.success("下单成功");
    }

    /**
     * 用户分页查询订单
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public R<Page> list(int page, int pageSize){
        Page<Orders> pageInfo = new Page<>(page,pageSize);


        LambdaQueryWrapper<Orders> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Orders::getOrderTime);

        orderService.page(pageInfo, lambdaQueryWrapper);


        return R.success(pageInfo);
    }

    /**
     * 后台订单分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        Page<Orders> pageInfo = new Page<>(page,pageSize);
        Page<OrdersDto> dtoPage = new Page<>(page, pageSize);

        LambdaQueryWrapper<Orders> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Orders::getOrderTime);

        orderService.page(pageInfo, lambdaQueryWrapper);

        BeanUtils.copyProperties(pageInfo,dtoPage,"records");
        List<Orders> records = pageInfo.getRecords();

        List<OrdersDto> list = records.stream().map((item)->{
            OrdersDto ordersDto = new OrdersDto();

            BeanUtils.copyProperties(item, ordersDto);

            ordersDto.setUserName(item.getConsignee());

            return ordersDto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(list);

        return R.success(dtoPage);
    }

    @PutMapping()
    public R<String> updateStatus(@RequestBody Orders order){
//        log.info("order: {}", order);

        orderService.updateById(order);

        return R.success("修改成功");
    }


}
