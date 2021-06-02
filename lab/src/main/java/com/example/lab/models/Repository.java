package com.example.lab.models;

import java.util.*;

public class Repository<T> {
    ArrayList<T> list= new ArrayList();

    public void create(T object)
    {
        list.add(object);
    }

    public int size()
    {
        return list.size();
    }

    public T read(int i)
    {
        return list.get(i);
    }

    public void update(int i, T object)
    {
        list.set(i,object);
    }

    public List<T> readAll()
    {
        return list;
    }

    public void delete(T object)
    {
        list.remove(object);
    }

    public void deleteAll() {
        list.clear();
    }

    public String toString()
    {
        return list.toString();
    }

}