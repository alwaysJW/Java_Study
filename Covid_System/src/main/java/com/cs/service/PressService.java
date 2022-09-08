package com.cs.service;

import com.cs.domain.Press;


import java.util.List;

public interface PressService {
    List<Press> findAll();

    void addPress(Press press);

    Press changeById(String id);

    void updateNews(Press press);

    void deletePress(String id);
}
