package com.itheima.reggie.dao;

import com.itheima.reggie.domain.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品管理 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2023-03-12
 */
@Mapper
public interface DishDao extends BaseMapper<Dish> {

}
