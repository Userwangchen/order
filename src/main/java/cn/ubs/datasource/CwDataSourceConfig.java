package cn.ubs.datasource;


import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
@MapperScan(basePackages = {"cn.ubs.mapper"})
public class CwDataSourceConfig {


    @Bean(name="cwDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.cw")
    public HikariDataSource cwDataSource(){
        return new HikariDataSource();
    }

    @Bean("cwSqlSessionFactory")
    public SqlSessionFactory cwSqlSessionFactory()throws Exception{
        SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
        ssf.setDataSource(cwDataSource());

        //设置扫描路径
        ssf.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml")
        );
        return ssf.getObject();
    }

    @Bean(name = "cwSqlSessionTemplate")
    public SqlSessionTemplate cwSqlSessionTemplate()throws Exception{
        return new SqlSessionTemplate(cwSqlSessionFactory());
    }

    public TransactionManager cwTransactionManager(){
        return new DataSourceTransactionManager(cwDataSource());
    }

}
