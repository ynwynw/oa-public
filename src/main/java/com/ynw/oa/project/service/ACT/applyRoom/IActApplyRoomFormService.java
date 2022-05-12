package com.ynw.oa.project.service.ACT.applyRoom;

import com.ynw.oa.project.po.ApplyRoomForm;

/**
 * @author 俞能武
 * 预约申请会议室 方法接口
 */
public interface IActApplyRoomFormService{

    /**
    * @ 描述 提交申请
    */
    public void apply(ApplyRoomForm applyRoom);



    /**
     *
     * @描述:  删除
     *
     * @params:
     * @return:
    */
    int deleteByPrimaryKeys(String[] ids)throws Exception;

    /**
     *主键查询
     *
     * @mbggenerated
     */
    ApplyRoomForm selectByPrimaryKey(String id);

    /**
     * 修改状态
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ApplyRoomForm record);

}
