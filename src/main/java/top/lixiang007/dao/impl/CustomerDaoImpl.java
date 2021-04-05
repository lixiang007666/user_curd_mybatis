package top.lixiang007.dao.impl;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import top.lixiang007.dao.CustomerDao;
import top.lixiang007.po.Customer;

public class CustomerDaoImpl 
                      extends SqlSessionDaoSupport implements CustomerDao {
	// 通过id查询客户
	public Customer findCustomerById(Integer id) {
         	return this.getSqlSession().selectOne("top.lixiang007.mapper"
				      + ".CustomerMapper.findCustomerById", id);
	}
}
