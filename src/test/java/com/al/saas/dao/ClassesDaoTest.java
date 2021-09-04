package com.al.saas.dao;

import com.al.saas.domain.Classes;
import com.al.saas.domain.Grade;
import com.al.saas.repository.ClassesDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.dao
 * @ClassName:ClassesDaoTest
 * @Description
 * @date2021/9/1 12:44
 */
@SpringBootTest
public class ClassesDaoTest {
    @Resource
    private ClassesDao classesDao;

    /**
     * 根据班级Id查询
     */
    @Test
    public void testQueryClassesById(){
        Classes classesList = classesDao.queryClassesById(1l);
        System.out.println(classesList.getGrade().getGradeName());
    }

    /**
     * 根据条件查询
     */
    @Test
    public void testQueryClassesList(){
        Classes classes = new Classes();
        Grade grade = new Grade();
        grade.setGradeName("高一");
        classes.setClassesName("1班");
        classes.setGrade(grade);
        List<Classes> classesList = classesDao.queryClassesList(classes);
        classesList.forEach(classes1 -> System.out.println(classes1));
    }
}
