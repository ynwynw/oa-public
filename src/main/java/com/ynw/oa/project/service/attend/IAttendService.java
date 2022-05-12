package com.ynw.oa.project.service.attend;

import com.ynw.oa.project.po.Attend;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IAttendService{
    int deleteByPrimaryKeys(Integer[] id);

    int insertSelective(Attend record) throws Exception;

    Attend selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Attend record);
    List<Attend> selectAttendList(Attend attend);

    Attend selectSaveDayIsAttend(String userId);

}
