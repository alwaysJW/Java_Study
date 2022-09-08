package com.pis.service;

import com.pis.domain.New;

import java.util.List;

public interface NewsService {
    void addNews(New aNew);

    List<New> findAll();

    New changeById(String id);

    void updateNews(New aNew);

    void deleteNews(String id);
}
