package com.al.saas.service;

import com.al.saas.consist.MissionExecution;
import com.al.saas.domain.Mission;

import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service
 * @InterFaceName:MissionService
 * @Description 任务调度业务接口
 * @date2021/9/4 13:20
 */
public interface MissionService {
    /**
     * 查看所有任务
     * @return
     */
    MissionExecution getMissionList();

    /**
     * 新建任务
     * @param mission 任务实体类
     * @return 0：新建成功 1：新建失败
     */
    MissionExecution addMission(Mission mission);

    /**
     * 编辑任务
     * @param mission 任务实体类
     * @return 0：编辑成功 1：编辑失败
     */
    MissionExecution modifyMission(Mission mission);

    /**
     * 终止任务(将可用状态置为0)
     * @param mission 任务实体类
     * @return 0：终止成功 1：终止失败
     */
    MissionExecution abortMission(Mission mission);

    /**
     * 根据Id查询
     * @param missionId
     * @return
     */
    //MissionExecution getMissionById(Long missionId);
}
