package com.al.saas.service.impl;

import com.al.saas.consist.GradeExecution;
import com.al.saas.consist.MissionExecution;
import com.al.saas.constant.GradeStatusEnum;
import com.al.saas.constant.MissionStatusEnum;
import com.al.saas.domain.Mission;
import com.al.saas.repository.MissionDao;
import com.al.saas.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service.impl
 * @ClassName:MissionServiceImpl
 * @Description 任务调度接口实现
 * @date2021/9/4 13:25
 */
@Service
public class MissionServiceImpl implements MissionService {
    @Autowired
    private MissionDao missionDao;


    @Override
    public MissionExecution getMissionList() {
        List<Mission> missionList = missionDao.queryMissionList();
        MissionExecution me = new MissionExecution();
        if (missionList != null){
            me.setMissionList(missionList);
        }
        return me;
    }

    @Override
    public MissionExecution addMission(Mission mission) {
        if (mission != null && mission.getMissionId() != null){
           try {
               mission.setCreateTime(new Date());
               int effectNum = missionDao.addMission(mission);
               if (effectNum <= 0){
                   return new MissionExecution(MissionStatusEnum.INNER_ERROR);
               }
           }catch (Exception e){
                throw new RuntimeException("新建任务失败："+e.getMessage());
           }
        }else {
            return new MissionExecution(MissionStatusEnum.EMPTY);
        }
        return new MissionExecution(MissionStatusEnum.SUCCESS,mission);
    }

    @Override
    public MissionExecution modifyMission(Mission mission) {
        if (mission != null && mission.getMissionId() != null){
            return new MissionExecution(MissionStatusEnum.EMPTY);
        }
        try {
            mission.setLastEditTime(new Date());
            int effectNum = missionDao.redactMission(mission);
            if (effectNum <= 0){
                return new MissionExecution(MissionStatusEnum.INNER_ERROR);
            }else {
                //TODO
                mission = missionDao.selectById(mission.getMissionId());
                return new MissionExecution(MissionStatusEnum.SUCCESS,mission);
            }
        }catch (Exception e){
            throw new RuntimeException("更新任务信息失败："+e.getMessage());
        }
    }

    @Override
    public MissionExecution abortMission(Mission mission) {
        if (mission != null && mission.getMissionId() != null){
            return new MissionExecution(MissionStatusEnum.EMPTY);
        }
        try {
            int effectNum = missionDao.abortMission(mission);
            if (effectNum <= 0){
                return new MissionExecution(MissionStatusEnum.INNER_ERROR);
            }else {
                //TODO
                mission = missionDao.selectById(mission.getMissionId());
                return new MissionExecution(MissionStatusEnum.SUCCESS,mission);
            }
        }catch (Exception e){
            throw new RuntimeException("终止任务信息失败："+e.getMessage());
        }
    }
}
