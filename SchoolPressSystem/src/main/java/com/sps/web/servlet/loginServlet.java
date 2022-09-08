package com.sps.web.servlet;

import com.sps.domain.Login;
import com.sps.service.Impl.LoginServiceImpl;
import com.sps.service.LoginService;
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
        Login user = new Login();
        HttpSession session = request.getSession();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        LoginService service = new LoginServiceImpl();
        Login login = service.login(user);
        if (login!=null){
            //登陆成功
            session.setAttribute("login",login);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/findNewsServlet");

        }else {
            request.setAttribute("login_msg","账号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
