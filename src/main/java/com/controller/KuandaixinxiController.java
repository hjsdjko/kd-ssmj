package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.KuandaileixingEntity;
import com.entity.YonghuxinxiEntity;
import com.service.KuandaileixingService;
import com.service.YonghuxinxiService;
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

import com.entity.KuandaixinxiEntity;

import com.service.KuandaixinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 宽带信息表
 * 后端接口
 * @author
 * @email
 * @date 2021-02-03
*/
@RestController
@Controller
@RequestMapping("/kuandaixinxi")
public class KuandaixinxiController {
    private static final Logger logger = LoggerFactory.getLogger(KuandaixinxiController.class);

    @Autowired
    private KuandaixinxiService kuandaixinxiService;

    @Autowired
    private YonghuxinxiService yonghuxinxiService;

    @Autowired
    private KuandaileixingService kuandaileixingService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("用户")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = kuandaixinxiService.queryPage(params);
        }else{
            page = kuandaixinxiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KuandaixinxiEntity kuandaixinxi = kuandaixinxiService.selectById(id);
        if(kuandaixinxi!=null){
            return R.ok().put("data", kuandaixinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KuandaixinxiEntity kuandaixinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KuandaixinxiEntity> queryWrapper = new EntityWrapper<KuandaixinxiEntity>()
            .eq("yh_types", kuandaixinxi.getYhTypes())
            .eq("kd_types", kuandaixinxi.getKdTypes());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuandaixinxiEntity kuandaixinxiEntity = kuandaixinxiService.selectOne(queryWrapper);
        kuandaixinxi.setCreateTime(new Date());
        kuandaixinxi.setMariadbTypes(2);
        YonghuxinxiEntity yonghuxinxi = yonghuxinxiService.selectById(kuandaixinxi.getYhTypes());
        KuandaileixingEntity kuandaileixing = kuandaileixingService.selectById(kuandaixinxi.getKdTypes());
        if(yonghuxinxi.getBalance() == null){
            yonghuxinxi.setBalance(0.0);
        }
        Double balance = yonghuxinxi.getBalance()-kuandaileixing.getMoney();
        if(balance != null && balance >= 0){
            yonghuxinxi.setBalance(balance);
            yonghuxinxiService.updateById(yonghuxinxi);
        }else{
            return R.error("余额不足请充值");
        }
        if(kuandaixinxiEntity==null){
            kuandaixinxiService.insert(kuandaixinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KuandaixinxiEntity kuandaixinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KuandaixinxiEntity> queryWrapper = new EntityWrapper<KuandaixinxiEntity>()
            .notIn("id",kuandaixinxi.getId())
            .eq("yh_types", kuandaixinxi.getYhTypes())
            .eq("kd_types", kuandaixinxi.getKdTypes());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuandaixinxiEntity kuandaixinxiEntity = kuandaixinxiService.selectOne(queryWrapper);
        if(kuandaixinxiEntity==null){
            kuandaixinxiService.updateById(kuandaixinxi);//根据id更新
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
        kuandaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/removeUser")
    public R removeUser(@RequestBody Integer id){
        KuandaixinxiEntity kuandaixinxi = kuandaixinxiService.selectById(id);
        if(kuandaixinxi.getMariadbTypes()!=3){
            kuandaixinxi.setMariadbTypes(3);
        }else{
            return R.error("请不要重复点击拆机按钮");
        }

        kuandaixinxiService.updateById(kuandaixinxi);
        return R.ok();
    }
    /**
    * 更换状态为已安装
    */
    @RequestMapping("/stutat")
    public R stutat(@RequestBody Integer id){
        KuandaixinxiEntity kuandaixinxi = kuandaixinxiService.selectById(id);
        if(kuandaixinxi.getMariadbTypes()!=1){
            kuandaixinxi.setMariadbTypes(1);
        }else{
            return R.error("请不要重复点击更换状态按钮");
        }

        kuandaixinxiService.updateById(kuandaixinxi);
        return R.ok();
    }
}

