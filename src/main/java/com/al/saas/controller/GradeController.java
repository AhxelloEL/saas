package com.al.saas.controller;

import com.al.saas.consist.GradeExecution;
import com.al.saas.constant.GradeStatusEnum;
import com.al.saas.domain.Grade;
import com.al.saas.service.GradeService;
import com.al.saas.util.HttpServletRequestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.controller
 * @ClassName:GradeController
 * @Description
 * @date2021/8/31 14:49
 */
@RestController
@RequestMapping("/assa")
public class GradeController {
    @Resource
    private GradeService gradeService;
    @Autowired
    ObjectMapper mapper;

    @GetMapping(value = "/getgradelists")
    private Map<String,Object> getGradeLists(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        try {
            GradeExecution ge = new GradeExecution();
            ge = gradeService.getGradeList();
            if (ge.getGradeList() != null){
                modelMap.put("success",true);
                modelMap.put("gradeList",ge.getGradeList());
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

    @GetMapping(value = "/getgradebyid")
    private Map<String,Object> getGradeById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        GradeExecution gradeExecution = new GradeExecution();
        Long gradeId = HttpServletRequestUtil.getLong(request,"gradeId");
        if (gradeId > -1){
            try {
                Grade grade = gradeService.getGradeById(gradeId);
                modelMap.put("grade",grade);
                modelMap.put("success",true);
            }catch (Exception e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
            }
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty gradeId");
        }
        return modelMap;
    }


    @PostMapping(value = "/addgrade")
    private Map<String,Object> addGrade(HttpServletRequest request){
        //TODO
        Map<String,Object> modelMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Grade grade = null;
        try {
            //获取前端表单信息
            String gradeStr = HttpServletRequestUtil.getString(request,"gradeStr");
            grade = mapper.readValue(gradeStr,Grade.class);
            //判断传入的信息是否为空
            if (grade != null){
                //添加操作
                GradeExecution ge = gradeService.addGrade(grade);
                //判断是否添加成功
                if (ge.getState() == GradeStatusEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                }else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg", ge.getStateInfo());
                }
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg","请输入年级信息");
            }
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.toString());
            return modelMap;
        }
        return modelMap;
    }

}
