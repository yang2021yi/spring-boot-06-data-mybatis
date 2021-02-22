package com.yang.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @author yangdongyi
 * @create 2020-12-23 19:57
 */

@org.springframework.context.annotation.Configuration
public class MybatisConfig {


    // 开启驼峰命名
    @Bean
    public ConfigurationCustomizer  configurationCustomizer(){

        return  new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);

            }
        };
    }
}
