package com.cs.service;

import com.cs.domain.PageBean;
import com.cs.domain.People;

import java.util.Map;

public interface PeopleService {
    PageBean<People> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    void addPeople(People people);

    People findPeoById(String id);

    void updatePeo(People people);
}
