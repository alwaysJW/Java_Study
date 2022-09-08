package com.pis.web.servlet;

import com.pis.domain.Login;
import com.pis.service.Impl.LoginServiceImpl;
import com.pis.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "forgetServlet", value = "/forgetServlet")
public class forgetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Login login = new Login();
        try {
            BeanUtils.populate(login,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        LoginService service = new LoginServiceImpl();
        Login loginUser = service.forget(login);
        if (loginUser!=null){
            request.setAttribute("forget",loginUser);
            request.getRequestDispatcher("/findPassword.jsp").forward(request,response);
        }else {
            request.setAttribute("login_msg","用户名和昵称不匹配");
            request.getRequestDispatcher("forget.jsp").forward(request,response);
        }
    }
}
