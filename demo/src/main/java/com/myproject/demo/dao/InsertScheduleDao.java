package com.myproject.demo.dao;

import com.myproject.demo.entity.InsertSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface InsertScheduleDao {
    public void insertSchedule(@Param("insertschedule")InsertSchedule insertSchedule);
}
