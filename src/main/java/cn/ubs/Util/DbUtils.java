package cn.ubs.Util;


import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.function.Consumer;

/*
    mybatis 开启批量处理插入逻辑
 */
@Component
public class DbUtils {

    @Resource(name = "cwSqlSessionTemplate")
    @Qualifier
    private SqlSessionTemplate sqlSessionTemplate;

    public <T> void batchInsert(Class<T> mapperClass, Consumer<T> consumer){

//        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        try {
            T mapper = sqlSession.getMapper(mapperClass);
            consumer.accept(mapper);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

    }
}
