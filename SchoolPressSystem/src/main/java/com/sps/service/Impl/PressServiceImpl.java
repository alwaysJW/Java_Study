package com.sps.service.Impl;

import com.sps.dao.Impl.PressDaoImpl;
import com.sps.dao.PressDao;
import com.sps.domain.Press;
import com.sps.service.PressService;

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
