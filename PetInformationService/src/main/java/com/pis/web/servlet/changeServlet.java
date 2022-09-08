package com.pis.web.servlet;

import com.pis.domain.New;
import com.pis.domain.User;
import com.pis.service.Impl.NewsServiceImpl;
import com.pis.service.Impl.UserServiceImpl;
import com.pis.service.NewsService;
import com.pis.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

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
        NewsService service = new NewsServiceImpl();
        New aNew = service.changeById(id);
        request.setAttribute("news", aNew);
        request.getRequestDispatcher("/updateNews.jsp").forward(request,response);
    }
}
