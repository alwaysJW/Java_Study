package com.pis.web.servlet;

import com.pis.domain.User;
import com.pis.service.Impl.UserServiceImpl;
import com.pis.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "findUserServlet", value = "/findUserServlet")
public class findUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
