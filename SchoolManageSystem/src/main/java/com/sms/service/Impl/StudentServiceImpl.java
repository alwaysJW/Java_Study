package com.sms.service.Impl;

import com.sms.dao.Impl.StudentDaoImpl;
import com.sms.dao.StudentDao;
import com.sms.domain.PageBean;
import com.sms.domain.Student;
import com.sms.service.StudentService;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private final StudentDao dao = new StudentDaoImpl();
    @Override
    public PageBean<Student> findStuByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage<=0){
            currentPage=1;
        }
        //创建空对象
        PageBean<Student> pb = new PageBean<>();
        //设置参数
        //查询总记录数
        int totalCount = dao.findTotalCount(condition);
        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : ((totalCount / rows) + 1);
        if (currentPage >= totalPage){
            currentPage =totalPage;
        }
        //查询List集合
        //计算开始记录索引
        int start = (currentPage - 1) * rows;
        List<Student> list = dao.findByPage(start, rows, condition);
        pb.setTotalPage(totalPage);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        return pb;
    }

    @Override
    public Student findStuById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateStu(Student student) {
        dao.updateStu(student);
    }

    @Override
    public void addStu(Student student) {
        dao.addStu(student);
    }

    @Override
    public void deleteStu(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public void delSelectedStu(String[] ids) {
        if (ids != null && ids.length > 0) {
            //遍历
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }
}
