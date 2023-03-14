package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.domain.Dish;
import com.itheima.reggie.dto.DishDto;

/**
 * <p>
 * 菜品管理 服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-03-12
 */
public interface DishService extends IService<Dish> {
    public  void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);

}
