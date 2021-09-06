package com.al.saas.controller;

import com.al.saas.consist.GradeExecution;
import com.al.saas.consist.MissionExecution;
import com.al.saas.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.controller
 * @ClassName:MissionController
 * @Description
 * @date2021/9/6 12:27
 */
@RestController
@RequestMapping(value = "/assa")
public class MissionController {
    @Resource
    private MissionService missionService;

    @GetMapping(value = "/getmissionlist")
    private Map<String,Object> getMissionList(){
        Map<String,Object> modelMap = new HashMap<>();
        try {
            MissionExecution me = new MissionExecution();
            me = missionService.getMissionList();
            if (me.getMissionList() != null){
                modelMap.put("success",true);
                modelMap.put("gradeList",me.getMissionList());
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg","查询失败！");
            }
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }
}
