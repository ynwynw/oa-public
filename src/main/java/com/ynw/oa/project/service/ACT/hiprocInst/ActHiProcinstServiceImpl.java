package com.ynw.oa.project.service.ACT.hiprocInst;

import com.ynw.oa.project.mapper.ActHiProcinstMapper;
import com.ynw.oa.project.po.ActHiProcinst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 俞能武
 */
@Service
@Transactional
public class ActHiProcinstServiceImpl implements IActHiProcinstService{


    @Autowired
    ActHiProcinstMapper actHiProcinstMapper;


    /**
     *
     * @描述 : 批量删除
     *
     * @params:
     * @return：
     * @date：
     */

    @Override
    public int deleteByPrimaryKeys(String[] id)
    {
        return actHiProcinstMapper.deleteByPrimaryKeys(id);
    }

    /**
     *
     * @描述:根据主键查询
     *
     * @params:
     * @return：
     * @date：
     */
    @Override
    public ActHiProcinst selectByPrimaryKey(String id)
    {
        return actHiProcinstMapper.selectByPrimaryKey(id);
    }

    /**
     *
     * @描述: 根据实例id查询 判断是否已经结束了改流程
     *
     * @params:
     * @return：
     * @date：
     */
    @Override
    public ActHiProcinst selectByProcInstId(String procInstId)
    {
        return actHiProcinstMapper.selectByProcInstId(procInstId);
    }


    /**
     *
     * @描述: 列表
     *
     * @params:
     * @return：
     * @date：
     */
    @Override
    public List<ActHiProcinst> selectActHiProcinstList(ActHiProcinst actHiProcinst)
    {
        return actHiProcinstMapper.selectActHiProcinstList(actHiProcinst);
    }
}
