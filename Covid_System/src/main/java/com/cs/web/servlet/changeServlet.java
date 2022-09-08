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
