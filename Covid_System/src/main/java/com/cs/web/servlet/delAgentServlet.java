package com.cs.web.servlet;

import com.cs.service.AgentService;
import com.cs.service.Impl.AgentServiceImpl;
import com.cs.service.Impl.UserServiceImpl;
import com.cs.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "delAgentServlet", value = "/delAgentServlet")
public class delAgentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        AgentService service = new AgentServiceImpl();
        service.deleteAgent(id);
        response.sendRedirect(request.getContextPath()+"/findAgentByPageServlet");
    }
}
