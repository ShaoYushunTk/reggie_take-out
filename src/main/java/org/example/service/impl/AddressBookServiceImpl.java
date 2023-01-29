package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.AddressBook;
import org.example.mapper.AddressBookMapper;
import org.example.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @author Yushun Shao
 * @date 2023/1/29 11:11
 * @description: AddressBook service impl
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
