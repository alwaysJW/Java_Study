package com.cs.web.servlet;

import com.cs.domain.Agent;
import com.cs.domain.PageBean;
import com.cs.domain.User;
import com.cs.service.AgentService;
import com.cs.service.Impl.AgentServiceImpl;
import com.cs.service.Impl.UserServiceImpl;
import com.cs.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "findAgentByPageServlet", value = "/findAgentByPageServlet")
public class findAgentByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数
        if (currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if (rows==null||"".equals(rows)){
            rows="7";
        }

        Map<String, String[]> condition = request.getParameterMap();

        AgentService service=new AgentServiceImpl();
        PageBean<Agent> pb=service.findUserByPage(currentPage,rows,condition);

        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/listAgent.jsp").forward(request,response);
    }
}
