package com.cs.service.Impl;

import com.cs.dao.Impl.PeopleDaoImpl;
import com.cs.dao.PeopleDao;
import com.cs.domain.PageBean;
import com.cs.domain.People;
import com.cs.service.PeopleService;

import java.util.List;
import java.util.Map;

public class PeopleServiceImpl implements PeopleService {
    private final PeopleDao dao=new PeopleDaoImpl();
    @Override
    public PageBean<People> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage<=0){
            currentPage=1;
        }
        //创建空对象
        PageBean<People> pb = new PageBean<>();
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
        List<People> list = dao.findByPage(start, rows, condition);
        pb.setTotalPage(totalPage);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        return pb;
    }

    @Override
    public void addPeople(People people) {
        dao.addPeople(people);
    }

    @Override
    public People findPeoById(String id) {
        return dao.findPeoById(Integer.parseInt(id));
    }

    @Override
    public void updatePeo(People people) {
        dao.updatePeo(people);
    }
}
