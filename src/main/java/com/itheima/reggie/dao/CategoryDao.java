package com.itheima.reggie.dao;

import com.itheima.reggie.domain.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品及套餐分类 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2023-03-11
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {

}
