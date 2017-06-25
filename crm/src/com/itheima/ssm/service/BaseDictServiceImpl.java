package com.itheima.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.ssm.dao.BaseDictDao;
import com.itheima.ssm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;
	//查询所有
	public List<BaseDict> selectBaseDictByTypeCode(String typecode) {
		
		return baseDictDao.selectBaseDictByTypeCode(typecode);
	}

}
