package com.yuenwk.tiny;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@SpringBootApplication
@MapperScan({
        "com.yuenwk.*.mapper",
        "com.yuenwk.*.*.mapper",
        "com.yuenwk.*.*.*.mapper",
})
public class TinyApplication {

    public static void main(String[] args) throws IOException {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

        SpringApplication.run(TinyApplication.class, args);
    }

}
