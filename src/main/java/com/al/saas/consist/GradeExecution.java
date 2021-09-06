package com.al.saas.consist;

import com.al.saas.constant.GradeStatusEnum;
import com.al.saas.domain.Grade;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.consist
 * @ClassName:GradeExecution
 * @Description Grade实体增强类
 * @date2021/8/31 15:03
 */
@Data
@NoArgsConstructor
public class GradeExecution {
    /**
     * 结果状态
     */
    private int state;
    /**
     * 状态标识
     */
    private String stateInfo;
    /**
     * 记录总数量
     */
    private int count;
    /**
     * 查询操作
     */
    private List<Grade> gradeList;
    /**
     * 增删改操作
     */
    private Grade grade;

    /**
     * 操作失败时调用的构造器
     * @param statusEnum
     */
    public GradeExecution(GradeStatusEnum statusEnum){
        this.state = statusEnum.getState();
        this.stateInfo = statusEnum.getStateInfo();
    }

    /**
     * 操作成功时返回的构造器，用于增删改
     * @param statusEnum
     * @param grade
     */
    public GradeExecution(GradeStatusEnum statusEnum,Grade grade){
        this.state = statusEnum.getState();
        this.stateInfo = statusEnum.getStateInfo();
        this.grade = grade;
    }

    /**
     * 操作成功时返回的构造器，用于查询
     * @param statusEnum
     * @param gradeList
     */
    public GradeExecution(GradeStatusEnum statusEnum,List<Grade> gradeList){
        this.state = statusEnum.getState();
        this.stateInfo = statusEnum.getStateInfo();
        this.gradeList = gradeList;
    }
}
