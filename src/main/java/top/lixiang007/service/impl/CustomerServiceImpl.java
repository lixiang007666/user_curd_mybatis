package top.lixiang007.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lixiang007.mapper.CustomerMapper;
import top.lixiang007.po.Customer;
import top.lixiang007.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	//注解注入CustomerMapper
	@Autowired
	private CustomerMapper customerMapper;
	//添加客户
	public void addCustomer(Customer customer) {
		this.customerMapper.addCustomer(customer);
		int i=1/0; //模拟添加操作后系统突然出现的异常问题
	}
}
