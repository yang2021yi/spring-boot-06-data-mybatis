package com.yang.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangdongyi
 * @create 2020-12-23 16:15
 */


@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return  new DruidDataSource();
    }

    // 配置druid的监控
    // 1.配置一个后台管理的servlet
    @Bean
    public ServletRegistrationBean  statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        // 配置从初始化参数
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");// 默认允许所有访问
        bean.setInitParameters(initParams);

        return bean;

    }
    // 2. 配置web 监控的filter

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        // 设置不拦截 的请求
        initParams.put("exclusions","*.css,*.js,/druid/*");
        bean.setInitParameters(initParams);

        // 拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
