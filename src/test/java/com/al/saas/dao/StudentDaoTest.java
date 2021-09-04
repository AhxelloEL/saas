package com.al.saas.dao;

import com.al.saas.domain.Classes;
import com.al.saas.domain.Student;
import com.al.saas.repository.StudentDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.dao
 * @ClassName:StudentDaoTest
 * @Description
 * @date2021/9/1 17:38
 */
@SpringBootTest
public class StudentDaoTest {
    @Resource
    private StudentDao studentDao;

    @Test
    public void testQueryStudentList(){
        Student student = new Student();
        Classes classes = new Classes();
        student.setStudentName("曹");
        classes.setClassesName("2021级1班");
        //student.setStuId("D1517421");
        student.setClasses(classes);
        List<Student> studentList = studentDao.queryStudentList(student,0,1);
        int count = studentDao.queryStudentCount(student);
        System.out.println("---"+studentList.size());
        System.out.println("总数量："+count);
        studentList.forEach(student1 -> System.out.println(student1));
    }

    @Test
    public void testQueryStudentById(){
        Student student = studentDao.queryStudentById(3l);
        System.out.println(student.toString());
    }

    @Test
    public void testAddStudent(){
        Student student = new Student();
        Classes classes = new Classes();
        classes.setClassesId(1l);
        student.setStudentName("曹达华");
        student.setAccount("1251512241");
        student.setStuId("G12512516");
        student.setSex('1');
        student.setLastEditTime(new Date());
        student.setClasses(classes);
        int effectNum = studentDao.addStudent(student);
        assertEquals(1,effectNum);

    }
}
