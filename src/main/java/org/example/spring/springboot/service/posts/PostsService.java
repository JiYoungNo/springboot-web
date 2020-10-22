package org.example.spring.springboot.service.posts;

import lombok.RequiredArgsConstructor;
import org.example.spring.springboot.domain.posts.Posts;
import org.example.spring.springboot.domain.posts.PostsRepository;
import org.example.spring.springboot.web.dto.PostsListResponseDto;
import org.example.spring.springboot.web.dto.PostsResponseDto;
import org.example.spring.springboot.web.dto.PostsSaveRequestDto;
import org.example.spring.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //readOnly 속성은 조회 메소드에 사용하면 트랜젝션 범위는 유지하되 조회 속도를 개선해준다.
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당개시글이 없습니다. id=" +id));
        postsRepository.delete(posts);
    }
}
