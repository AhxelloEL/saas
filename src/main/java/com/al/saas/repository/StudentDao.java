package com.al.saas.repository;

import com.al.saas.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.repository
 * @InterFaceName:StudentDao
 * @Description
 * @date2021/9/1 13:56
 */
public interface StudentDao extends BaseMapper<Student> {
    /**
     * 分页查询 根据学号 学生账号 名字 班级 年级
     * @param studentCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Student> queryStudentList(@Param("studentCondition")Student studentCondition,
                                   @Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize);

    /**
     * 查询总数量
     * @param studentCondition
     * @return
     */
    int queryStudentCount(@Param("studentCondition")Student studentCondition);

    /**
     * 根据学生Id查询 or 根据学号查询
     * @param studentId
     * @return
     */
    Student queryStudentById(Long studentId);

    /**
     * 录入档案信息
     * @param student
     * @return
     */
    int addStudent(Student student);

}
