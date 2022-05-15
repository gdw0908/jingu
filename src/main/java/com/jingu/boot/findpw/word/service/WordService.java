package com.jingu.boot.findpw.word.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jingu.boot.findpw.word.dao.WordDao;

@Service
public class WordService {
	Logger log = LoggerFactory.getLogger(WordService.class);
	
	@Autowired
	private WordDao wordDao;
	
	public Map<String, Object> select_word_list(Map<String, Object> param) {
		return wordDao.select_word_list(param);
	}
	
	public int insert_word(Map<String, Object> param) {
		return wordDao.insert_word(param);
	}
}
