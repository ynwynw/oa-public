package com.ynw.oa.common.exception.permission;

import com.ynw.oa.common.utils.AjaxUtis;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 俞能武
 *
 * 解决权限异常
 *
 */
@Component
public class PermisExceptionResolver implements HandlerExceptionResolver{

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex)
    {

        if (!AjaxUtis.isAjax(request))
        {
            // 如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url
            if (ex instanceof UnauthorizedException)
            {
                ModelAndView mv = new ModelAndView("error/unauth.html");
                return mv;
            }
        }else {
            if (ex instanceof UnauthorizedException)
            {
                Map<String, String> map = new HashMap<>();
                map.put("code", "1");
                map.put("msg", "对不起，权限不足");
                AjaxUtis.out(response,map);
            }
        }



        return null;

    }

}
