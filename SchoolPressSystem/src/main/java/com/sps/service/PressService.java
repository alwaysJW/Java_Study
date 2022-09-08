package com.sps.service;

import com.sps.domain.Press;

import java.util.List;

public interface PressService {
    List<Press> findAll();

    void addPress(Press press);

    Press changeById(String id);

    void updateNews(Press press);

    void deletePress(String id);
}
