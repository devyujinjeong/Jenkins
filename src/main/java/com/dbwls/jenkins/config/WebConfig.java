package com.dbwls.jenkins.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                /* NodePort에 설정 된 30000번 포트에서 오는 연결에 대한
                * CORS 설정 해제 */
                /* Ingrtess 설정으로  내부적으로 통신이 수행 되므소 CORS 설정이 없어도 됨)*/
                .allowedOrigins("http://localhost:30000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
