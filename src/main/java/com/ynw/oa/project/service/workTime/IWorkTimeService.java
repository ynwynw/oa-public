package com.ynw.oa.project.service.workTime;

import com.ynw.oa.project.po.WorkTime;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IWorkTimeService{
    int deleteByPrimaryKeys(Integer[] id) throws Exception;

    int insertSelective(WorkTime record) throws Exception;

    WorkTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkTime record) throws Exception;

    WorkTime selectUsing();

    List<WorkTime> selectWorkTimeList(WorkTime workTime);

    int startOrEndWorkTime(WorkTime workTime) throws Exception;
}
