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

import com.entity.XitonggonggaoEntity;

import com.service.XitonggonggaoService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 系统公告
 * 后端接口
 * @author
 * @email
 * @date 2021-02-03
*/
@RestController
@Controller
@RequestMapping("/xitonggonggao")
public class XitonggonggaoController {
    private static final Logger logger = LoggerFactory.getLogger(XitonggonggaoController.class);

    @Autowired
    private XitonggonggaoService xitonggonggaoService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = xitonggonggaoService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        XitonggonggaoEntity xitonggonggao = xitonggonggaoService.selectById(id);
        if(xitonggonggao!=null){
            return R.ok().put("data", xitonggonggao);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XitonggonggaoEntity xitonggonggao, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<XitonggonggaoEntity> queryWrapper = new EntityWrapper<XitonggonggaoEntity>()
            .eq("biaoti", xitonggonggao.getBiaoti())
            .eq("leixing", xitonggonggao.getLeixing())
            .eq("neirong", xitonggonggao.getNeirong())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XitonggonggaoEntity xitonggonggaoEntity = xitonggonggaoService.selectOne(queryWrapper);
        if(xitonggonggaoEntity==null){
            xitonggonggaoService.insert(xitonggonggao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XitonggonggaoEntity xitonggonggao, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<XitonggonggaoEntity> queryWrapper = new EntityWrapper<XitonggonggaoEntity>()
            .notIn("id",xitonggonggao.getId())
            .eq("biaoti", xitonggonggao.getBiaoti())
            .eq("leixing", xitonggonggao.getLeixing())
            .eq("neirong", xitonggonggao.getNeirong())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XitonggonggaoEntity xitonggonggaoEntity = xitonggonggaoService.selectOne(queryWrapper);
        if(xitonggonggaoEntity==null){
            xitonggonggaoService.updateById(xitonggonggao);//根据id更新
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
        xitonggonggaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

