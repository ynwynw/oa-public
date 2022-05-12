package com.ynw.oa.project.service.ACT.hiActInst;

import com.ynw.oa.project.po.ActHiActinst;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IActHiActInstService{

    /**
     *
     * @描述: 删除活动历史信息
     *
     * @params:
     * @return:
     * @date:
     */
    int deleteByProcInstId(String[] procInstId);

    /**
     *
     * @描述: 根据进程实例id获取当前 实例的活动信息
     *
     * @params:
     * @return:
     * @date:
     */
    List<ActHiActinst> selectByByProcInstId(String procInstId);
}
