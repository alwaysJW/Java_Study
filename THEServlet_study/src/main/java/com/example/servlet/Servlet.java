package com.example.servlet;

import com.example.bean.User;
import com.example.dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);*/
        //获取所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //创建User对象
        User loginUser = new User();
        //使用Beanutils
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        User login = new UserDao().login(loginUser);
        if (login==null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            request.setAttribute("user",loginUser);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }
}
