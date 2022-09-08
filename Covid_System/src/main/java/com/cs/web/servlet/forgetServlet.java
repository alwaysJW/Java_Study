package com.cs.web.servlet;

import com.cs.domain.Login;
import com.cs.service.Impl.LoginServiceImpl;
import com.cs.service.LoginService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
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
        request.setCharacterEncoding("utf-8");
        //先校验验证码
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checkCode_servlet = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");//确保验证码一次性
        if (!checkCode_servlet.equalsIgnoreCase(verifycode)){
            //验证码不正确
            request.setAttribute("login_msg","验证码错误");
            request.getRequestDispatcher("/forget.jsp").forward(request,response);
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
        Login loginUser = service.forget(login);
        if (loginUser!=null){
            /*//登陆成功
            session.setAttribute("login",loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/findPassword.jsp");*/
            request.setAttribute("forget",loginUser);
            request.getRequestDispatcher("/findPassword.jsp").forward(request,response);
        }else {
            request.setAttribute("login_msg","用户名和昵称不匹配");
            request.getRequestDispatcher("forget.jsp").forward(request,response);
        }
    }
}
