package com.cs.service.Impl;

import com.cs.dao.AgentDao;
import com.cs.dao.Impl.AgentDaoImpl;
import com.cs.domain.Agent;
import com.cs.domain.PageBean;

import com.cs.service.AgentService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class AgentServiceImpl implements AgentService {
    private final AgentDao dao=new AgentDaoImpl();
    @Override
    public void addPeople(Agent agent) {
        agent.setTime(new Timestamp(System.currentTimeMillis()));
        dao.addAgent(agent);
    }

    /**
     * 分页查找前的操作（计算页码）
     * @param _currentPage 当前页码
     * @param _rows 所在行数
     * @param condition 条件
     * @return
     */
    @Override
    public PageBean<Agent> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage<=0){
            currentPage=1;
        }
        //创建空对象
        PageBean<Agent> pb = new PageBean<>();
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
        List<Agent> list = dao.findByPage(start, rows, condition);
        pb.setTotalPage(totalPage);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        return pb;
    }

    @Override
    public void deleteAgent(String id) {
        dao.deleteAgent(Integer.parseInt(id));
    }
}
