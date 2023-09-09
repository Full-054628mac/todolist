package com.example.todo.domain.todo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ToDoRepository {
    @Select("select * from todos")
    List<ToDoEntity> findAll();

    @Insert("insert into todos (summary,description) values (#{summary},#{description})")
    void insert(String summary, String description);

    @Select("select * from todos where id = #{todoId}")
    ToDoEntity findById(long todoId);
}
