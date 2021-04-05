package top.lixiang007.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import top.lixiang007.po.User;

import java.io.InputStream;

public class UserTest {
    @Test
    public void UserMybatisTest() throws Exception{
        // 1、读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream =
                Resources.getResourceAsStream(resource);
        // 2、根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        // 3、通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user= sqlSession.selectOne("top.lixiang007.mapper.UserMapper.findUserById",1);
        System.out.println(user.toString());
        sqlSession.close();
    }
}
