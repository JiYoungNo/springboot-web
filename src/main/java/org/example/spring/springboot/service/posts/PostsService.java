package org.example.spring.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.spring.springboot.domain.posts.Posts;
import org.example.spring.springboot.domain.posts.PostsRepository;
import org.example.spring.springboot.web.dto.PostsResponseDto;
import org.example.spring.springboot.web.dto.PostsSaveRequestDto;
import org.example.spring.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts =  postsRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findBy(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
