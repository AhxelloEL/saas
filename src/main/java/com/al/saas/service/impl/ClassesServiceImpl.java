package com.al.saas.service.impl;

import com.al.saas.domain.Classes;
import com.al.saas.repository.ClassesDao;
import com.al.saas.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service.impl
 * @ClassName:ClassesServiceImpl
 * @Description
 * @date2021/9/1 12:35
 */
@Service
public class ClassesServiceImpl implements ClassesService {
    @Resource
    private ClassesDao classesDao;

    @Override
    public List<Classes> queryClassesList() {
        return classesDao.selectList(null);
    }

    @Override
    public Classes queryClassesById(Long classesId) {
        return classesDao.selectById(classesId);
    }
}
