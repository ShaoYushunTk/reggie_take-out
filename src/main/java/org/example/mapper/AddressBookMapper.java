package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.AddressBook;

/**
 * @author Yushun Shao
 * @date 2023/1/29 11:09
 * @description: AddressBook Mapper
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
