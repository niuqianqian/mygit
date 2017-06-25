package com.itheima.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.ssm.pojo.BaseDict;
import com.itheima.ssm.pojo.Customer;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.service.BaseDictService;
import com.itheima.ssm.service.CustomerService;
import com.itheima.ssm.utils.Page;

@Controller
public class CustomerController {
	//注入BaseDictService
	@Autowired
	private BaseDictService baseDictService;
	//注入CustomerService
	@Autowired
	private CustomerService customerService;

	// 客户来源
		@Value("${CUSTOMER_FROM_TYPE}")
		private String CUSTOMER_FROM_TYPE;
		// 客户行业
		@Value("${CUSTOMER_INDUSTRY_TYPE}")
		private String CUSTOMER_INDUSTRY_TYPE;
		// 客户级别
		@Value("${CUSTOMER_LEVEL_TYPE}")
		private String CUSTOMER_LEVEL_TYPE;
	
	//点击 客户管理 查询 分页 都是list.action
	@RequestMapping("/customer/list.action")    //  http://localhost:8080/crm/customer/list.action
	                                            //  ${pageContext.request.contextPath }/customer/list.action										
	public String list(Model model,QueryVo vo){
		//查询  客户名称(模糊查询) 客户来源,所属行业,客户级别(下拉框) 字典查询
		// 客户来源
		List<BaseDict> fromType = baseDictService.selectBaseDictByTypeCode(CUSTOMER_FROM_TYPE);//002
		// 所属行业
		List<BaseDict> industryType =baseDictService.selectBaseDictByTypeCode(CUSTOMER_INDUSTRY_TYPE);//001
		// 客户级别
		List<BaseDict> levelType =baseDictService.selectBaseDictByTypeCode(CUSTOMER_LEVEL_TYPE);//006
		
		//通过页面数据查询分页
		Page<Customer> page=customerService.selectPageByQueryVo(vo);
		model.addAttribute("page",page);
		
		//下拉列表显示内容
		model.addAttribute("fromType",fromType );
		model.addAttribute("industryType",industryType );
		model.addAttribute("levelType",levelType );
		
				
		return "customer";
	}

	//点击修改 弹出修改页面 根据id显示信息
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody Customer edit(Integer id){
		
	  return	customerService.selectCustomerById(id);
	}
	
	//点击修改页面的保存修改  然后更新数据库信息
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody String update(Customer customer){
		customerService.updateCustomer(customer);
		return "OK";
	}
	
	//点击删除 删除客户
	@RequestMapping(value="customer/delete.action")
	public @ResponseBody String delete(Integer id){
		customerService.deleteCustomer(id);
		return "ok";
	}
}
