package com.cs.service;

import com.cs.domain.Agent;
import com.cs.domain.PageBean;

import java.util.Map;

public interface AgentService {
    void addPeople(Agent agent);

    PageBean<Agent> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    void deleteAgent(String id);
}
