package com.team.service;

import com.github.pagehelper.PageInfo;
import com.team.entity.FenYe;
import com.team.entity.Grade;
import com.team.entity.Students;

import java.util.List;

public interface StudentsService {
    public List<Students> getAllStudent();

    //分页查询
    List<Students> fenyechaxun(FenYe fenYe);
    //查询Grade
    List<Grade> allGrade();
    //查询最大行数
    int hangshu(FenYe fenYe);
    //删除
    public int delete(Integer xh);
    //回显、修改
    Students huixian(Integer xh);

    int update(Students students);

    int addStudents(Students students);
    //通过xh查询多条
    List<Students> dantiaochaxun(Integer xh);


    PageInfo<Students> fenye(Integer page,Integer pageSize);

    PageInfo<Students> chaxun(FenYe fenYe);

    PageInfo<Students> selectStudents(FenYe fenYe);

}
