package com.cs.web.servlet;

import com.cs.domain.Agent;
import com.cs.domain.People;
import com.cs.domain.User;
import com.cs.service.AgentService;
import com.cs.service.Impl.AgentServiceImpl;
import com.cs.service.Impl.PeopleServiceImpl;
import com.cs.service.Impl.UserServiceImpl;
import com.cs.service.PeopleService;
import com.cs.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "AddAgentServlet", value = "/AddAgentServlet")
public class AddAgentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Agent agent = new Agent();
        try {
            BeanUtils.populate(agent,map);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        String neighbor = request.getParameter("neighbor");
        UserService service1 = new UserServiceImpl();
        HttpSession session = request.getSession();
        User user = service1.findUserByNei(neighbor);
        session.setAttribute("user5",user);
        System.out.println(user);
        AgentService service = new AgentServiceImpl();
        service.addPeople(agent);
        //跳转
        response.sendRedirect(request.getContextPath()+"/findPerByStatusServlet");
    }
}
