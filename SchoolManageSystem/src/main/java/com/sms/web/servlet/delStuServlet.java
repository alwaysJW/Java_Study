package com.sms.web.servlet;

import com.sms.dao.Impl.StudentDaoImpl;
import com.sms.service.Impl.StudentServiceImpl;
import com.sms.service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "delStuServlet", value = "/delStuServlet")
public class delStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        StudentService service = new StudentServiceImpl();
        service.deleteStu(id);

        response.sendRedirect(request.getContextPath()+"/findStuByPageServlet");
    }
}
