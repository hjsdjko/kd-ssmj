package com.dao;

import com.entity.LiuyanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LiuyanxinxiView;

/**
 *  Dao 接口
 *
 * @author 
 * @since 2021-02-03
 */
public interface LiuyanxinxiDao extends BaseMapper<LiuyanxinxiEntity> {

   List<LiuyanxinxiView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
