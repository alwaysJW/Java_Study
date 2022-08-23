package com.example.servlet;

import com.example.bean.User;
import com.example.dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);

        user.setPassword(password);
        User login = new UserDao().login(user);
        if (login==null){
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            request.setAttribute("name",username);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }
}
