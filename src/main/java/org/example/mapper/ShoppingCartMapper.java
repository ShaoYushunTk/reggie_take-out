package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.ShoppingCart;

/**
 * @author Yushun Shao
 * @date 2023/1/29 16:08
 * @description: ShoppingCart Mapper
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
