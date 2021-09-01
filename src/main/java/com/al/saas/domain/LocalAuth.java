package com.al.saas.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:LocalAuth
 * @Description 本地账号登入
 * @date2021/8/31 10:19
 */
@Data
public class LocalAuth {
    /**
     * 账号主键
     */
    private Long localAuthId;
    /**
     * 关联学生信息
     */
    private Student student;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后一次操作时间
     */
    private Date lastEditTime;
}
