package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.Category;

/**
 * @author Yushun Shao
 * @date 2023/1/18 15:18
 * @description: Category Service
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
