package com.sps.dao;

import com.sps.domain.Press;

import java.util.List;

public interface PressDao {
    List<Press> findAll();

    void addPress(Press press);

    Press changeById(int id);

    void updateNews(Press press);

    void deletePress(int id);
}
