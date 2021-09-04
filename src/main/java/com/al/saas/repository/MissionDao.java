package com.al.saas.repository;

import com.al.saas.domain.Mission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.repository
 * @ClassName:MissionDao
 * @Description 任务调度接口
 * @date2021/9/4 12:24
 */
public interface MissionDao extends BaseMapper<Mission> {

    /**
     * 查询所有任务
     * @return
     */
    List<Mission> queryMissionList();

    /**
     * 新建任务
     * @param mission
     * @return
     */
    int addMission(Mission mission);

    /**
     * 编辑任务
     * @param mission
     * @return
     */
    int redactMission(Mission mission);

    /**
     * 终止任务 将状态置为0
     * @param mission
     * @return
     */
    int abortMission(Mission mission);

}
