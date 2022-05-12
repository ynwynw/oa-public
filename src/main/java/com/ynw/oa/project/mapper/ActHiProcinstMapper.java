package com.ynw.oa.project.mapper;

import com.ynw.oa.project.po.ActHiProcinst;

import java.util.List;

public interface ActHiProcinstMapper{

    /**
     * 批量删除
     */
    int deleteByPrimaryKeys(String[] id);

    /**
     * 根据主键查询
     */
    ActHiProcinst selectByPrimaryKey(String id);

    /**
     *
     * @描述: 根据实例id查询 判断改实例是否已经结束
     *
     * @params:
     * @return：
     * @date： 2020/4/23 15:18
     */
    ActHiProcinst selectByProcInstId(String procInstId);

    /**
     * @ 描述 列表
     * @date 2020/4/23 12:02
     */
    List<ActHiProcinst> selectActHiProcinstList(ActHiProcinst actHiProcinst);

}