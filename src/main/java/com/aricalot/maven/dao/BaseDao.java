package com.aricalot.maven.dao;

import com.aricalot.maven.domain.Student;

import java.util.ArrayList;

public interface BaseDao {
    int insert(Object o);

    int update(Object o);

    int delete(Object o);

    Boolean find(int id);

    ArrayList<Object> findAll(int sortOrder);
}
