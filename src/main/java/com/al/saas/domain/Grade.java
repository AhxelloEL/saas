package com.al.saas.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:Grade
 * @Description 年级信息实体类
 * @date2021/8/31 9:39
 */
@Data
@TableName(value = "tb_grade")
public class Grade {
    /**
     * 年级Id
     */
    @TableId(value = "grade_id",type = IdType.AUTO)
    private Long gradeId;
    /**
     * 年级名
     */
    @TableField(value = "grade_name")
    private String gradeName;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(value = "last_edit_time")
    private Date lastEditTime;
}
