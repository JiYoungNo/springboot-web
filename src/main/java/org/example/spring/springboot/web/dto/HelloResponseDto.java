package org.example.spring.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //final 필드가 포한된 생성자를 생성해줌
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
