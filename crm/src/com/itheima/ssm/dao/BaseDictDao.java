package com.itheima.ssm.dao;

import java.util.List;

import com.itheima.ssm.pojo.BaseDict;

public interface BaseDictDao {

	//查询所有
	public List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
