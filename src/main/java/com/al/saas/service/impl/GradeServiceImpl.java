package com.al.saas.service.impl;

import com.al.saas.consist.GradeExecution;
import com.al.saas.constant.GradeStatusEnum;
import com.al.saas.domain.Grade;
import com.al.saas.repository.GradeDao;
import com.al.saas.service.GradeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service.impl
 * @ClassName:GradeServiceImpl
 * @Description 任务调度实体类返回值增强
 * @date2021/8/31 14:44
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    private GradeDao gradeDao;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    ObjectMapper mapper;

    @Override
    public GradeExecution getGradeList() {
        //TODO
        List<Grade> gradeList = gradeDao.selectList(null);
        GradeExecution gradeExecution = new GradeExecution();
        if (gradeList != null){
            gradeExecution.setGradeList(gradeList);
        }
        return gradeExecution;
    }

    @Override
    public Grade getGradeById(Long gradeId) {
        return gradeDao.selectById(gradeId);
    }

    @Override
    public GradeExecution modifyGrade(Grade grade) {
        if (grade != null && grade.getGradeId() != null){
            return new GradeExecution(GradeStatusEnum.NULL_GRADE);
        }
        try {
            grade.setLastEditTime(new Date());
            int effectNum = gradeDao.updateGradeById(grade);
            if (effectNum <= 0){
                return new GradeExecution(GradeStatusEnum.INNER_ERROR);
            }else {
                grade = gradeDao.selectById(grade.getGradeId());
                return new GradeExecution(GradeStatusEnum.SUCCESS,grade);
            }
        }catch (Exception e){
            throw new RuntimeException("更新年级信息失败："+e.getMessage());
        }
    }

    @Override
    public GradeExecution deleteGrade(long gradeId) {
        if (gradeId <= 0){
            return new GradeExecution(GradeStatusEnum.NULL_GRADE);
        }
        try {
            int effectNum = gradeDao.deleteGradeById(gradeId);
            if (effectNum <= 0 ){
                return new GradeExecution(GradeStatusEnum.INNER_ERROR);
            }else {
                return new GradeExecution(GradeStatusEnum.SUCCESS);
            }
        }catch (Exception e){
            throw new RuntimeException("删除年级信息失败："+e.getMessage());
        }
    }

    @Override
    public GradeExecution addGrade(Grade grade) {
        if (grade != null && grade.getGradeId() != null){
            try {
                grade.setCreateTime(new Date());
                int effectNum = gradeDao.insert(grade);
                if (effectNum <= 0){
                    return new GradeExecution(GradeStatusEnum.INNER_ERROR);
                }
            }catch (Exception e){
                throw new RuntimeException("添加年级信息失败："+e.getMessage());
            }
        }else {
            return new GradeExecution(GradeStatusEnum.NULL_GRADE);
        }
        return new GradeExecution(GradeStatusEnum.SUCCESS,grade);
    }
}
