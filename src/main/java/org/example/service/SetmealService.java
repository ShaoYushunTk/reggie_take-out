package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.dto.SetmealDto;
import org.example.entity.Setmeal;

import java.util.List;

/**
 * @author Yushun Shao
 * @date 2023/1/18 19:13
 * @description: Setmeal Service
 */
public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public SetmealDto getWithDish(Long id);

    public void removeWithDish(List<Long> ids);
}
