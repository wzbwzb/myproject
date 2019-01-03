package com.myproject.demo.dao;

import com.myproject.demo.entity.InterFace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterFaceDao {

    public void insertInterFace(@Param("saveInterFace")InterFace saveInterFace);
}
