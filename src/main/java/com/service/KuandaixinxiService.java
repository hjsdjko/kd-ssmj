package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuandaixinxiEntity;
import java.util.Map;

/**
 * 宽带信息表 服务类
 * @author 
 * @since 2021-02-03
 */
public interface KuandaixinxiService extends IService<KuandaixinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}