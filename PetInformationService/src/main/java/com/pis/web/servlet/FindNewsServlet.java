package com.pis.web.servlet;

import com.pis.domain.New;
import com.pis.service.Impl.NewsServiceImpl;
import com.pis.service.NewsService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "findNewsServlet", value = "/findNewsServlet")
public class FindNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsService service = new NewsServiceImpl();
        List<New> news = service.findAll();
        request.setAttribute("anew", news);
        request.getRequestDispatcher("/xinwen.jsp").forward(request,response);
    }
}
