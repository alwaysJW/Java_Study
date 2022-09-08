package com.cs.web.servlet;

import com.cs.domain.Press;
import com.cs.service.Impl.PressServiceImpl;
import com.cs.service.PressService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "findNewsServlet", value = "/findNewsServlet")
public class findNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PressService service = new PressServiceImpl();
        List<Press> press = service.findAll();
        request.setAttribute("press", press);
        request.getRequestDispatcher("/top.jsp").forward(request,response);
    }
}
