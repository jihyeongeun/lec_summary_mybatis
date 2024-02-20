package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSession getSqlSession(){
        if (sqlSessionFactory == null){                                                          // 메소드가 호출될때 factory가 없다면
            String resource = "com/ohgiraffers/section01/xmlconfig/mybatis-config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);               // inputstream을 통해 resource 설계도를 가져와서
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);           // builder를 통해 객체를 만듬
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory.openSession(false);                                          // 수동 커밋
    }
}
