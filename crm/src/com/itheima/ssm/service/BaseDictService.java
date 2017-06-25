package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.pojo.BaseDict;

public interface BaseDictService {

	//查询所有
		public List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
