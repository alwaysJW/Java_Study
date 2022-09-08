package com.cs.dao;

import com.cs.domain.Agent;

import java.util.List;
import java.util.Map;

public interface AgentDao {
    void addAgent(Agent agent);

    int findTotalCount(Map<String, String[]> condition);

    List<Agent> findByPage(int start, int rows, Map<String, String[]> condition);

    void deleteAgent(int id);
}
