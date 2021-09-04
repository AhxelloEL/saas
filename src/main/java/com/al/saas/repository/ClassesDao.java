package com.al.saas.repository;

import com.al.saas.domain.Classes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.repository
 * @ClassName:ClassesDao
 * @Description
 * @date2021/9/1 12:31
 */
public interface ClassesDao extends BaseMapper<Classes> {
    /**
     * 条件查询 年级二级列表
     * @param classesCondition
     * @return
     */
    List<Classes> queryClassesList(@Param("classesCondition")Classes classesCondition);

    /**
     * 根据班级Id查询
     * @param classesId
     * @return
     */
    Classes queryClassesById(Long classesId);
}
