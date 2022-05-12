package com.ynw.oa.project.mapper;

import com.ynw.oa.project.po.ScheduleUser;

import java.util.List;

public interface ScheduleUserMapper {
    int deleteByPrimaryKeys(Integer[] id);


    int insertSelective(List<ScheduleUser> userList);

}