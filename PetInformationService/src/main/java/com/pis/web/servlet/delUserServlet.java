package com.pis.web.servlet;

import com.pis.service.Impl.UserServiceImpl;
import com.pis.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "delUserServlet", value = "/delUserServlet")
public class delUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserService service = new UserServiceImpl();
        service.deleteUser(id);

        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }
}
