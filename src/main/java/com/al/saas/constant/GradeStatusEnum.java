package com.al.saas.constant;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.constant
 * @EnumName:GradeEnum
 * @Description
 * @date2021/8/31 15:04
 */

public enum GradeStatusEnum {
    /**
     *
     */
    CHECK(0,"审核中"),OFFLINE(-1,"非法操作"),SUCCESS(1,"操作成功"),
    PASS(2,"通过验证"),INNER_ERROR(-1001,"内部系统错误"),NULL_GRADE(-1003,"年级信息为空");

    private int state;
    private String stateInfo;

    /**
     * 依据传入的state返回相应的enum值
     */
    public static GradeStatusEnum stateOf(int state) {
        for (GradeStatusEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;

    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    GradeStatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
}