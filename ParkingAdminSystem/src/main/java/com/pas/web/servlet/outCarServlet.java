package com.pas.web.servlet;

import com.pas.service.CarService;
import com.pas.service.Impl.CarServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "outCarServlet", value = "/outCarServlet")
public class outCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CarService service = new CarServiceImpl();
        service.outCar(id);

        response.sendRedirect(request.getContextPath()+"/findCarByPageServlet");
    }
}
