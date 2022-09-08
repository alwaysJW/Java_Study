package com.pis.dao;

import com.pis.domain.New;

import java.util.List;

public interface NewDao {
    void addNews(New aNew);

    List<New> findAll();

    New changeById(int id);

    void update(New aNew);

    void deleteNews(int id);
}
