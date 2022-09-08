package com.cs.web.servlet;

import com.cs.service.Impl.PressServiceImpl;
import com.cs.service.PressService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
