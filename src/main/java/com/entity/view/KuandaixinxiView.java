package com.entity.view;

import com.entity.KuandaixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 宽带信息表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-03
 */
@TableName("kuandaixinxi")
public class KuandaixinxiView extends KuandaixinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public KuandaixinxiView() {

	}

	public KuandaixinxiView(KuandaixinxiEntity kuandaixinxiEntity) {
		try {
			BeanUtils.copyProperties(this, kuandaixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
