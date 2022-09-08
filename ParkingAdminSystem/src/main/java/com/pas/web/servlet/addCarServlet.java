package com.pas.web.servlet;

import com.pas.domain.Car;
import com.pas.service.CarService;
import com.pas.service.Impl.CarServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addCarServlet", value = "/addCarServlet")
public class addCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Car car = new Car();
        try {
            BeanUtils.populate(car,map);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        CarService service = new CarServiceImpl();
        service.addCar(car);

        response.sendRedirect(request.getContextPath()+"/findCarByPageServlet");
    }
}
