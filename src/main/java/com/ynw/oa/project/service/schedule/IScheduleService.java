package com.ynw.oa.project.service.schedule;

import com.ynw.oa.project.po.Schedule;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IScheduleService{
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(Schedule record,String[] userIds);

    Schedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedule record,String[] userIds);

    List<Schedule> selectScheduleList(Schedule schedule);

    int updateComplete(Schedule schedule);
}
