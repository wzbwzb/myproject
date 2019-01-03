package com.myproject.demo.services;

import com.myproject.demo.dao.InterFaceDao;
import com.myproject.demo.entity.InterFace;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InterFaceServices {

    @Resource
    private InterFaceDao interFaceDao;

    public void insertInterFace(InterFace interFace){
        interFaceDao.insertInterFace(interFace);
    }
}
