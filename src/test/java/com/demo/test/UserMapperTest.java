package com.demo.test;

import com.demo.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UserMapperTest {
    private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void testInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("123456");
        int ret = sqlSession.insert("user.addUser", user);
        logger.debug("total insert row: {}", ret);
        sqlSession.close();

    }

}
