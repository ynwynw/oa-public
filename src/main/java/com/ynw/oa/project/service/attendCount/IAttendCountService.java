package com.ynw.oa.project.service.attendCount;

import com.ynw.oa.project.po.AttendCount;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IAttendCountService{
    int deleteByPrimaryKeys(Integer[] id);

    void insertSelective();

    AttendCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AttendCount record);

    List<AttendCount> selectAttendCountList(AttendCount attend);

}
