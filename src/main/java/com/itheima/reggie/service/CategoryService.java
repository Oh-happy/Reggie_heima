package com.itheima.reggie.service;

import com.itheima.reggie.domain.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜品及套餐分类 服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-03-11
 */
public interface CategoryService extends IService<Category> {
    void remove(Long id);



}
