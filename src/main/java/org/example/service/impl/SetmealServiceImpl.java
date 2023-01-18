package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Setmeal;
import org.example.mapper.SetmealMapper;
import org.example.service.SetmealService;
import org.springframework.stereotype.Service;

/**
 * @author Yushun Shao
 * @date 2023/1/18 19:14
 * @description: Setmeal Service Impl
 */
@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
