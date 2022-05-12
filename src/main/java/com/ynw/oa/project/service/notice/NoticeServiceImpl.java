package com.ynw.oa.project.service.notice;

import com.ynw.oa.project.mapper.NoticeMapper;
import com.ynw.oa.project.po.Notice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 俞能武
 */
@Service
@Transactional
public class NoticeServiceImpl implements INoticeService{
    private Logger log= LoggerFactory.getLogger(NoticeServiceImpl.class);

    @Autowired
    NoticeMapper noticeMapper;

    /**
     *
     * @描述 批量删除
     *
     * @date 2020/4/18 21:13
     */
    @Override
    public int deleteByPrimaryKeys(Integer[] positionId) throws RuntimeException
    {
        try
        {
            return noticeMapper.deleteByPrimaryKeys(positionId);
        }
        catch (RuntimeException e)
        {
            log.error("$$$$$ 删除公失败=[{}]",e);
            throw new RuntimeException("操作失败！");
        }
    }

    /**
     *
     * @描述 添加
     *
     * @date 2020/4/18 20:19
     */
    @Override
    public int insertSelective(Notice record)
    {
        return noticeMapper.insertSelective(record);
    }


    /**
     *
     * @描述 根据id查
     *
     * @date 2020/4/18 20:19
     */
    @Override
    public Notice selectByPrimaryKey(Integer id)
    {
        return noticeMapper.selectByPrimaryKey(id);
    }

    /**
     *
     * @描述 修改
     *
     * @date 2020/4/18 20:20
     */
    @Override
    public int updateByPrimaryKeySelective(Notice record)
    {
        return noticeMapper.updateByPrimaryKeySelective(record);
    }

    /**
     *
     * @描述  公告列表
     *
     * @date 2020/4/18 20:20
     */
    @Override
    public List<Notice> selectNoticeList(Notice record)
    {
        return noticeMapper.selectNoticeList(record);
    }
}
