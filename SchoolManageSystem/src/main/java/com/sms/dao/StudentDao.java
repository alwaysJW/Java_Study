package com.sms.dao;

import com.sms.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    int findTotalCount(Map<String, String[]> condition);

    List<Student> findByPage(int start, int rows, Map<String, String[]> condition);

    Student findById(int id);

    void updateStu(Student student);

    void addStu(Student student);

    void delete(int id);
}
