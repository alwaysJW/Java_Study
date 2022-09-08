package com.pas.web.servlet;

import com.pas.domain.Car;
import com.pas.service.CarService;
import com.pas.service.Impl.CarServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "findCarServlet", value = "/findCarServlet")
public class findCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CarService service = new CarServiceImpl();
        Car car = service.findUserById(id);
        request.setAttribute("car", car);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
