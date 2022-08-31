package com.sms.web.servlet;

import com.sms.domain.PageBean;
import com.sms.domain.Student;
import com.sms.service.Impl.StudentServiceImpl;
import com.sms.service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "/findStuByPageServlet", value = "/findStuByPageServlet")
public class findStuByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的条数
        if (currentPage==null||"".equals(currentPage)){
            currentPage="1";
        }
        if (rows==null||"".equals(rows)){
            rows="5";
        }

        Map<String, String[]> condition = request.getParameterMap();

        StudentService service=new StudentServiceImpl();
        PageBean<Student> pb=service.findStuByPage(currentPage,rows,condition);

        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
