package com.sms.service;

import com.sms.domain.PageBean;
import com.sms.domain.Student;

import java.util.Map;

public interface StudentService {
    PageBean<Student> findStuByPage(String currentPage, String rows, Map<String, String[]> condition);

    Student findStuById(String id);

    void updateStu(Student student);

    void addStu(Student student);

    void deleteStu(String id);

    void delSelectedStu(String[] ids);
}
