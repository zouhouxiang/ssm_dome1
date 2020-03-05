package com.team.controller;/*
 *@ClassName StudentsController
 *@Description
 *@Author   邹总
 *@Date     2020/1/216:32
 *
 */

import com.github.pagehelper.PageInfo;
import com.team.entity.FenYe;
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
public class StudentsController {

    @Autowired(required = false)
    private StudentsService studentsService;


    @RequestMapping("/login1")
    public String login1(Model model){
        List<Students> list=studentsService.getAllStudent();
        model.addAttribute("list",list);
        return "index";
    }

    /*@RequestMapping("/login2")
    public String login2(FenYe fenYe, Model model, HttpServletRequest request){
        List<Grade> grades=studentsService.allGrade();
        model.addAttribute("grades",grades);
        String select=request.getParameter("select");
        String textfield=request.getParameter("textfield");
        String pag=request.getParameter("pag");
        int p=pag==null?1:Integer.parseInt(pag);
        int pagesize=5;
        int pages=p/pagesize+1;
        Integer sss=null;
        if (select!=null && !select.equals("")){
            sss=new Integer(select);
        }
        String x=null;
        if (textfield!=null && !textfield.equals("")){
            x=textfield;
        }

        *//*studentsService.hangshu(fenYe);*//*







        fenYe.setPagesize(pagesize);
        fenYe.setPage(pages);
        fenYe.setDz(x);
        fenYe.setGid(sss);
        List<Students> list=studentsService.fenyechaxun(fenYe);
        model.addAttribute("p",p);
        model.addAttribute("pagesize",pagesize);
        model.addAttribute("list",list);

        System.out.println(list);
        return "Show";
    }*/

    @RequestMapping("/login3")
    public String login3(HttpServletRequest request){
        String xh=request.getParameter("id");
        int temp=studentsService.delete(Integer.parseInt(xh));
        System.out.println("返回行数"+temp);
        if (temp>0){
            return "redirect:login10";
        }else {
            return "redirect:login2";
        }
    }

    @RequestMapping("/login4")
    public String login4(HttpServletRequest request,Model model){
        String xh=request.getParameter("id");
        Students students=studentsService.huixian(Integer.parseInt(xh));
        List<Grade> grades=studentsService.allGrade();
        model.addAttribute("grades",grades);
        model.addAttribute("students",students);
        return "update";
    }

    @RequestMapping("/login5")
    public String login5(HttpServletRequest request,Students students){

        int temp=studentsService.update(students);
        System.out.println(temp);
        if (temp>0){
            return "redirect:login10";
        }else {
            return "Show";
        }
    }

    @RequestMapping("/login6")
    public String login6(Model model){
        List<Grade> grades=studentsService.allGrade();
        model.addAttribute("grades",grades);
        return "addStudents";
    }

    @RequestMapping("/login7")
    public String login7(Students students){
        students.setTel("000");
        int temp=studentsService.addStudents(students);
        if (temp>0){
            return "redirect:login10";
        }else {
            return "Show";
        }
    }



    @RequestMapping("/login8")
    public String login8(Integer page,Model model){
        if (page==null){
            page=1;
        }
        Integer pageSize=5;
        PageInfo<Students> pageInfo =studentsService.fenye(page,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }




    @RequestMapping("/login9")
    public String login9(FenYe fenYe,Model model){
        if (fenYe.getPage()==null){
            fenYe.setPage(1);
        }
        fenYe.setPagesize(5);
        PageInfo<Students> pageInfo=studentsService.chaxun(fenYe);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("fenye",fenYe);
        return "index";

    }


    @RequestMapping("/login10")
    public String login10(FenYe fenYe,Model model){
        if (fenYe.getPage()==null){
            fenYe.setPage(1);
        }
        fenYe.setPagesize(5);
        PageInfo<Students> pageInfo=studentsService.selectStudents(fenYe);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("fenye",fenYe);
        return "indexs";
    }
}
