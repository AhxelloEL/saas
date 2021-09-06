package com.al.saas.service;

import com.al.saas.consist.GradeExecution;
import com.al.saas.domain.Grade;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service
 * @InterFaceName:GradeService
 * @Description
 * @date2021/8/31 14:41
 */
public interface GradeService{
    public final static String GRADEKEY ="gradelist";
    /**
     * 查询所有年级
     * @return
     */
    GradeExecution getGradeList();

    /**
     * 根据年级Id查询详情信息
     * @param gradeId
     * @return
     */
    Grade getGradeById(Long gradeId);

    /**
     * 更新年级信息
     * @param grade
     * @return
     */
    GradeExecution modifyGrade(Grade grade);

    /**
     * 删除年级
     * @param gradeId
     * @return
     */
    GradeExecution deleteGrade(long gradeId);

    /**
     * 新增年级
     * @param grade
     * @return
     */
    GradeExecution addGrade(Grade grade);
}
