package com.sms.web.servlet;

import com.sms.domain.Student;
import com.sms.domain.User;
import com.sms.service.Impl.UserServiceImpl;
import com.sms.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        HttpSession session = request.getSession();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        User login = service.login(user);
        if (login!=null){
            //登陆成功
            session.setAttribute("login",login);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/findStuByPageServlet");
        }else {
            request.setAttribute("login_msg","账号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
