package com.example.demo.core;

import com.example.demo.core.dto.ResponseKakaoTranslation;
import reactor.core.publisher.Mono;

public interface TranslationUseCase {
    Mono<ResponseKakaoTranslation> translate(String query);
}
