package com.al.saas.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:Student
 * @Description 学生信息表
 * @date2021/8/31 9:33
 */
@Data
public class Student {
    /**
     * 学生ID
     */
    private Long studentId;
    /**
     * 姓名
     */
    private String studentName;
    /**
     * 账号
     */
    private String account;
    /**
     * 学号
     */
    private String stuId;
    /**
     * 关联年级表，学生所属的年级
     */
    private Grade grade;
    /**
     * 性别
     */
    private char sex;
    /**
     * 完成时间
     */
    private Date lastEditTime;
}
