package com.cs.web.servlet;

import com.cs.domain.People;
import com.cs.domain.User;
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

@WebServlet(name = "updatePeoServlet", value = "/updatePeoServlet")
public class updatePeoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        People people = new People();
        try {
            BeanUtils.populate(people,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        PeopleService service = new PeopleServiceImpl();
        service.updatePeo(people);
        response.sendRedirect(request.getContextPath()+"/findPerByStatusServlet");
    }
}
