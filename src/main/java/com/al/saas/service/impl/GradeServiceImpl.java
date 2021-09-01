package com.al.saas.service.impl;

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
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service.impl
 * @ClassName:GradeServiceImpl
 * @Description
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
    public List<Grade> getGradeList() {
        String key = GRADEKEY;
        ListOperations<String,Grade> operations = (ListOperations<String, Grade>) redisTemplate.opsForList();
        List<Grade> gradeList = null;
        if (operations.size(key) == 0 ){
            gradeList = gradeDao.selectList(null);
            operations.leftPushAll(key,gradeList);
            redisTemplate.expire(key,5000, TimeUnit.SECONDS);
        }else {
            //jackson序列化后的json字符串
            List<Grade> lists = operations.range(key,0,-1);
            //jackson解析出具体的bean
            gradeList = mapper.convertValue(lists,new TypeReference<List<Grade>>() {});
        }
        return gradeList;
    }

    @Override
    public Grade getGradeById(Long gradeId) {
        return gradeDao.selectById(gradeId);
    }

    @Override
    public int modifyGrade(Grade grade) {
        return gradeDao.update(grade,null);
    }

    @Override
    public int deleteGrade(Grade grade) {
        return gradeDao.deleteById(grade.getGradeId());
    }

    @Override
    public int addGrade(Grade grade) {
        return gradeDao.insert(grade);
    }
}
