package com.ynw.oa.project.service.ACT.hiActInst;

import com.ynw.oa.project.mapper.ActHiActinstMapper;
import com.ynw.oa.project.po.ActHiActinst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 俞能武
 */
@Service
@Transactional
public class ActHiActInstServiceImpl implements IActHiActInstService{

    @Autowired
    ActHiActinstMapper actHiActinstMapper;

    /**
     *
     * @描述: 通过 实例Id 删除与该实例历史活动相关信息
     *
     * @params:
     * @return:
    */
    @Override
    public int deleteByProcInstId(String[] procInstIds)
    {
        return actHiActinstMapper.deleteByProcInstId(procInstIds);
    }

    /**
     *
     * @描述: 通过实例Id 获取该活动信息
     *
     * @params:
     * @return:
    */
    @Override
    public List<ActHiActinst> selectByByProcInstId(String procInstId)
    {
        return actHiActinstMapper.selectByByProcInstId(procInstId);
    }
}
