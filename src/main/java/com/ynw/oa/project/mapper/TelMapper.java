package com.ynw.oa.project.mapper;

import com.ynw.oa.project.po.Tel;

import java.util.List;

public interface TelMapper {
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(Tel record);

    Tel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tel record);

    List<Tel> selectTelList(Tel tel);

}