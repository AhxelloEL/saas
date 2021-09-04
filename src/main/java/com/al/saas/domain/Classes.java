package com.al.saas.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.domain
 * @ClassName:Classes
 * @Description 班级信息实体类
 * @date2021/8/31 9:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "tb_classes")
public class Classes {
    /**
     * 班级Id
     */
    @TableId(value = "classes_id",type = IdType.AUTO)
    private Long classesId;
    /**
     * 班级名
     */
    private String classesName;
    /**
     * 关联年级信息，一对多关系
     */
    @TableField(value = "grade_id")
    private Grade grade;
    /**
     * 设置父类 关联学生 上级Id
     */
    private Classes parent;
}
