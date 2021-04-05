package top.lixiang007.dao;

import top.lixiang007.po.Customer;

public interface CustomerDao {
	// 通过id查询客户
	public Customer findCustomerById(Integer id);
}
