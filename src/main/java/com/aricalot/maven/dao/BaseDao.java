package com.aricalot.maven.dao;

import java.util.ArrayList;

public interface BaseDao {
    void insert(Object o);

    void update(Object o);

    void delete(Object o);

    Boolean search(int id);

    ArrayList<Object> findAll(int sortOrder);
}
