package top.lixiang007.test;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import oracle.jrockit.jfr.parser.ChunkParser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.lixiang007.po.Customer;
import top.lixiang007.utils.MybatisUtils;

/**
 * 入门程序测试类
 */
public class MybatisTest {
    /**
     * 根据客户编号批量查询客户信息
     */
    @Test
    public void findCustomerByIdsTest(){
        // 获取SqlSession
        MybatisUtils lx=new MybatisUtils();
        SqlSession sqlSession=lx.getSession();
        // 创建List集合，封装查询id
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        // 执行SqlSession的查询方法，返回结果集
        List<Customer> customers = sqlSession.selectList("top.lixiang007.mapper"
                + ".CustomerMapper.findCustomerByIds", ids);
        // 输出查询结果信息
        for (Customer customer : customers) {
            // 打印输出结果
            System.out.println(customer);
        }
        // 关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void findCustomerByNameTest2(){
        // 通过工具类生成SqlSession对象
        SqlSession session = MybatisUtils.getSession();
        // 创建Customer对象，封装查询的条件
        Customer customer =new Customer();
        customer.setUsername("j");
        // 执行sqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("top.lixiang007.mapper"
                + ".CustomerMapper.findCustomerByName2", customer);
        // 输出查询结果信息
        for (Customer customer2 : customers) {
            // 打印输出结果
            System.out.println(customer2);
        }
        // 关闭SqlSession
        session.close();
    }
    /**
     * 根据客户编号查询客户信息
     */
    @Test
    public void findCustomerByIdTest() throws Exception {
        MybatisUtils lx=new MybatisUtils();
        SqlSession sqlSession=lx.getSession();
        // 4、SqlSession执行映射文件中定义的SQL，并返回映射结果
        Customer customer = sqlSession.selectOne("top.lixiang007.mapper"
                + ".CustomerMapper.findCustomerById", 1);
        // 打印输出结果
        System.out.println(customer.toString());
        // 5、关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void  findCustomerByJobTest() throws Exception{
        MybatisUtils lx=new MybatisUtils();
        SqlSession sqlSession=lx.getSession();
        List<Customer> l=sqlSession.selectList("top.lixiang007.mapper"
                + ".CustomerMapper.findlx");
        for(Customer c:l){
            System.out.println(c);
        }
        sqlSession.close();
    }
    @Test
    public void  findCustomerByNameOrJobTest() throws Exception{
        MybatisUtils lx=new MybatisUtils();
        SqlSession sqlSession=lx.getSession();
        Customer c=new Customer();
        c.setJobs("doctor");
        List<Customer> l=sqlSession.selectList("top.lixiang007.mapper"
                + ".CustomerMapper.findlx2",c);
        for(Customer c2:l){
            System.out.println(c2);
        }
        sqlSession.close();
    }
    @Test
    public void rephpne() throws Exception{
        MybatisUtils lx=new MybatisUtils();
        SqlSession sqlSession=lx.getSession();
        Customer c=new Customer();
        c.setPhone("18966547895");
        int rows=sqlSession.update("top.lixiang007.mapper"
                + ".CustomerMapper.findlx3",c);
        if(rows > 0){
            System.out.println("您成功更新了"+rows+"条数据！");
        }else{
            System.out.println("执行更新操作失败！！！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 根据用户名称来模糊查询用户信息列表
     */
    @Test
    public void findCustomerByNameTest() throws Exception{
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Customer> customers = sqlSession.selectList("top.lixiang007.mapper"
                + ".CustomerMapper.findCustomerByName", "l");
        for (Customer customer : customers) {
            //打印输出结果集
            System.out.println(customer);
        }
        // 5、关闭SqlSession
        sqlSession.close();
    }

    /**
     * 添加客户
     */
    @Test
    public void addCustomerTest() throws Exception{
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行添加操作
        // 4.1创建Customer对象，并向对象中添加数据
        Customer customer = new Customer();
        customer.setUsername("jone");
        customer.setJobs("doctor");
        customer.setPhone("13756894215");
        // 4.2执行SqlSession的插入方法，返回的是SQL语句影响的行数
        int rows = sqlSession.insert("top.lixiang007.mapper"
                + ".CustomerMapper.addCustomer", customer);
        // 4.3通过返回结果判断插入操作是否执行成功
        if(rows > 0){
            System.out.println("您成功插入了"+rows+"条数据！");
        }else{
            System.out.println("执行插入操作失败！！！");
        }
        // 4.4提交事务
        sqlSession.commit();
        // 5、关闭SqlSession
        sqlSession.close();
    }

    /**
     * 更新客户
     */
    @Test
    public void updateCustomerTest() throws Exception{
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行更新操作
        // 4.1创建Customer对象，对对象中的数据进行模拟更新
        Customer customer = new Customer();
        customer.setId(8);
        customer.setUsername("joney");
        customer.setJobs("worker");
        customer.setPhone("13756894215");
        // 4.2执行SqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = sqlSession.update("top.lixiang007.mapper"
                + ".CustomerMapper.updateCustomer", customer);
        // 4.3通过返回结果判断更新操作是否执行成功
        if(rows > 0){
            System.out.println("您成功修改了"+rows+"条数据！");
        }else{
            System.out.println("执行修改操作失败！！！");
        }
        // 4.4提交事务
        sqlSession.commit();
        // 5、关闭SqlSession
        sqlSession.close();
    }

    /**
     * 删除客户
     */
    @Test
    public void deleteCustomerTest() throws Exception{
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4、SqlSession执行删除操作
        // 4.1执行SqlSession的删除方法，返回的是SQL语句影响的行数
        int rows = sqlSession.delete("top.lixiang007.mapper"
                + ".CustomerMapper.deleteCustomer", 3);
        // 4.2通过返回结果判断删除操作是否执行成功
        if(rows > 0){
            System.out.println("您成功删除了"+rows+"条数据！");
        }else{
            System.out.println("执行删除操作失败！！！");
        }
        // 4.3提交事务
        sqlSession.commit();
        // 5、关闭SqlSession
        sqlSession.close();
    }

}
