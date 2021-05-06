package com.google.repository;

import com.google.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
    // 自定义方法放，名字必须与数据库表字段对应。★
    List<Alien> findByAname(String aname);

    List<Alien> findByAnameOrderByAidDesc(String aname);

    // 自定义方法，不使用 ByName 而根据名字查找
    // :name 为占位符。find 函数中的 aname 参数传递给 @Param 中的 name 参数，然后传递给 :name 。★
    @Query("from Alien where aname=:name order by aid desc")
    List<Alien> find(@Param("name") String aname);
}
