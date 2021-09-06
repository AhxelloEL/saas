package com.al.saas.constant;

import com.al.saas.domain.Mission;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.constant
 * @EnumName:MissionStatusEnum
 * @Description 任务调度枚举类
 * @date2021/9/6 11:58
 */
public enum  MissionStatusEnum {
    /**
     *
     */
    OFFLINE(-1, "非法操作"), SUCCESS(0, "操作成功"), INNER_ERROR(-1001, "操作失败"), EMPTY(
            -1002, "任务信息为空");
    /**
     * 结果状态
     */
    private int state;
    /**
     * 状态标识
     */
    private String stateInfo;

    //--------------------------GET/SET------------------------------------

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    MissionStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    //--------------------------------------------------------------------
    /**
     * 依据传入的state返回相应的enum值
     */
    public static MissionStatusEnum stateOf(int state) {
        for (MissionStatusEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;

    }
}
