package com.entity.model;

import com.entity.KuandaixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宽带信息表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-03
 */
public class KuandaixinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */
    private Integer id;


    /**
     * 所属用户
     */
    private Integer yhTypes;


    /**
     * 安装地址
     */
    private String family;


    /**
     * 联系电话
     */
    private String number;


    /**
     * 套餐信息
     */
    private Integer kdTypes;


    /**
     * 安装时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
     * 是否安装
     */
    private Integer mariadbTypes;


    /**
	 * 设置：id
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：id
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：所属用户
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：所属用户
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：安装地址
	 */
    public String getFamily() {
        return family;
    }


    /**
	 * 获取：安装地址
	 */

    public void setFamily(String family) {
        this.family = family;
    }
    /**
	 * 设置：联系电话
	 */
    public String getNumber() {
        return number;
    }


    /**
	 * 获取：联系电话
	 */

    public void setNumber(String number) {
        this.number = number;
    }
    /**
	 * 设置：套餐信息
	 */
    public Integer getKdTypes() {
        return kdTypes;
    }


    /**
	 * 获取：套餐信息
	 */

    public void setKdTypes(Integer kdTypes) {
        this.kdTypes = kdTypes;
    }
    /**
	 * 设置：安装时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：安装时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：是否安装
	 */
    public Integer getMariadbTypes() {
        return mariadbTypes;
    }


    /**
	 * 获取：是否安装
	 */

    public void setMariadbTypes(Integer mariadbTypes) {
        this.mariadbTypes = mariadbTypes;
    }

    }
