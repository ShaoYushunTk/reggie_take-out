package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Orders;

/**
 * @author Yushun Shao
 * @date 2023/1/29 21:26
 * @description: Order mapper
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
