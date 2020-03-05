package com.team.service;

import com.github.pagehelper.PageInfo;
import com.team.entity.Grade;

public interface GreadService {
    public PageInfo<Grade> fenye(Integer page,Integer pagesize);
}
