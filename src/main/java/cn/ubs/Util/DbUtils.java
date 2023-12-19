package cn.ubs.Util;


import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/*
    mybatis 开启批量处理插入逻辑
 */
@Component
public class DbUtils {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public <T> void batchInsert(Class<T> mapperClass, Consumer<T> consumer){

        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);

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
