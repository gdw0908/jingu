package com.jingu.boot.findpw.word.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jingu.boot.findpw.common.dao.BaseDao;

@Repository
public class WordDao extends BaseDao {
	public Map<String, Object> select_payment(Map<String, Object> param) {
		return getSqlSession().selectOne(getQueryStatement("select_payment"), param);
	}
}
