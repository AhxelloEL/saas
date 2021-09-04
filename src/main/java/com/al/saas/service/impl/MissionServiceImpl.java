package com.al.saas.service.impl;

import com.al.saas.domain.Mission;
import com.al.saas.repository.MissionDao;
import com.al.saas.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service.impl
 * @ClassName:MissionServiceImpl
 * @Description 任务调度接口实现
 * @date2021/9/4 13:25
 */
public class MissionServiceImpl implements MissionService {
    @Autowired
    private MissionDao missionDao;

    @Override
    public List<Mission> getMissionList() {
        return missionDao.queryMissionList();
    }

    @Override
    public int addMission(Mission mission) {
        if (mission != null && mission.getMissionId() != null){
            //初始化发布时间
            mission.setCreateTime(new Date());
            missionDao.addMission(mission);
        }else {
            return 0;
        }
        return 1;
    }

    @Override
    public int modifyMission(Mission mission) {
        if (mission != null && mission.getMissionId() != null){
            missionDao.redactMission(mission);
        }else {
            return 0;
        }
        return 1;
    }

    @Override
    public int abortMission(Mission mission) {
        if (mission != null && mission.getMissionId() != null){
            missionDao.abortMission(mission);
        }else {
            return 0;
        }
        return 1;
    }
}
