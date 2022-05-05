package com.jingu.boot.findpw.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BaseDao {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    public final SqlSession getSqlSession() {
        return sqlSessionTemplate;
    }

    protected final String getQueryStatement(String queryId) {
        return this.getClass().getName()+"."+queryId;
    }

}
