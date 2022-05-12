package com.ynw.oa.project.mapper;

import com.ynw.oa.project.po.Notice;

import java.util.List;

public interface NoticeMapper{
    /**
     *
     * @描述 批量删除
     *
     * @date 2020/4/18 20:15
     */
    int deleteByPrimaryKeys(Integer[] positionId) throws RuntimeException;

    /**
     *
     * @描述插入
     *
     * @date 2020/4/18 20:15
     */
    int insertSelective(Notice record);

    /**
     *
     * @描述 根据id查询
     *
     * @date 2020/4/18 20:15
     */
    Notice selectByPrimaryKey(Integer id);

    /**
     *
     * @描述 修改
     *
     * @date 2020/4/18 20:15
     */
    int updateByPrimaryKeySelective(Notice record);

    /**
     * 列表
     * @param record
     * @return
     */
    List<Notice> selectNoticeList(Notice record);

}