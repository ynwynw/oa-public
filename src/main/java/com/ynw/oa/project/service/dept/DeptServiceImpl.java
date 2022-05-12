package com.ynw.oa.project.service.dept;

import com.ynw.oa.common.constant.CsEnum;
import com.ynw.oa.common.utils.StringUtils;
import com.ynw.oa.project.mapper.DeptMapper;
import com.ynw.oa.project.mapper.UserMapper;
import com.ynw.oa.project.po.Dept;
import com.ynw.oa.project.po.User;
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
public class DeptServiceImpl implements IDeptService{

    private Logger log = LoggerFactory.getLogger(DeptServiceImpl.class);
    @Autowired
    DeptMapper deptMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * @描述 删除部门
     * @date
     */

    @Override
    public int deleteByPrimaryKeys(String[] ids) throws Exception
    {
        User user = new User();
        for (String id : ids)
        {
            user.setDept(Integer.parseInt(id));
            List<User> users = userMapper.selectByUser(user);
            if (users.size() > 0)
            {
                throw new Exception("部门存在用户，不允许删除！");
            }
        }
        try
        {
            return deptMapper.deleteByPrimaryKeys(ids);
        }
        catch (Exception e)
        {
            log.error("$$$$$ 删除部门失败=[{}]", e);
            throw new RuntimeException("操作失败！");
        }
    }


    /**
     *
     * @描述 添加
     *
     * @date
     */
    @Override
    public int insertSelective(Dept record)
    {
        return deptMapper.insertSelective(record);
    }


    /**
     *
     * @描述 通过id
     *
     * @date
     */
    @Override
    public Dept selectByPrimaryKey(String depId)
    {
        return deptMapper.selectByPrimaryKey(depId);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) throws Exception
    {
        //如果当前部门下 有员工 无法删除

        if (record.getStatus() == 1) //停用部门
        {
            User user = new User();
            user.setDept(record.getDepId());
            List<User> users = userMapper.selectByUser(user);
            if (users.size() > 0)
            {
                throw new Exception("部门已分配，不允许停用！");
            }
        }
        return deptMapper.updateByPrimaryKeySelective(record);
    }




    /**
     * @描述 部门列表
     * @date
     */
    @Override
    public List<Dept> selectDeptList(Dept dept)
    {
        return deptMapper.selectDeptList(dept);
    }


    /**
     * 校验部门名称是否唯一
     *
     * @param dept 部门信息
     *
     * @return 结果
     */
    @Override
    public String checkDeptNameUnique(Dept dept)
    {

        if (dept.getDepId() == null)
        {
            dept.setDepId(-1);
        }
        Integer deptId = dept.getDepId();
        Dept info = deptMapper.checkDeptNameUnique(dept.getDeptName());

//        判断查询出来的和传进来的是否相同
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getDepId())
                && !info.getDepId().equals(deptId))
        {
            return CsEnum.unique.NOT_UNIQUE.getValue();
        }
        return CsEnum.unique.IS_UNIQUE.getValue();
    }

    /**
     *
     * @描述: 查询所有部门下的所有用户 用户归类 树状数据
     *
     * @date:
     */
    @Override
    public List<Dept> selectDeptAndUser()
    {
        return deptMapper.selectDeptAndUser();
    }
}
