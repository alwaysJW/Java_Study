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

import java.io.IOException;

@WebServlet(name = "findPeoServlet", value = "/findPeoServlet")
public class findPeoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        PeopleService service = new PeopleServiceImpl();
        People people = service.findPeoById(id);
        request.setAttribute("user", people);
        request.getRequestDispatcher("/updatePeo.jsp").forward(request,response);
    }
}
