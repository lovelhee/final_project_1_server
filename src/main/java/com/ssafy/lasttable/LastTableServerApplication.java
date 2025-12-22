package com.ssafy.lasttable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.lasttable.**.repository")
public class LastTableServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LastTableServerApplication.class, args);
    }

    @Bean
    public OpenAPI lastTableApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("SSAFY Last Table API")
                        .description("라스트 테이블 관통 프로젝트 API 문서")
                        .version("1.0"));
    }
}