package com.ynw.oa.project.service.ACT.hiTaskInst;

import com.ynw.oa.project.po.ActHiTaskInst;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IActHiTaskinistService{
    /**
     *
     * @描述:  删除批量
     *
     * @params:
     * @return:
     * @date:
     */
    int deleteByPrimaryKeys(String[] ids) throws Exception;

    /**
     *
     * @描述: 主键查询
     *
     * @params:
     * @return:
     * @date:
     */
    ActHiTaskInst selectByPrimaryKey(String id);

    /**
     *
     * @描述: 根据审批人查询历史审批记录
     *
     * @params:
     * @return:
     * @date:
     */
    List<ActHiTaskInst> selectActHiTaskInstList(ActHiTaskInst actHiTaskInst);

}
