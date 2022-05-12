package com.ynw.oa.project.service.ACT.hiprocInst;

import com.ynw.oa.project.po.ActHiProcinst;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IActHiProcinstService{
    /**
     * @ 描述 批量删除
     * @ param id
     * @date
     */
    int deleteByPrimaryKeys(String[] id);

    /**
     * @ 描述 根据主键查询
     * @date
     */
    ActHiProcinst selectByPrimaryKey(String id);

    /**
     *
     * @描述: 根据实例id查询 判断改实例是否已经结束
     *
     * @params:
     * @return：
     * @date：
     */
    ActHiProcinst selectByProcInstId(String procInstId);


    /**
     * @ 描述 列表
     * @date
     */
    List<ActHiProcinst> selectActHiProcinstList(ActHiProcinst actHiProcinst);
}
