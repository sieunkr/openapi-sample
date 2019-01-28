package com.example.demo.provider;

import com.example.demo.core.TranslationUseCase;
import com.example.demo.core.dto.ResponseKakaoBook;
import com.example.demo.core.dto.ResponseKakaoTranslation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class KakaoTranslationProvider implements TranslationUseCase {

    @Value("${kakao.openapi.translation.url}")
    private String kakaoOpenApiTranslationUrl;

    @Value("${kakao.openapi.authorization}")
    private String kakaoOpenApiAuthorization;

    @Override
    public Mono<ResponseKakaoTranslation> translate(String query) {

        return WebClient.create(kakaoOpenApiTranslationUrl)
                .method(HttpMethod.GET)
                .uri("?query=" + query + "&src_lang=" + "en" + "&target_lang=" + "kr")
                .header("Authorization", "KakaoAK " + kakaoOpenApiAuthorization)
                .retrieve()
                .bodyToMono(ResponseKakaoTranslation.class);
    }
}
