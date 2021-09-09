package com.al.saas.service;

import com.al.saas.consist.MissionExecution;
import com.al.saas.constant.MissionStatusEnum;
import com.al.saas.domain.Grade;
import com.al.saas.domain.Mission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service
 * @ClassName:MissionService
 * @Description
 * @date2021/9/7 9:36
 */
@SpringBootTest
public class MissionServiceTest {
    @Autowired
    private MissionService missionService;

    /**
     * 测试任务调度查询接口
     */
    @Test
    public void testQueryMissionList(){
        MissionExecution missionList = missionService.getMissionList();
        missionList.getMissionList().forEach(mission -> System.out.println(mission));
    }

    /**
     * 测试新建任务接口
     */
    @Test
    public void testAddMission(){
        Mission mission = new Mission();
        Grade grade = new Grade();
        grade.setGradeId(1l);
        mission.setMissionName("高一摸底考试");
        mission.setEnableStatus(1);
        mission.setGrade(grade);
        MissionExecution missionExecution = missionService.addMission(mission);

    }

    /**
     * 测试编辑任务接口
     */
    @Test
    public void testRedactMission(){
        Mission mission = new Mission();
        mission.setMissionId(2l);
        mission.setBeginTime(new Date());
        MissionExecution missionExecution = missionService.modifyMission(mission);
        System.out.println(missionExecution.getMission().toString());
    }

    /**
     * 测试终止任务接口
     */
    @Test
    public void testAbortMission(){
        Mission mission = new Mission();
        mission.setMissionId(1l);
        mission.setEnableStatus(1);
        MissionExecution missionExecution = missionService.abortMission(mission);
        System.out.println(missionExecution.getMission().toString());
    }
}
