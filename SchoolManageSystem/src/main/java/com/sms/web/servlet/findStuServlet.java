package com.sms.web.servlet;

import com.sms.domain.Student;
import com.sms.service.Impl.StudentServiceImpl;
import com.sms.service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "findStuServlet", value = "/findStuServlet")
public class findStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        StudentService service = new StudentServiceImpl();
        Student student = service.findStuById(id);
        request.setAttribute("stu", student);
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
