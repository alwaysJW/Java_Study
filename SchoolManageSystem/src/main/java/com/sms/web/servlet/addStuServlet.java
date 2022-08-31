package com.sms.web.servlet;

import com.sms.domain.Student;
import com.sms.service.Impl.StudentServiceImpl;
import com.sms.service.StudentService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addStuServlet", value = "/addStuServlet")
public class addStuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Student stu = new Student();
        try {
            BeanUtils.populate(stu,map);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        StudentService service = new StudentServiceImpl();
        service.addStu(stu);

        response.sendRedirect(request.getContextPath()+"/findStuByPageServlet");
    }
}
