package com.al.saas.repository;

import com.al.saas.domain.Grade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.repository
 * @InterFaceName:GradeDao
 * @Description mybatis-Plus 年级接口
 * @date2021/8/31 11:43
 */
@Mapper
public interface GradeDao extends BaseMapper<Grade> {
    //直接继承BaseMapper，直接使用mybatis-plus封装好的类，也可以自定义

    /**
     * 更新年级信息接口
     * @param grade
     * @return
     */
    int updateGradeById(Grade grade);

    /**
     * 删除该年级（测试使用）
     * @param grade 年级信息
     * @return 0：删除失败 1：删除成功
     */
    int deleteGradeById(Grade grade);
}
