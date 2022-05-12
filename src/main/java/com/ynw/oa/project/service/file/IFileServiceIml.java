package com.ynw.oa.project.service.file;

import com.ynw.oa.project.mapper.FilesMapper;
import com.ynw.oa.project.po.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 俞能武
 *
 */
@Service
@Transactional
public class IFileServiceIml implements IFileService{

    private Logger log= LoggerFactory.getLogger(IFileServiceIml.class);

    @Autowired
    private FilesMapper fileMapper;

    /**
     *
     * @描述 添加
     *
     * @date
     */
    @Override
    public int insertSelective(Files file)
    {
        return fileMapper.insertSelective(file);
    }

    /**
     *
     * @描述 删除
     *
     * @date
     */
    @Override
    public int deleteByPrimaryKeys(String[] ids)
    {
        try
        {
            return fileMapper.deleteByPrimaryKeys(ids);
        }
        catch (Exception e)
        {
            log.error("$$$$$ 删除文件失败=[{}]",e);
            throw new RuntimeException("操作失败！");
        }
    }

    /**
     *
     * @描述  列表
     *
     * @date
     */
    @Override
    public List<Files> selectFileList(Files file)
    {
        return fileMapper.selectFileList(file);
    }

    /**
     * 下载数量加一
     * @param fileId
     */
    @Override
    public void downloadCountAddOne(Files files)
    {
        fileMapper.updateByPrimaryKeySelective(files);
    }
}
