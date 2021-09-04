package com.al.saas.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:Student
 * @Description 学生信息表
 * @date2021/8/31 9:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_student")
public class Student {
    /**
     * 学生ID
     */
    @TableId(value = "student_id",type = IdType.AUTO)
    private Long studentId;
    /**
     * 姓名
     */
    @TableField(value = "student_name")
    private String studentName;
    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;
    /**
     * 学号
     */
    @TableField(value = "stu_id")
    private String stuId;
    /**
     * 关联班级表，学生所属的班级
     */
    @TableField(value = "classes_id")
    private Classes classes;
    /**
     * 性别
     */
    @TableField(value = "sex")
    private char sex;
    /**
     * 完成时间
     */
    @TableField(value = "last_edit_time")
    private Date lastEditTime;
}
