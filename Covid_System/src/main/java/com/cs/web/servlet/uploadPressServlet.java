package com.cs.web.servlet;

import com.cs.domain.Press;
import com.cs.service.Impl.PressServiceImpl;
import com.cs.service.PressService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@MultipartConfig
@WebServlet(name = "uploadPressServlet", value = "/uploadPressServlet")
public class uploadPressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Part part = request.getPart("myfile");
        Map<String, String[]> map = request.getParameterMap();
        String fileName = part.getSubmittedFileName();
        String path="E:\\JavaStudyForWork\\Covid_System\\src\\main\\webapp\\img";
        part.write(path+"/"+fileName);

        Press press = new Press();
        press.setImg(fileName);
        try {
            BeanUtils.populate(press,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        PressService service=new PressServiceImpl();
        service.updateNews(press);
        response.sendRedirect(request.getContextPath()+"/findNewsServlet");
    }
}
