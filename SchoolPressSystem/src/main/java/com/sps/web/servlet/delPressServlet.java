package com.sps.web.servlet;

import com.sps.service.Impl.PressServiceImpl;
import com.sps.service.PressService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "delPressServlet", value = "/delPressServlet")
public class delPressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        PressService service = new PressServiceImpl();
        service.deletePress(id);

        response.sendRedirect(request.getContextPath()+"/findNewsServlet");
    }
}
