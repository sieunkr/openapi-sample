package com.example.demo.core;

import com.example.demo.core.dto.ResponseKakaoBook;
import reactor.core.publisher.Mono;

public interface BookUseCase {
    Mono<ResponseKakaoBook> findBookByQuery(String query);
}
