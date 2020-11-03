package org.example.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 메인 클래스
 * 프로젝트 최상단에 위치 -> Application이 있는 위치부터 설정을 읽어옴
 * 
 */
//@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
