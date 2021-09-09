package com.al.saas.service;

import com.al.saas.consist.GradeExecution;
import com.al.saas.domain.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service
 * @ClassName:GradeServuceTest
 * @Description
 * @date2021/9/6 11:01
 */
@SpringBootTest
public class GradeServiceTest {
    @Autowired
    private GradeService gradeService;

    @Test
    public void testGetGradeList(){
        Grade gradeCondition = new Grade();
        GradeExecution ge = gradeService.getGradeList();
        System.out.println(ge.getGradeList());
    }
}
