package com.example.todo.domain.todo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ToDoRepository {
    @Select("select * from todos")
    List<ToDoEntity> findAll();

    @Insert("insert into todos (summary,description) values (#{summary},#{description})")
    void insert(String summary, String description);

    @Select("select * from todos where id = #{todoId}")
    ToDoEntity findById(long todoId);

    @Delete("delete from todos where id = #{todoId}")
    void deleteById(long todoId);

    @Update("update todos set isCompleted = true where id = #{todoId}")
    void completeById(long todoId);
}
