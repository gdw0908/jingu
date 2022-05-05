package com.jingu.boot.findpw.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jingu.boot.findpw.common.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan(
    basePackages = {"com.jingu.boot.findpw"}, 
    useDefaultFilters = false,
    includeFilters = {
        @ComponentScan.Filter(Service.class),
        @ComponentScan.Filter(Repository.class),
        @ComponentScan.Filter(Bean.class),
        @ComponentScan.Filter(Component.class)
    }
)
@EnableTransactionManagement
public class RootApplicationConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setTypeAliases(new Class<?>[] { ConvertMap.class });
        sqlSessionFactoryBean.setTypeAliasesPackage("com.jingu.boot.findpw");
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:**/dao/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate", destroyMethod = "clearCache")
    public SqlSessionTemplate sqlSessionTemplate(DataSource datasource) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory(datasource));
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource datasource) throws Exception {
        return new DataSourceTransactionManager(datasource);
    }
}
