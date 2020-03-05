package com.team.controller;/*
 *@ClassName Gread
 *@Description
 *@Author   邹总
 *@Date     2020/1/518:30
 *
 */

import com.github.pagehelper.PageInfo;
import com.team.entity.Grade;
import com.team.service.impl.GreadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Gread {
    @Autowired
    private GreadServiceImpl greadService;

    @RequestMapping("/gread")
    public String gread(Integer page, Model model){
        if (page==null){
            page=1;
        }
        Integer pagesize=2;
        PageInfo<Grade> pageInfo=greadService.fenye(page,pagesize);
        model.addAttribute("pageInfo",pageInfo);
        return "Gread";
    }



}
