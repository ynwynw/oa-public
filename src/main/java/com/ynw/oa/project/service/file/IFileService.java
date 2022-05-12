package com.ynw.oa.project.service.file;

import com.ynw.oa.project.po.Files;

import java.util.List;

/**
 * @author 俞能武
 */
public interface IFileService{
    /**
     *
     * @描述 添加
     *
     * @date 2020/4/19 11:57
     */
    public int insertSelective(Files file);

    /**
     *
     * @描述 删除
     *
     * @date 2020/4/19 11:57
     */
    public int deleteByPrimaryKeys(String[] ids);

    /**
     *
     * @描述 列表
     *
     * @date 2020/4/19 12:07
     */
    List<Files> selectFileList(Files file);

    void downloadCountAddOne(Files files);
}
