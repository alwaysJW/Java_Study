package com.sms.domain;

import lombok.Data;

import java.util.List;

/**
 * 分页对象
 */
@Data
public class PageBean<T> {
    private int totalCount;//总记录数
    private int totalPage;//总页码
    private List<T> list;
    private int currentPage;//当前页码
    private int rows;//每页显示的记录数
}