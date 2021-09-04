package com.al.saas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import java.util.Date;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:Mission
 * @Description 任务调度实体类
 * @date2021/8/31 9:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Date createTime;
    /**
     * 状态
     */
    private Integer enableStatus;
}
