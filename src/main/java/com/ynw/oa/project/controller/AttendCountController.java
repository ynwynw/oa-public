package com.ynw.oa.project.controller;

import com.ynw.oa.framework.web.controller.BaseController;
import com.ynw.oa.framework.web.page.TableDataInfo;
import com.ynw.oa.framework.web.po.AjaxResult;
import com.ynw.oa.project.po.AttendCount;
import com.ynw.oa.project.service.attendCount.IAttendCountService;
import com.ynw.oa.project.service.workTime.IWorkTimeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 俞能武
 */
@Controller
@RequestMapping("/attendCount")
public class AttendCountController extends BaseController {
    private String prefix = "system/attendCount/";
    @Autowired
    IAttendCountService iAttendCountService;

    @Autowired
    IWorkTimeService iWorkTimeService;



    /**
     *
     * @描述: 跳转
     *
     * @params:
     * @return:
     * @date: 2018/10/2 18:12
     */

    @RequestMapping("/tolist")
    public String toList(Model model)
    {
        return prefix + "attendCount";
    }


    /**
     *
     * @描述 表格列表
     *
     * @date 2020/4/16 10:52
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo listPag(AttendCount attendCount)
    {
        startPage();
        List<AttendCount> attendCounts = iAttendCountService.selectAttendCountList(attendCount);
        return getDataTable(attendCounts);
    }


    /**
     *
     * @描述 批量删除
     *
     * @date 2020/4/16 11:53
     */
    @RequestMapping("/del")
    @RequiresPermissions("attendCount:del")
    @ResponseBody
    public AjaxResult del(Integer[] ids)
    {
        try
        {
            iAttendCountService.deleteByPrimaryKeys(ids);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
        return success();
    }



}
