package com.cs.web.servlet;

import com.cs.domain.Login;
import com.cs.service.Impl.LoginServiceImpl;
import com.cs.service.LoginService;
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

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //先校验验证码
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checkCode_servlet = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");//确保验证码一次性
        if (!checkCode_servlet.equalsIgnoreCase(verifycode)){
            //验证码不正确
            request.setAttribute("login_msg","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        Map<String, String[]> map = request.getParameterMap();
        Login login = new Login();
        try {
            BeanUtils.populate(login,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        LoginService service = new LoginServiceImpl();
        Login loginUser = service.login(login);
        if (login!=null){
            //登陆成功
            session.setAttribute("login",loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/findPerByStatusServlet");
        }else {
            request.setAttribute("login_msg","账号或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
