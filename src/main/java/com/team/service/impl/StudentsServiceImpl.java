package com.team.service.impl;/*
 *@ClassName StudentsServiceImpl
 *@Description
 *@Author   邹总
 *@Date     2020/1/216:02
 *
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.entity.*;
import com.team.mapper.GradeMapper;
import com.team.mapper.StudentsMapper;
import com.team.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


//@Component
@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Students> getAllStudent() {
        return studentsMapper.selectByExample(new StudentsExample());
    }

    @Override
    public List<Students> fenyechaxun(FenYe fenYe) {
        return studentsMapper.fenyechaxun(fenYe);
    }

    @Override
    public List<Grade> allGrade() {
        return gradeMapper.selectByExample(new GradeExample());
    }

    @Override
    public int hangshu(FenYe fenYe) {
        return studentsMapper.hangshu(fenYe);
    }

    @Override
    public int delete(Integer xh) {
        return studentsMapper.deleteByPrimaryKey(xh);
    }

    @Override
    public Students huixian(Integer xh) {
        return studentsMapper.selectByPrimaryKey(xh);
    }

    @Override
    public int update(Students students) {
        return studentsMapper.updateByPrimaryKeySelective(students);
    }

    @Override
    public int addStudents(Students students) {
        return studentsMapper.insertSelective(students);
    }

    @Override
    public List<Students> dantiaochaxun(Integer xh) {
        return studentsMapper.dantiaochaxun(xh);
    }

    @Override
    public PageInfo<Students> fenye(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Students> list=studentsMapper.selectByExample(new StudentsExample());
        PageInfo<Students> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Students> chaxun(FenYe fenYe) {
        PageHelper.startPage(fenYe.getPage(),fenYe.getPagesize());
        StudentsExample studentsExample=new StudentsExample();
        StudentsExample.Criteria criteria = studentsExample.createCriteria();
        if (fenYe.getName()!=null){
            criteria.andNameLike("%"+fenYe.getName()+"%");
        }
        if (fenYe.getAage()!=null){
            criteria.andAgeLessThanOrEqualTo(fenYe.getAage());
        }
        if (fenYe.getEndage()!=null){
            criteria.andAgeGreaterThanOrEqualTo(fenYe.getEndage());
        }
        List<Students> list=studentsMapper.selectByExample(studentsExample);
        PageInfo<Students> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Students> selectStudents(FenYe fenYe) {
        PageHelper.startPage(fenYe.getPage(),fenYe.getPagesize());
        List<Students> list=studentsMapper.selectStudents(fenYe);
        return new PageInfo<Students>(list);
    }
}
