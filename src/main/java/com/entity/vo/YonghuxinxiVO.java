package com.entity.vo;

import com.entity.YonghuxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-03
 */
@TableName("yonghuxinxi")
public class YonghuxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户名称 Search
     */

    @TableField(value = "name")
    private String name;


    /**
     * 账号
     */

    @TableField(value = "account")
    private String account;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 头像
     */

    @TableField(value = "img_photo")
    private String imgPhoto;


    /**
     * 余额
     */

    @TableField(value = "balance")
    private Double balance;


    /**
     * 身份
     */

    @TableField(value = "role")
    private String role;


    /**
     * 手机号
     */

    @TableField(value = "number")
    private String number;


    /**
     * 住址
     */

    @TableField(value = "family")
    private String family;


    /**
     * 身份证号
     */

    @TableField(value = "identity")
    private String identity;


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
	 * 设置：用户名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：用户名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：账号
	 */
    public String getAccount() {
        return account;
    }


    /**
	 * 获取：账号
	 */

    public void setAccount(String account) {
        this.account = account;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：头像
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：余额
	 */
    public Double getBalance() {
        return balance;
    }


    /**
	 * 获取：余额
	 */

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    /**
	 * 设置：身份
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 获取：身份
	 */

    public void setRole(String role) {
        this.role = role;
    }
    /**
	 * 设置：手机号
	 */
    public String getNumber() {
        return number;
    }


    /**
	 * 获取：手机号
	 */

    public void setNumber(String number) {
        this.number = number;
    }
    /**
	 * 设置：住址
	 */
    public String getFamily() {
        return family;
    }


    /**
	 * 获取：住址
	 */

    public void setFamily(String family) {
        this.family = family;
    }
    /**
	 * 设置：身份证号
	 */
    public String getIdentity() {
        return identity;
    }


    /**
	 * 获取：身份证号
	 */

    public void setIdentity(String identity) {
        this.identity = identity;
    }

}
