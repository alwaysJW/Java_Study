package com.cs.dao;

import com.cs.domain.People;
import java.util.List;
import java.util.Map;

public interface PeopleDao {
    int findTotalCount(Map<String, String[]> condition);

    List<People> findByPage(int start, int rows, Map<String, String[]> condition);

    void addPeople(People people);

    People findPeoById(int id);

    void updatePeo(People people);
}
