package com.dao;

import com.entity.KuandaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuandaixinxiView;

/**
 * 宽带信息表 Dao 接口
 *
 * @author 
 * @since 2021-02-03
 */
public interface KuandaixinxiDao extends BaseMapper<KuandaixinxiEntity> {

   List<KuandaixinxiView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
