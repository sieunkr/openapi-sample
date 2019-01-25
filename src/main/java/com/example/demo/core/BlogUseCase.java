package com.example.demo.core;

import com.example.demo.core.dto.ResponseNaverBlog;
import reactor.core.publisher.Mono;

public interface BlogUseCase {
    Mono<ResponseNaverBlog> findBlogByQuery(String query);
}
