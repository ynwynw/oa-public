package com.ynw.oa.project.service.operlog;

import com.ynw.oa.project.po.OperLog;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IOperLogService{
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(OperLog record);

    OperLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperLog record);

    List<OperLog> selectOperLogList(OperLog operLog);

}
