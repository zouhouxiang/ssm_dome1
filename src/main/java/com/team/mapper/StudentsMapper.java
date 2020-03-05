package com.team.mapper;

import com.team.entity.FenYe;
import com.team.entity.Students;
import com.team.entity.StudentsExample;
import java.util.List;

public interface StudentsMapper {
    int deleteByPrimaryKey(Integer xh);

    int insert(Students record);

    int insertSelective(Students record);

    List<Students> selectByExample(StudentsExample example);

    Students selectByPrimaryKey(Integer xh);

    int updateByPrimaryKeySelective(Students record);

    int updateByPrimaryKey(Students record);

    //分页查询
    List<Students> fenyechaxun(FenYe fenYe);
    //查询最大行数
    int hangshu(FenYe fenYe);

    //通过xh查询多条
    List<Students> dantiaochaxun(Integer xh);

    List<Students> selectStudents(FenYe fenYe);
}