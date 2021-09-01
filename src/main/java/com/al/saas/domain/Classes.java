package com.al.saas.domain;

import lombok.Data;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:Classes
 * @Description 班级信息实体类
 * @date2021/8/31 9:47
 */
@Data
public class Classes {
    /**
     * 班级Id
     */
    private Long classesId;
    /**
     * 班级名
     */
    private String classesName;
    /**
     * 关联年级信息，一对多关系
     */
    private Grade grade;
    /**
     * 设置父类 关联学生 上级Id
     */
    private Classes parent;
}
