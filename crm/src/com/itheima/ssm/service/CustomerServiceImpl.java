package com.itheima.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.ssm.dao.CustomerDao;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
    //注入CustomerDao
	@Autowired
	private CustomerDao customerDao;

	//通过页面数据查询分页
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page=new Page<Customer>();
		
		//当前页
		if(vo.getPage()==null){
			vo.setPage(1);
		}
		page.setPage(vo.getPage());
		
		//每页显示数
		//page.setSize(5);
		vo.setSize(5);
		page.setSize(vo.getSize());
		//开始行
		vo.setStart((vo.getPage()-1)*vo.getSize());
		
		//总记录数
		page.setTotal(customerDao.countCustomerByQueryVo(vo));
		//结果集
		page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		return page;
	}

	//根据id查询客户
	public Customer selectCustomerById(Integer id) {
		return customerDao.selectCustomerById(id);
	}

	//保存修改后的客户
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}

	//删除客户
	public void deleteCustomer(Integer id) {
		customerDao.deleteCustomer(id);
	}
}
