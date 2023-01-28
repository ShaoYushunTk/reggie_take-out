package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.User;

/**
 * @author Yushun Shao
 * @date 2023/1/28 15:53
 * @description: User Mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
