package com.pis.web.servlet;

import com.pis.domain.New;
import com.pis.service.Impl.NewsServiceImpl;
import com.pis.service.NewsService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@MultipartConfig
@WebServlet(name = "uploadServlet", value = "/uploadServlet")
public class uploadServlet extends HttpServlet {
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
        String path="E:\\JavaStudyForWork\\PetInformationService\\src\\main\\webapp\\img";
        part.write(path+"/"+fileName);

        New aNew = new New();
        try {
            BeanUtils.populate(aNew,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        aNew.setImgs(fileName);
        NewsService service=new NewsServiceImpl();
        service.addNews(aNew);
        request.setAttribute("aNew",aNew);
        request.getRequestDispatcher("/findNewsServlet").forward(request,response);
    }
}
