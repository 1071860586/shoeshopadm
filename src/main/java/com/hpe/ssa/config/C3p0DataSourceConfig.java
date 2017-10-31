package com.hpe.ssa.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;


@Configuration
@PropertySource("classpath:properties/db.properties")
@MapperScan(basePackages = "com.hpe.ssa.mapper")
public class C3p0DataSourceConfig {
    @Value("${jdbc.driverClass}")
    private String driverClassName;

    @Value("${jdbc.jdbcUrl}")
    private String dbUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${maxPoolSize}")
    private int maxPoolSize;

    @Value("${minPoolSize}")
    private int minPoolSize;

    @Value("${initialPoolSize}")
    private int initialPoolSize;

    @Value("${checkoutTimeout}")
    private int checkoutTimeout;

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driverClassName);
            dataSource.setJdbcUrl(dbUrl);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setMaxPoolSize(maxPoolSize);
            dataSource.setMinPoolSize(minPoolSize);
            dataSource.setCheckoutTimeout(checkoutTimeout);
            dataSource.setInitialPoolSize(initialPoolSize);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:mapper/*.xml"));
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.open.ssm.model");//别名，让*Mpper.xml实体类映射可以不加上具体包名
        return sqlSessionFactoryBean;
    }
}