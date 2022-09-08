package com.cs.web.servlet;

import com.cs.domain.Login;
import com.cs.domain.User;
import com.cs.service.Impl.LoginServiceImpl;
import com.cs.service.Impl.UserServiceImpl;
import com.cs.service.LoginService;
import com.cs.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "findPassServlet", value = "/findPassServlet")
public class findPassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Login login = new Login();
        try {
            BeanUtils.populate(login,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        LoginService service = new LoginServiceImpl();
        service.findPass(login);
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
}
