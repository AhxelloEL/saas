package com.al.saas.dao;

import com.al.saas.domain.Grade;
import com.al.saas.domain.Mission;
import com.al.saas.repository.MissionDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.dao
 * @ClassName:MissionDaoTest
 * @Description 任务调度mapper接口单元测试
 * @date2021/9/4 13:00
 */
@SpringBootTest
public class MissionDaoTest {
    @Resource
    private MissionDao missionDao;

    @Test
    public void testAddMission(){
        Grade grade = new Grade();
        Mission mission = new Mission();
        grade.setGradeId(1l);
        mission.setMissionName("消防演练");
        mission.setEnableStatus(1);
        //发布时间
        mission.setCreateTime(new Date());
        //任务开始时间
        mission.setBeginTime(new Date());
        //任务结束时间
        mission.setLastEditTime(new Date());
        mission.setGrade(grade);

        int effectNum = missionDao.addMission(mission);
        assertEquals(1,effectNum);
    }

    @Test
    public void testQueryMissionList(){
        List<Mission> missionList = missionDao.queryMissionList();
        missionList.forEach(mission -> System.out.println(mission));
    }

    @Test
    public void testRedactMission(){
        Grade grade = new Grade();
        grade.setGradeId(2l);
        Mission mission = new Mission();
        mission.setMissionId(1l);
        mission.setGrade(grade);
        int effectNum = missionDao.redactMission(mission);
        assertEquals(1,effectNum);
    }

    @Test
    public void testAbortMission(){
        Mission mission = new Mission();
        mission.setEnableStatus(0);
        mission.setMissionId(1l);
        int effectNum = missionDao.abortMission(mission);
        assertEquals(1,effectNum);
    }

    @Test
    public void testQueryMissionById(){
        Mission mission = missionDao.queryMissionById(2l);
        System.out.println(mission.toString());
    }
}
