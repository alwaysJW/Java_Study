package com.pis.service.Impl;

import com.pis.dao.Impl.NewDaoImpl;
import com.pis.dao.NewDao;
import com.pis.domain.New;
import com.pis.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private final NewDao dao=new NewDaoImpl();
    @Override
    public void addNews(New aNew) {
        dao.addNews(aNew);
    }

    @Override
    public List<New> findAll() {
        return dao.findAll();
    }

    @Override
    public New changeById(String id) {
        return dao.changeById(Integer.parseInt(id));

    }

    @Override
    public void updateNews(New aNew) {
        dao.update(aNew);
    }

    @Override
    public void deleteNews(String id) {
        dao.deleteNews(Integer.parseInt(id));
    }
}
