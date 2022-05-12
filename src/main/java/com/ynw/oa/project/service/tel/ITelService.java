package com.ynw.oa.project.service.tel;

import com.ynw.oa.project.po.Tel;

import java.util.List;

/**
 * @author 俞能武
 */
public interface ITelService{
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(Tel record);

    Tel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tel record);

    List<Tel> selectTelList(Tel tel);
}
