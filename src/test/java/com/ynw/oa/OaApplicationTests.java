package com.ynw.oa;

//import com.ynw.oa.common.utils.json.JsonUtils;
import com.ynw.oa.project.mapper.PermissionMapper;
import com.ynw.oa.project.mapper.RolePermissionMapper;
import com.ynw.oa.project.service.attendCount.IAttendCountService;
import org.activiti.engine.TaskService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests{

    @Autowired
    RolePermissionMapper mapper;

    @Autowired
    IAttendCountService iAttendService;

    @Autowired
    TaskService taskService;

    @Autowired
    PermissionMapper permissionMapper;

    @Test
    public void contextLoads()
    {
        String password = "123456";//明码
        String algorithmName = "MD5";//加密算法
        Object source = password;//要加密的密码

        Object salt = "20200531140837";//盐值，一般都是用户名或者userid，要保证唯一
        int hashIterations = 1024;//加密次数

        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        System.out.println(simpleHash);//打印出经过盐值、加密次数、md5后的密码
//        Date date=DateUtils.StrToDate("2018-10-10 11:12:11");
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        System.out.println(c.get(Calendar.HOUR_OF_DAY));
//        System.out.println(c.get(Calendar.MINUTE));
//        System.out.println(c.get(Calendar.SECOND));
    }
}