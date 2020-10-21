package org.example.spring.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.spring.springboot.service.posts.PostsService;
import org.example.spring.springboot.web.dto.PostsResponseDto;
import org.example.spring.springboot.web.dto.PostsSaveRequestDto;
import org.example.spring.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //업데이트
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findBy(id);
    }
}
