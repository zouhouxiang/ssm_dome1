package com.team.controller;/*
 *@ClassName ShowStudents
 *@Description
 *@Author   邹总
 *@Date     2020/1/58:16
 *
 */

import com.team.entity.Grade;
import com.team.entity.Students;
import com.team.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShowStudents {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/show1")
    public String login6(Model model) {
        List<Grade> grades = studentsService.allGrade();
        model.addAttribute("grades", grades);
        return "showStudents";
    }

    @RequestMapping("/show2")
    public String login4(HttpServletRequest request, Model model,Grade grade) {
        List<Grade> grades = studentsService.allGrade();
        model.addAttribute("grades", grades);

        /*String xh = request.getParameter("id");
        Students students = studentsService.huixian(Integer.parseInt(xh));
        model.addAttribute("students", students);*/

        int a=0;
        for (Grade g:grades) {
            a++;
            List<Students> list=studentsService.dantiaochaxun(grade.getGid());
            model.addAttribute("list"+a,list);
        }


        return "showStudents";
    }
}