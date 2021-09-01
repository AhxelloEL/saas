package com.al.saas.domain;

import org.springframework.data.relational.core.sql.In;

import java.util.Date;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:Mission
 * @Description 任务调度实体类
 * @date2021/8/31 9:59
 */
public class Mission {
    /**
     * ID
     */
    private Long missionId;
    /**
     * 名称
     */
    private String missionName;
    /**
     * 范围
     */
    private Grade grade;
    /**
     * 任务开始时间
     */
    private Date beginTime;
    /**
     * 任务结束时间
     */
    private Date lastEditTime;
    /**
     * 发布时间
     */
    private Date createTiem;
    /**
     * 状态
     */
    private Integer enableStatus;
}
