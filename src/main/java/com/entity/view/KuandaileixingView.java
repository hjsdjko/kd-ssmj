package com.entity.view;

import com.entity.KuandaileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-03
 */
@TableName("kuandaileixing")
public class KuandaileixingView extends KuandaileixingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public KuandaileixingView() {

	}

	public KuandaileixingView(KuandaileixingEntity kuandaileixingEntity) {
		try {
			BeanUtils.copyProperties(this, kuandaileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
