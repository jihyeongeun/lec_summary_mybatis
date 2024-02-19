package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {
    public static void main(String[] args) {
        String resource = "mybatis.config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);  // inputStream 이란 설계도를 불러옴

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  // 설계도를 주면서 제품생산
            SqlSession session = sqlSessionFactory.openSession(false);    //자동커밋 안되게함.
            java.util.Date date = session.selectOne("mapper.selectNow");
            System.out.println("date = " + date);

            session.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
