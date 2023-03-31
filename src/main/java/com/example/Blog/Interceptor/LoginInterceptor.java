package com.example.Blog.Interceptor;

import com.example.Blog.Entity.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {


        String path = request.getServletPath();
        System.out.println(path);
        List<String> tokens = Arrays.stream(path.split("/")).filter(str -> !str.isBlank()).collect(Collectors.toList());


        if (request.getSession().getAttribute("user") == null){
            System.out.println("未登入");
            response.sendRedirect("/login");
            return false;
        } else {
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");
            if(!userInfo.getUsername().equals(tokens.get(1))) {
                System.out.println("權限不足");
                response.sendRedirect("/home/" + tokens.get(1));
                return false;
            }else {
                return true;
            }
        }

    }
}
