package com.sms.web.servlet;

import com.sms.service.Impl.StudentServiceImpl;
import com.sms.service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "delSelectServlet", value = "/delSelectServlet")
public class delSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("uid");
        StudentService service = new StudentServiceImpl();
        service.delSelectedStu(ids);
        response.sendRedirect(request.getContextPath()+"/findStuByPageServlet");
    }
}
