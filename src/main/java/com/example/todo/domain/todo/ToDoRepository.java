package com.example.todo.domain.todo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ToDoRepository {
    @Select("select * from todos")
    List<ToDoEntity> findAll();

    @Insert("insert into todos (summary,description,isCompleted) values (#{summary},#{description},false)")
    void insert(String summary, String description);

    @Select("select * from todos where id = #{todoId}")
    ToDoEntity findById(long todoId);

    @Delete("delete from todos where id = #{todoId}")
    void deleteById(long todoId);

    @Update("update todos set isCompleted = true where id = #{todoId}")
    void completeById(long todoId);

    @Update("update todos set isCompleted = false where id = #{todoId}")
    void restorationById(long todoId);

    @Update("update todos set summary = #{summary}, description = #{description} where id = #{todoId}")
    void editById(long todoId, String summary, String description);

}
