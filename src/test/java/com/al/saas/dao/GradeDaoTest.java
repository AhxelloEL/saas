package com.al.saas.dao;

import com.al.saas.domain.Grade;
import com.al.saas.repository.GradeDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.dao
 * @ClassName:GradeDaoTest
 * @Description
 * @date2021/8/31 12:46
 */
@SpringBootTest
public class GradeDaoTest {
    @Resource
    private GradeDao gradeDao;


    /**
     * 测试-查询年级列表所有信息
     */
    @Test
    public void testGradeList(){
        List<Grade> list = gradeDao.selectList(null);
        list.forEach(grade -> System.out.println(grade));
    }
    //根据ID查询
    @Test
    public void testGradeById(){
    Grade grade = gradeDao.selectById("1");
        System.out.println(grade);
    }
    //根据条件查询
    @Test
    public void queryWrapperGrade(){
        QueryWrapper<Grade> gradeQueryWrapper = new QueryWrapper<>();
        //gradeQueryWrapper.eq("grade_name","2021级高一");
        gradeQueryWrapper.lt("create_time",new Date());
        List<Grade> gradeList = gradeDao.selectList(gradeQueryWrapper);
        gradeList.forEach(grade -> System.out.println(grade));
    }

    @Test
    public void testGradeInsert(){
        Grade grade = new Grade();
        grade.setGradeName("2021级高一");
        grade.setCreateTime(new Date());
        grade.setLastEditTime(new Date());
       int effectNum =  gradeDao.insert(grade);
    }

    @Test
    public void testGradeUpdate(){
        Grade grade = new Grade();
        grade.setGradeId(5l);
        grade.setCreateTime(new Date());
        int effectNum = gradeDao.updateGradeById(grade);
    }
    @Test
    public void testGradeDel(){
        int effectNum = gradeDao.deleteGradeById(5l);
        System.out.println(effectNum);
    }

}
