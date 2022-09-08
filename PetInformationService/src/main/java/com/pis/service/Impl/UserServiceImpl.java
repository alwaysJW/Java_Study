package com.pis.service.Impl;

import com.pis.dao.Impl.UserDaoImpl;
import com.pis.dao.UserDao;
import com.pis.domain.PageBean;
import com.pis.domain.User;
import com.pis.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final UserDao dao=new UserDaoImpl();
    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage<=0){
            currentPage=1;
        }
        //创建空对象
        PageBean<User> pb = new PageBean<>();
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
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setTotalPage(totalPage);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        return pb;
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }
}
