package com.example.demo.provider;

import com.example.demo.core.BlogUseCase;
import com.example.demo.core.dto.ResponseNaverBlog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class NaverBlogProvider implements BlogUseCase {

    @Value("${naver.openapi.blog.url}")
    private String naverOpenApiUrl;

    @Value("${naver.openapi.client.id}")
    private String naverOpenApiClientId;

    @Value("${naver.openapi.client.secret}")
    private String naverOpenApiClientSecret;


    @Override
    public Mono<ResponseNaverBlog> findBlogByQuery(String query) {

        return WebClient.create(naverOpenApiUrl)
                .method(HttpMethod.GET)
                .uri("?query=" + query)
                .header("X-Naver-Client-Id", naverOpenApiClientId)
                .header("X-Naver-Client-Secret", naverOpenApiClientSecret)
                .retrieve()
                .bodyToMono(ResponseNaverBlog.class);

    }
}
