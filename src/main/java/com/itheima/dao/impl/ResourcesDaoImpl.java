package com.itheima.dao.impl;

import com.itheima.dao.ResourcesDao;
import org.springframework.stereotype.Repository;

@Repository
public class ResourcesDaoImpl implements ResourcesDao {
    public boolean readResources(String url,String password){
        //Ä£ÄâÐ£Ñé
        return password.equals("root");
    }
}
