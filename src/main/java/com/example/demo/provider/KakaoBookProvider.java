package com.example.demo.provider;

import com.example.demo.core.BookUseCase;
import com.example.demo.core.dto.ResponseKakaoBook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class KakaoBookProvider implements BookUseCase {

    @Value("${kakao.openapi.book.url}")
    private String kakaoOpenApiBookUrl;

    @Value("${kakao.openapi.authorization}")
    private String kakaoOpenApiAuthorization;

    @Override
    public Mono<ResponseKakaoBook> findBookByQuery(String query) {

        return WebClient.create(kakaoOpenApiBookUrl)
                .method(HttpMethod.GET)
                .uri("?query=" + query)
                .header("Authorization", "KakaoAK " + kakaoOpenApiAuthorization)
                .retrieve()
                .bodyToMono(ResponseKakaoBook.class);

    }
}
