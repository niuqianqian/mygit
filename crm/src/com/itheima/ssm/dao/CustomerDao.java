package com.itheima.ssm.dao;

import java.util.List;

import com.itheima.ssm.pojo.BaseDict;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.utils.Page;

public interface CustomerDao {

	//通过页面数据查询分页
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	//总记录数
	public int countCustomerByQueryVo(QueryVo vo);
	//结果集	
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	//根据id查询客户
	public Customer selectCustomerById(Integer id);
	//保存修改后的客户
	public void updateCustomer(Customer customer);
	//删除客户
	public void deleteCustomer(Integer id);
	
}
