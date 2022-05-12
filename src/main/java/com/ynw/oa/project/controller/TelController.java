package com.ynw.oa.project.controller;

import com.ynw.oa.framework.web.controller.BaseController;
import com.ynw.oa.framework.web.page.TableDataInfo;
import com.ynw.oa.framework.web.po.AjaxResult;
import com.ynw.oa.project.po.Tel;
import com.ynw.oa.project.service.meetRoom.IMeetingRoomService;
import com.ynw.oa.project.service.tel.ITelService;
import com.ynw.oa.project.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 俞能武
 */
@Controller
@RequestMapping("/tel")
public class TelController extends BaseController {
    private final static String prefix = "system/tel";

    @Autowired
    ITelService iTelService;

    @Autowired
    IUserService iUserService;
    @Autowired
    IMeetingRoomService iMeetingRoomService;


    /**
     *
     * @描述: 跳转到列表页
     *
     * @params:
     * @return:
     * @date: 2020/4/26 21:13
     */
    @RequestMapping("/tolist")
    public String toList(Model model)
    {
        return prefix + "/tel";
    }



    /**
     *
     * @描述: 返回表格数据
     *
     * @params:
     * @return:
     * @date: 2020/4/26 21:15
     */
    @RequestMapping("/tableList")
    @ResponseBody
    public TableDataInfo tableList(Tel tel)
    {
        startPage();
        List<Tel> tels = iTelService.selectTelList(tel);
        return getDataTable(tels);

    }


    /**
     *
     * @描述: 添加页面
     *
     * @params:
     * @return:
     * @date: 2020/4/26 21:15
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model)
    {
        return prefix + "/add";
    }

    /**
     *
     * @描述: 添加保存
     *
     * @params:
     * @return:
     * @date: 2020/4/26 21:16
     */
    @RequestMapping("/addSave")
    @ResponseBody
    public AjaxResult addSave(Tel tel) throws Exception
    {
        return result(iTelService.insertSelective(tel));
    }

    /**
     *
     * @描述: 删除
     *
     * @params:
     * @return:
     * @date: 2020/4/27 22:02
     */
    @RequestMapping("/del")
    @ResponseBody
    public AjaxResult del(Integer[] ids)
    {
        return result(iTelService.deleteByPrimaryKeys(ids));
    }


    /**
     *
     * @描述: 编辑页面
     *
     * @params:
     * @return:
     * @date: 2020/4/26 21:17
     */
    @RequestMapping("/edit/{id}")
    public String toEdit(@PathVariable("id") Integer id, Model model)
    {
        Tel tel = iTelService.selectByPrimaryKey(id);
        model.addAttribute("tel", tel);
        return prefix + "/edit";
    }


    /**
     *
     * @描述: 修改保存
     *
     * @params:
     * @return:
     * @date: 2020/4/27 21:01
     */
    @RequestMapping("/editSave")
    @ResponseBody
    public AjaxResult editSave(Tel tel)
    {
        return result(iTelService.updateByPrimaryKeySelective(tel));
    }
}
