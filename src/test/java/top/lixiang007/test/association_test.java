package top.lixiang007.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.lixiang007.po.Customer;
import top.lixiang007.utils.MybatisUtils;

public class association_test {
    @Test
    public void test1(){
        SqlSession sqlSession= MybatisUtils.getSession();
        Customer customer =sqlSession.selectOne("top.lixiang007.mapper.CustomerMapper.findUserWithOrders",1);
        System.out.println(customer);
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession= MybatisUtils.getSession();
        Customer customer =sqlSession.selectOne("top.lixiang007.mapper.OrdersMapper.findlx4",1);
        System.out.println(customer);
        sqlSession.close();
    }
}
