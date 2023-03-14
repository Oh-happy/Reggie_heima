package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.domain.Category;
import com.itheima.reggie.dao.CategoryDao;
import com.itheima.reggie.domain.Dish;
import com.itheima.reggie.domain.Setmeal;
import com.itheima.reggie.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.service.DishService;
import com.itheima.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品及套餐分类 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-03-11
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {
    @Autowired
    private SetmealService setmealService;

    @Autowired
    private DishService dishService;

    @Override
    public void remove(Long id){
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper =new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategory_id,id);
        int count1 = (int) dishService.count(dishLambdaQueryWrapper);
        if (count1 > 0) {
            throw new CustomException("当前分类下关联了菜品，不能删除");

        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper =new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategory_id,id);
        int count2= (int) setmealService.count(setmealLambdaQueryWrapper);
        if (count2 > 0) {
            throw new CustomException("当前分类下关联了套餐，不能删除");

        }
        super.removeById(id);
    }

}
