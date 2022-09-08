package com.sps.web.servlet;

import com.sps.domain.Press;
import com.sps.service.Impl.PressServiceImpl;
import com.sps.service.PressService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "changeServlet", value = "/changeServlet")
public class changeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        PressService service = new PressServiceImpl();
        Press press = service.changeById(id);
        request.setAttribute("press", press);
        request.getRequestDispatcher("/updatePress.jsp").forward(request,response);
    }
}
