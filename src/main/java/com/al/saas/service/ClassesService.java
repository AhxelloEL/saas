package com.al.saas.service;

import com.al.saas.domain.Classes;

import java.util.List;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.service
 * @InterfaceName:ClassesService
 * @Description
 * @date2021/9/1 12:32
 */
public interface ClassesService {
    /**
     * 分页查询所有班级
     * @return
     */
    List<Classes> queryClassesList();

    /**
     * 根据班级id查询
     * @param classesId
     * @return
     */
    Classes queryClassesById(Long classesId);

}
