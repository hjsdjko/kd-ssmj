package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuandaileixingEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-02-03
 */
public interface KuandaileixingService extends IService<KuandaileixingEntity> {

     PageUtils queryPage(Map<String, Object> params);

}