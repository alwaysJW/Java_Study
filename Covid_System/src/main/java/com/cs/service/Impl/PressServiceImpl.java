package com.cs.service.Impl;



import com.cs.dao.Impl.PressDaoImpl;
import com.cs.dao.PressDao;
import com.cs.domain.Press;
import com.cs.service.PressService;

import java.util.List;

public class PressServiceImpl implements PressService {
    private final PressDao dao=new PressDaoImpl();
    @Override
    public List<Press> findAll() {
        return dao.findAll();
    }

    @Override
    public void addPress(Press press) {
        dao.addPress(press);
    }

    @Override
    public Press changeById(String id) {

        return dao.changeById(Integer.parseInt(id));
    }

    @Override
    public void updateNews(Press press) {
        dao.updateNews(press);
    }

    @Override
    public void deletePress(String id) {
        dao.deletePress(Integer.parseInt(id));
    }
}
