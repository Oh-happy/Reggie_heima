package com.itheima.reggie.service;

import com.itheima.reggie.domain.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.dto.SetmealDto;

import java.util.List;

/**
 * <p>
 * 套餐 服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-03-12
 */
public interface SetmealService extends IService<Setmeal> {

   public  void saveWithDish(SetmealDto setmealDto);

   public void removeWithDish(List<Long> ids);
}
