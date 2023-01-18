package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Category;

/**
 * @author Yushun Shao
 * @date 2023/1/18 15:17
 * @description: Category Mapper
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
