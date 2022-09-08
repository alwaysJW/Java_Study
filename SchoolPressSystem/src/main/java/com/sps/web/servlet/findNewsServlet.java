package com.sps.web.servlet;

import com.sps.domain.Press;
import com.sps.service.Impl.PressServiceImpl;
import com.sps.service.PressService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

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
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
