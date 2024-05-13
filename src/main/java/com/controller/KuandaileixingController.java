package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.KuandaileixingEntity;

import com.service.KuandaileixingService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-02-03
*/
@RestController
@Controller
@RequestMapping("/kuandaileixing")
public class KuandaileixingController {
    private static final Logger logger = LoggerFactory.getLogger(KuandaileixingController.class);

    @Autowired
    private KuandaileixingService kuandaileixingService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = kuandaileixingService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KuandaileixingEntity kuandaileixing = kuandaileixingService.selectById(id);
        if(kuandaileixing!=null){
            return R.ok().put("data", kuandaileixing);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KuandaileixingEntity kuandaileixing, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KuandaileixingEntity> queryWrapper = new EntityWrapper<KuandaileixingEntity>()
            .eq("kdname", kuandaileixing.getKdname())
            .eq("notice_content", kuandaileixing.getNoticeContent())
            .eq("speed", kuandaileixing.getSpeed())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuandaileixingEntity kuandaileixingEntity = kuandaileixingService.selectOne(queryWrapper);
            kuandaileixing.setMoneyTime(new Date());
        if(kuandaileixingEntity==null){
            kuandaileixingService.insert(kuandaileixing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KuandaileixingEntity kuandaileixing, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KuandaileixingEntity> queryWrapper = new EntityWrapper<KuandaileixingEntity>()
            .notIn("id",kuandaileixing.getId())
            .eq("kdname", kuandaileixing.getKdname())
            .eq("notice_content", kuandaileixing.getNoticeContent())
            .eq("speed", kuandaileixing.getSpeed())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuandaileixingEntity kuandaileixingEntity = kuandaileixingService.selectOne(queryWrapper);
                kuandaileixing.setMoneyTime(new Date());
        if(kuandaileixingEntity==null){
            kuandaileixingService.updateById(kuandaileixing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        kuandaileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

