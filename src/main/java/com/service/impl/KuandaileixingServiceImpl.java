package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.KuandaileixingDao;
import com.entity.KuandaileixingEntity;
import com.service.KuandaileixingService;
import com.entity.view.KuandaileixingView;

/**
 *  服务实现类
 * @author 
 * @since 2021-02-03
 */
@Service("kuandaileixingService")
@Transactional
public class KuandaileixingServiceImpl extends ServiceImpl<KuandaileixingDao, KuandaileixingEntity> implements KuandaileixingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KuandaileixingView> page =new Query<KuandaileixingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
