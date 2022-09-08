package com.pis.web.servlet;

import com.pis.service.Impl.NewsServiceImpl;
import com.pis.service.Impl.UserServiceImpl;
import com.pis.service.NewsService;
import com.pis.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "delNewsServlet", value = "/delNewsServlet")
public class delNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NewsService service = new NewsServiceImpl();
        service.deleteNews(id);

        response.sendRedirect(request.getContextPath()+"/findNewsServlet");
    }
}
