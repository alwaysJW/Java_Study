package com.cs.web.servlet;

import com.cs.service.Impl.UserServiceImpl;
import com.cs.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "delSelectServlet", value = "/delSelectServlet")
public class delSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("uid");
        System.out.println(ids);
        UserService service = new UserServiceImpl();
        service.delSelectedUser(ids);
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }
}
