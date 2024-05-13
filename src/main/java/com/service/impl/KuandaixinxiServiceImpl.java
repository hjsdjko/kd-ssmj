package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.KuandaixinxiDao;
import com.entity.KuandaixinxiEntity;
import com.service.KuandaixinxiService;
import com.entity.view.KuandaixinxiView;

/**
 * 宽带信息表 服务实现类
 * @author 
 * @since 2021-02-03
 */
@Service("kuandaixinxiService")
@Transactional
public class KuandaixinxiServiceImpl extends ServiceImpl<KuandaixinxiDao, KuandaixinxiEntity> implements KuandaixinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KuandaixinxiView> page =new Query<KuandaixinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
