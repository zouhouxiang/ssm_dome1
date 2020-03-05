package com.team.service.impl;/*
 *@ClassName GreadServiceImpl
 *@Description
 *@Author   邹总
 *@Date     2020/1/518:28
 *
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.entity.Grade;
import com.team.entity.GradeExample;
import com.team.mapper.GradeMapper;
import com.team.service.GreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GreadServiceImpl implements GreadService {

    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public PageInfo<Grade> fenye(Integer page, Integer pagesize) {
        PageHelper.startPage(page,pagesize);
        List<Grade> list=gradeMapper.selectByExample(new GradeExample());
        PageInfo<Grade> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
