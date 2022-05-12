package com.ynw.oa.project.mapper;

import com.ynw.oa.project.po.UserMeet;

import java.util.List;

public interface UserMeetMapper {

    int deleteByMeetIdKeys(Integer[] id);


    int insertSelective(List<UserMeet> lsit);



}