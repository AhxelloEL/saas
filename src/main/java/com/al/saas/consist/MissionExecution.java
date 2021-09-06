package com.al.saas.consist;

import com.al.saas.constant.MissionStatusEnum;
import com.al.saas.domain.Mission;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.consist
 * @ClassName:MissionExecution
 * @Description 任务调度实体类增强
 * @date2021/9/6 12:04
 */
@Data
@NoArgsConstructor
public class MissionExecution {
    /**
     * 结果状态
     */
    private int state;
    /**
     * 状态标识
     */
    private String stateInfo;
    /**
     * 用于增删改
     */
    private Mission mission;
    /**
     * 用于查询
     */
    private List<Mission> missionList;
    /**
     * 统计数量
     */
    private int count;

    /**
     * 操作失败调用的构造器
     * @param statusEnum
     */
    public MissionExecution(MissionStatusEnum statusEnum){
        this.state = statusEnum.getState();
        this.stateInfo = statusEnum.getStateInfo();
    }

    /**
     * 操作增删改成功调用的构造器
     * @param statusEnum
     * @param mission
     */
    public MissionExecution(MissionStatusEnum statusEnum,Mission mission){
        this.state = statusEnum.getState();
        this.stateInfo = statusEnum.getStateInfo();
        this.mission = mission;
    }

    /**
     * 操作成功时返回的构造器，用于查询
     * @param statusEnum
     * @param missionsList
     */
    public MissionExecution(MissionStatusEnum statusEnum,List<Mission> missionsList){
        this.state = statusEnum.getState();
        this.stateInfo = statusEnum.getStateInfo();
        this.missionList = missionsList;
    }
}
