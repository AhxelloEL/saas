package com.al.saas.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:PersonInfo
 * @Description 用户表TODO 后期做增强
 * @date2021/8/31 10:09
 */
@Data
public class PersonInfo {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户头像
     */
    private String profileImg;
    /**
     * 联系电话、邮箱
     */
    private String phone;
    /**
     * 可用状态
     */
    private String enableStatus;
    /**
     * 用户类型 0：非法 1：学生 2：班主任 3：管理员
     */
    private String userType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date lastEditTime;
}
